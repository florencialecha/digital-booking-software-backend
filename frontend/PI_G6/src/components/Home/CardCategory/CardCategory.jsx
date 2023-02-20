import React from 'react'
import './CardCategory.css'

const Carousel = (category) => {
  return (
    <div className='slider-item' id={`item-${category.id}`} >
        <img src={category.imageUrl} alt="" />
        <div>
            <p className='category-title  '>{category.title}</p>
            <p>{category.quantity} availables</p>
        </div>
    </div>
  )
}

export default Carousel
