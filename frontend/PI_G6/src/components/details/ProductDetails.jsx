import React from 'react'
import './ProductDetails.css'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import {
  faShareNodes,
  faHeart,
  faLocationDot
} from '@fortawesome/free-solid-svg-icons'
import Gallery from './Gallery/Gallery'
import ProductHeader from './ProductHeader/ProductHeader'
import Description from './ProductDescription/Description'
import Features from './ProductFeatures/Features'
import Policies from './ProductPolicies/Policies'
import Calendar from './Calendar/Calendar'
import Map from './Map/Map'
import CardStars from '../Home/CardSuggested/CardStars'

const ProductDetails = () => {
  const product = JSON.parse(localStorage.getItem('hotelSelected'))

  return (
    <>{console.log(product)}
      {product
        ? (
        <div className="details-container">
          <div className="details-header">
            <ProductHeader generalInfo={product} />
          </div>
          <div className="details-body">
            <div className="details-location-scoring-info">
              <div className="details-location">
                <div className="details-location-icon">
                  <FontAwesomeIcon icon={faLocationDot}></FontAwesomeIcon>
                </div>
                <div className="details-location-info">
                  <p>
                    {' '}
                    {product.address.street} {product.address.number}
                    {', '}
                    {product.address.city.name}
                    {', '}
                    {product.address.city.state.country.name}
                  </p>
                  <p className="details-distance">A 940 m del centro</p>
                </div>
              </div>
              <div className="details-scoring">
                <div className="details-review">
                  <p>{product.review}</p>
                    <CardStars {...product} />{' '}
                </div>
                <div className="details-score">
                  <p>{product.scoring}</p>
                </div>
              </div>
            </div>
            <div>
              <div className="details-share">
                <FontAwesomeIcon
                  icon={faShareNodes}
                  size="lg"
                ></FontAwesomeIcon>
                <FontAwesomeIcon icon={faHeart} size="lg"></FontAwesomeIcon>
              </div>
              <div className="details-galery">
                <Gallery pictures={product.imageList} />
              </div>
            </div>
            <div className="details-description">
              <h2>Alójate en el corazón de {product.address.city.name}</h2>
              <Description data={product} />
            </div>
            <h2>¿Qué ofrece este lugar?</h2>
            <hr className="details-line" />
            <div className="details-char">
              <Features specs={product.featureList} />
            </div>
            <div className="details-available-dates">
              <h2>Fechas disponibles</h2>
              <Calendar product={product}/>
              <div className="reservation-details">
                <p>Agregá tus fechas de viaje para obtener precios exactos</p>
                <button className="reservation-button"><a href={`/product/${product.id}/reserve`}>Iniciar reserva</a></button>
              </div>
            </div>
            <div className="details-map">
              <h2>¿Dónde vas a estar?</h2>

              <hr className="details-line" />
              <p>
                {product.address.city.name},{' '}
                {product.address.city.state.country.name}
              </p>
              <Map address={product.address} />
            </div>
            <div className="details-policies">
              <h2> ¿Qué tenés que saber?</h2>
              <hr className="details-line" />
              <Policies policies={product.policy} />
            </div>
          </div>
        </div>
          )
        : (
            ''
          )}
    </>
  )
}

export default ProductDetails
