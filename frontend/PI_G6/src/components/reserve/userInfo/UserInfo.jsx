import React from 'react'
import './UserInfo.css'

const UserInfo = () => {
  return (
    <div className='reserve-grid-container'>
        <p>Completá tus datos</p>
        <div className='reserve-grid-item name'>
            <div>nombre</div>
            <input placeholder='Bruno'></input>
        </div>
        <div className='reserve-grid-item surname'>
            <div>Apellido</div>
            <input placeholder='Rodriguez'></input>
        </div>
        <div className='reserve-grid-item email'>
            <div>Correo Electronico</div>
            <input placeholder='brodriguez@gmail.com'></input>
        </div>
        <div className='reserve-grid-item city'>
            <div>Ciudad</div>
            <input placeholder='ciudad'></input>
        </div>
    </div>
  )
}

export default UserInfo
