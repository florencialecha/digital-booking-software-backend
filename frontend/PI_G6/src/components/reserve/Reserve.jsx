import React, { useState } from 'react'
import UserInfo from './UserInfo'
import styles from './Reserve.module.css'
import ProductHeader from '../details/ProductHeader/ProductHeader'
import Calendar from '../details/Calendar/Calendar.jsx'
import ArrivalInfo from './ArrivalInfo'
import Policies from '../details/ProductPolicies/Policies'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLocationDot } from '@fortawesome/free-solid-svg-icons'
import CardStars from '../Home/CardSuggested/CardStars'
import axios from 'axios'
import { apiReserve } from '../../utils/apiEndpoints'
import ReserveAlert from './ReserveAlert'
import Swal from 'sweetalert2'


const reserve = () => {
  const [showAlert, setShowAlert] = useState(false);
  const product = JSON.parse(localStorage.getItem('productSelected'))
  const reservations = JSON.parse(localStorage.getItem('reservation'))
  const newReservation = []
  {console.log(newReservation)}
  reservations?.map((reservation) => {
    newReservation.push(reservation.replaceAll('/', '-'))
  } )

  const categoryTitle = `${product.category.title}`.toUpperCase()

  // const handleReservaExitosa = () => {
  //   setShowAlert(true);
  //   setTimeout(() => {
  //     setShowAlert(false);
  //   }, 3000);
  // };

  const onReserveConfirm = () => {
    axios.post(apiReserve, { 
      startTime: '12:00:23',
      checkIn: newReservation[0],
      checkOut: newReservation[1],
      product: 7,
      user: 1
    })
    .then(response => {
      console.log(response);
      // handleReservaExitosa()
      const Toast = Swal.mixin({
        toast: true,
        position: 'center',
        showConfirmButton: false,
        timer: 2500,
        width: '50%',
        didOpen: (toast) => {
          toast.addEventListener('mouseenter', Swal.stopTimer)
          toast.addEventListener('mouseleave', Swal.resumeTimer)
        }
      })
      
      Toast.fire({
        icon: 'success',
        title: '¡Muchas gracias!',
        text: 'Su reserva se ha realizado con exito'
      })
    })
    .catch(error => {
      console.log(error);
    });
  }

  


  return (
      <div className={styles.reserveGlobalContainer}>
        <ProductHeader generalInfo={product}/>
        <p className={styles.dataFormTitle}>Completá tus datos</p>
        <div className={styles.reservePage}>
            <UserInfo styles={styles}/>
            <div className={styles.reserveProduct}>
              <p>Detalles de la reserva</p>
              <div className={styles.cardContainer}>
                <img src={product.images[0]?.imageUrl} alt='imagen del producto'/>
                <div>
                  <div className={styles.productinformation}>
                    <p className={styles.productCategory}>{categoryTitle}</p>
                    <p className={styles.productTitle}>{product.title}</p>
                    <CardStars {...product} styles={styles} />
                    <div className={styles.productLocation}>
                      <FontAwesomeIcon icon={faLocationDot} />
                      <p>{product.address?.street} {product.address?.number}, {product.address?.city}, {product.address?.state}, {product.address?.country}</p>
                    </div>
                  </div>
                  <div className={styles.reserveDates}>
                    <hr />
                    <div className={styles.reserveCheckIn}>
                      <p>Check in</p>
                      <p>{reservations[0]}</p>
                    </div>
                    <hr />
                    <div className={styles.reserveCheckOut}>
                      <p>Check out</p>
                      <p>{reservations[1]}</p>
                    </div>
                    <hr />
                  </div>
                  <button className={styles.confirmReserveButton} onClick={onReserveConfirm}>Confirmar reserva</button>
                  {/* <div className={ showAlert ? styles.alertTrue : styles.alertFalse}>
                    <ReserveAlert styles={styles} />
                  </div> */}
                </div>
              </div>
            </div>
            <div className={styles.reserveCalendar}>
              <p>Seleccioná tu fecha de reserva</p>
              <Calendar styles={styles} reservations={product.availability}/>
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
