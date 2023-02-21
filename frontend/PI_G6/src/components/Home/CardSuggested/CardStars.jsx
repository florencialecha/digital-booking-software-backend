import React from 'react'
// import { faS, faStar } from '@fortawesome/free-solid-svg-icons'
import './CardStars.css'

// eslint-disable-next-line react/prop-types
const CardStars = ({ stars }) => {
  const st = []

  for (let i = 1; i <= 5; i++) {
    let starFill = 'empty'
    if (stars >= i) {
      starFill = 'full'
    }
    st.push({ starFill, i })
  }

  return (
    <div className='stars-container'>
        {st.map((star) => <span className={star.starFill} key={star.i}>★</span>)}
    </div>
  )
}

export default CardStars
