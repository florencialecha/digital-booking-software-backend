import React from 'react'
import UserInfo from './userInfo/UserInfo'
import './Reserve.css'
const reserve = () => {
  return (
    <div className='reserve-page'>
        <UserInfo />
        <div className='reserve-product'>hotel</div>
        <div className='reserve-calendar'>calendar</div>
    </div>
  )
}

export default reserve
