/* eslint-disable react/prop-types */
import React from 'react'

const UserInfo = ({ styles }) => {
  return (
    <div className={styles.reserveGridContainer}>
        <div className={`${styles.reserveGridItem}` + ' ' + `${styles.name}` + ' ' + `${styles.fielDisable}`}>
            <div>Nombre</div>
            <input placeholder='Bruno'></input>
        </div>
        <div className={`${styles.reserveGridItem}` + ' ' + `${styles.surname}` + ' ' + `${styles.fielDisable}`}>
            <div>Apellido</div>
            <input placeholder='Rodriguez'></input>
        </div>
        <div className={`${styles.reserveGridItem}` + ' ' + `${styles.email}` + ' ' + `${styles.fielDisable}`}>
            <div>Correo Electronico</div>
            <input placeholder='brodriguez@gmail.com'></input>
        </div>
        <div className={`${styles.reserveGridItem}` + ' ' + `${styles.city}`}>
            <div>Ciudad</div>
            <input placeholder='ciudad'></input>
        </div>
    </div>
  )
}

export default UserInfo
