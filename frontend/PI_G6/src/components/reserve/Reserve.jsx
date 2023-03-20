import React from 'react'
import UserInfo from './UserInfo'
import styles from './Reserve.module.css'
import CardSuggested from '../Home/CardSuggested/CardSuggested'
import ProductHeader from '../details/ProductHeader/ProductHeader'
import Calendar from '../details/Calendar/Calendar.jsx'
import ArrivalInfo from './ArrivalInfo'

const reserve = () => {
  const product = JSON.parse(localStorage.getItem('hotelSelected'))

  return (
      <div className={styles.reserveGlobalContainer}>
        <ProductHeader generalInfo={product}/>
        <p className={styles.dataFormTitle}>Completá tus datos</p>
        <div className={styles.reservePage}>
            <UserInfo styles={styles}/>
            <div className={styles.reserveProduct}>
              <p>Detalles de la reserva</p>
              <CardSuggested { ...product } suggest={product} styles={styles}/>
              <div className={styles.reservedDates}>
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
            <div className={styles.reserveCalendar}>
              <p>Seleccioná tu fecha de reserva</p>
              <Calendar styles={styles}/>
            </div>
            <div className={styles.arrivalTime}>
              <p>Tu Horario de llegada</p>
              <ArrivalInfo styles={styles}/>
            </div>
            <div className={styles.haveToKnow}>Qué tenés que saber</div>
        </div>
      </div>
  )
}

export default reserve