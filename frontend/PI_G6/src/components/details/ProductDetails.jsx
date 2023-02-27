import { React, useEffect, useState } from 'react'
import { useParams } from 'react-router'
import './ProductDetails.css'

import axios from 'axios'

const ProductDetails = () => {
  const [product, setProduct] = useState(null)
  const { id } = useParams()

  useEffect(() => {
    axios.get(`https://jsonplaceholder.typicode.com/users/${id}`)
      .then(res => setProduct(res.data))
      .catch(error => console.log(error))
  }, [id])

  return (
   <div className='details'>
    <div className='details-header'>
        <div>
            <p>category</p>
            <p>hotel name</p>
        </div>
        <img src="" alt="icon" />
    </div>
    <div className='details-location'>
        <div>
            <p>location</p>
            <p>dist to center</p>
        </div>
        <div className='details-scoring'>
            <div>
                <p>scoring</p>
                <div>
                    <p>Muy bueno</p>
                    <p>Stars</p>
                </div>
            </div>
            <p>Rating</p>
        </div>
    </div>
    <div className='details-galery'>
        <div>
            <img src="" alt="share" />
            <img src="" alt="fav" />
        </div>
        <div className='details-images'>
            <img className='details-bigPicture' src="https://images.unsplash.com/photo-1521783988139-89397d761dce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1025&q=80" alt="" />
           <div className='details-smallPictures'>
            <img src="https://images.unsplash.com/photo-1521783988139-89397d761dce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1025&q=80" alt="" />
            <img src="https://images.unsplash.com/photo-1521783988139-89397d761dce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1025&q=80" alt="" />
            <img src="https://images.unsplash.com/photo-1521783988139-89397d761dce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1025&q=80" alt="" />
            <img src="https://images.unsplash.com/photo-1521783988139-89397d761dce?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1025&q=80" alt="" />
           </div>
           {/* <a href="">Ver Mas</a> */}
        </div>
        <div className='details-description'>Alojate en el corazon de buenos aires</div>
        <div className='details-char'>Caracteristicas disponibles</div>
        <div className='details-availableDates'>Fechas disponibles</div>
    </div>
   </div>
  )
}

export default ProductDetails
