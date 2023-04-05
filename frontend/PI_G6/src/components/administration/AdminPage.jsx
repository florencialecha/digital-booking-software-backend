import React, { useState } from 'react';
import axios from 'axios';
import styles from './AdminPage.module.css';
import ProductHeader from '../details/ProductHeader/ProductHeader.jsx';
import ProductoInfo from './adminPageComponents/ProductoInfo';
import FeatureSelector from './adminPageComponents/FeatureSelector';
import ProductPoliciesDetails from './adminPageComponents/ProductPoliciesDetails';
import ProductInputImages from './adminPageComponents/ProductInputImages';
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
    setProductName: setProductName,
    setProductCategory: setProductCategory,
    setProductAddress: setProductAddress,
    setProductCity: setProductCity,
    setProductDescription: setProductDescription,
    setFeatures: setFeatures,
    setRules: setRules,
    setSecurity: setSecurity,
    setCancellation: setCancellation,
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

  const productJson = {
    "title": `${productName}`,
    "description": `${productDescription}`,
    "stars": 3,
    "scoring": 7,
    "review": "Muy bueno",
    "category": `${productCategory}`,
    "features": `${features}`,
    "policy": {
        "rules": `${rules}`,
        "security": `${security}`,
        "cancellation": `${cancellation}`
    },
    "images": [
        {
            "title": "Esta es la foto de un hotel",
            "imageUrl": "https://images.unsplash.com/photo-1551882547-ff40c63fe5fa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
        },
        {
            "title": "Esta es la foto de un hotel",
            "imageUrl": "https://images.unsplash.com/photo-1560448204-e02f11c3d0e2?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
        },
        {
            "title": "Esta es la foto de un hotel",
            "imageUrl": "https://images.unsplash.com/photo-1522708323590-d24dbb6b0267?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=870&q=80"
        }
    ],
      "address": {
      "street": `${splitAddress(productAddress).street}`,
      "number": `${splitAddress(productAddress).number}`,
      "city": `${productCity}`
      }
    }
  
  const handleCreateProductClick = async () => {
    const token = localStorage.getItem('token');
    const config = {
      headers: {
        Authorization: `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
    };
    const data = {
      title: productName,
      category: productCategory,
      description: productDescription,
      features: features.map(feature => feature.id),
      address: {
        street: productAddress,
        city: productCity,
      },
    };
    try {
      const response = await axios.post('/api/products', data, config);
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div className={styles.adminContainer}>
      <ProductHeader generalInfo={{ title: 'Administración' }} />
      <div className={styles.productCreateContainer}>
        <h2>Crear Propiedad</h2>
        <div className={styles.createProductAdminContainer}>
          <ProductoInfo props={productProp}/>
          <FeatureSelector props={productProp} />
          {console.log(productJson)}
          <ProductPoliciesDetails props={productProp} />
          <ProductInputImages props={productProp} />
          {console.log(productJson)}
          <button
            className={styles.createProductButton}
            onClick={handleCreateProductClick}
          >
            Crear
          </button>
        </div>
      </div>
    </div>
  );
};

export default AdminPage;
