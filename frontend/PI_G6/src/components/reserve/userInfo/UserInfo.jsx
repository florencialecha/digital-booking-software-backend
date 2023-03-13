import React from 'react'
import './UserInfo.css'

const UserInfo = () => {
  return (
    <div className='reserve-grid-container'>
        <p>Completá tus datos</p>
        <div className='reserve-grid-item'>
            <div>nombre</div>
            <input placeholder='Bruno'></input>
        </div>
        <div className='reserve-grid-item'>
            <div>Apellido</div>
            <input placeholder='Rodriguez'></input>
        </div>
        <div className='reserve-grid-item'>
            <div>Correo Electronico</div>
            <input placeholder='brodriguez@gmail.com'></input>
        </div>
        <div className='reserve-grid-item'>
            <div>Ciudad</div>
            <input placeholder='ciudad'></input>
        </div>
    </div>
  )
}

export default UserInfo
