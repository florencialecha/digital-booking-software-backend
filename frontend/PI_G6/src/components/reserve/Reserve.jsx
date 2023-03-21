import React from 'react'
import UserInfo from './UserInfo'
import styles from './Reserve.module.css'
import ProductHeader from '../details/ProductHeader/ProductHeader'
import Calendar from '../details/Calendar/Calendar.jsx'
import ArrivalInfo from './ArrivalInfo'
import Policies from '../details/ProductPolicies/Policies'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLocationDot } from '@fortawesome/free-solid-svg-icons'
import CardStars from '../Home/CardSuggested/CardStars'

const reserve = () => {
  const product = JSON.parse(localStorage.getItem('hotelSelected'))
  const categoryTitle = `${product.category.title}`.toUpperCase()
  return (
      <div className={styles.reserveGlobalContainer}>
        <ProductHeader generalInfo={product}/>
        <p className={styles.dataFormTitle}>Completá tus datos</p>
        <div className={styles.reservePage}>
            <UserInfo styles={styles}/>
            <div className={styles.reserveProduct}>
              <p>Detalles de la reserva</p>
              <div className={styles.cardContainer}>
                <img src={product.imageList[0]?.imageUrl} alt='imagen del producto'/>
                <div>
                  <div className={styles.productinformation}>
                    <p className={styles.productCategory}>{categoryTitle}</p>
                    <p className={styles.productTitle}>{product.title}</p>
                    <CardStars {...product} styles={styles} />
                    <div className={styles.productLocation}>
                      <FontAwesomeIcon icon={faLocationDot} />
                      <p>{product.address.street} {product.address.number}, {product.address.city.name}, {product.address.city.state.name}, {product.address.city.state.country.name}</p>
                    </div>
                  </div>
                  <div className={styles.reserveDates}>
                    <hr />
                    <div className={styles.reserveCheckIn}>
                      <p>Check in</p>
                      <p>23/11/2021</p>
                    </div>
                    <hr />
                    <div className={styles.reserveCheckOut}>
                      <p>Check out</p>
                      <p>27/11/2021</p>
                    </div>
                    <hr />
                  </div>
                  <button className={styles.confirmReserveButton}>Confirmar reserva</button>
                </div>
              </div>
            </div>
            <div className={styles.reserveCalendar}>
              <p>Seleccioná tu fecha de reserva</p>
              <Calendar styles={styles}/>
            </div>
            <div className={styles.arrivalTime}>
              <p>Tu Horario de llegada</p>
              <ArrivalInfo styles={styles}/>
            </div>
        </div>
        <div className={styles.haveToKnow}>
          <p>Qué tenés que saber</p>
          <hr />
          <Policies policies={product.policy} styles={styles}/>
        </div>
      </div>
  )
}

export default reserve
