import React, { useState, useEffect } from 'react';
import axios from 'axios';
import styles from './AdminPage.module.css';
import ProductHeader from '../details/ProductHeader/ProductHeader.jsx';
import ProductoInfo from './adminPageComponents/ProductoInfo';
import FeatureSelector from './adminPageComponents/FeatureSelector';
import ProductPoliciesDetails from './adminPageComponents/ProductPoliciesDetails';
import ProductInputImages from './adminPageComponents/ProductInputImages';
import { apiProduct } from '../../utils/apiEndpoints';
import Swal from "sweetalert2";
import { useNavigate } from 'react-router';

const AdminPage = () => {
  const [productName, setProductName] = useState('');
  const [productCategory, setProductCategory] = useState('');
  const [productAddress, setProductAddress] = useState('');
  const [productCity, setProductCity] = useState('');
  const [productDescription, setProductDescription] = useState('');
  const [features, setFeatures] = useState([]);
  const [rules, setRules] = useState('')
  const [security, setSecurity] = useState('')
  const [cancellation, setCancellation] = useState('')
  const [productImages, setProductImages] = useState([])
  const [imageList, setImageList] = useState([])
  const navigate = useNavigate('/myreserves')

  const productProp = {
    styles: styles,
    productName: productName,
    productCategory: productCategory,
    productAddress: productAddress,
    productCity: productCity,
    productDescription: productDescription,
    features: features,
    rules: rules,
    security: security,
    cancellation: cancellation, 
    productImages: productImages,
    setProductName: setProductName,
    setProductCategory: setProductCategory,
    setProductAddress: setProductAddress,
    setProductCity: setProductCity,
    setProductDescription: setProductDescription,
    setFeatures: setFeatures,
    setRules: setRules,
    setSecurity: setSecurity,
    setCancellation: setCancellation,
    setProductImages: setProductImages,
  }

  function splitAddress(address) {
    const stringToSplit = address.split(' ');
    const iNumber = stringToSplit.findIndex(stringSplited => !isNaN(stringSplited) && parseInt(stringSplited) > 0);
    
    if (iNumber > -1) {
      const number = stringToSplit[iNumber];
      const street = stringToSplit.slice(0, iNumber).join(' ');
      return { number, street };
    }
    // Si no se encuentra un número, se devuelve la dirección completa
    return { address };
  }

  useEffect(() => {
    productImages.map((image, i) => {
      const imageObjet = { title: `Esta es la foto ${i+1} del producto`, imageUrl: `${image}`}
      setImageList([...imageList, imageObjet])
    })
  }, [productImages])

  const handleCreateProductClick = () => {
    const token = JSON.parse(localStorage.getItem('JWT'));
    axios
      .post(
        apiProduct,
        {
          title: productName,
          description: productDescription,
          stars: 3,
          scoring: 7,
          review: 'Muy bueno',
          category: productCategory,
          features: features,
          policy: {
              rules: rules,
              security: security,
              cancellation: cancellation
          },
          images: imageList,
          address: {  
            street: `${splitAddress(productAddress).street}`,
            number: `${splitAddress(productAddress).number}`,
            city: productCity,
          }
        },
        {
          headers: {
            "Content-Type": "application/json",
            Authorization: `Bearer ${token}`,
          },
        }
      )
      .then((response) => {
        const Toast = Swal.mixin({
          toast: true,
          position: "center",
          showConfirmButton: false,
          timer: 2500,
          width: "50%",
          didOpen: (toast) => {
            toast.addEventListener("mouseenter", Swal.stopTimer);
            toast.addEventListener("mouseleave", Swal.resumeTimer);
          },
        });
        
        Toast.fire({
          icon: "success",
          title: "¡Muchas gracias!",
          text: "Su reserva se ha realizado con éxito",
        }).then(() => {
          navigate('/');
        });
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className={styles.adminContainer}>
      <ProductHeader generalInfo={{ title: 'Administración' }} />
      <div className={styles.productCreateContainer}>
        <h2>Crear Propiedad</h2>
        <div className={styles.createProductAdminContainer}>
          <ProductoInfo props={productProp}/>
          <FeatureSelector props={productProp} />
          <ProductPoliciesDetails props={productProp} />
          <ProductInputImages props={productProp} />
          <button
            className={styles.createProductButton}
            onClick={handleCreateProductClick}
          >
            Crear
          </button>
        </div>
      </div>
    </div>
  )
};

export default AdminPage;
