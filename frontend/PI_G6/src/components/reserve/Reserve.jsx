import React from 'react'
import UserInfo from './userInfo/UserInfo'
import './Reserve.css'
const reserve = ({ generalInfo }) => {
  return (
    <div>
      <div className='reserve-page'>
          <UserInfo />
          <div className='reserve-product'>hotel</div>
          <div className='reserve-calendar'>calendar</div>
          <div className='reserve-checkIn'>Horario de llegada</div>
      </div>
    </div>
  )
}

export default reserve
