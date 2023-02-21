import React from 'react'
import CardCategory from './CardCategory/CardCategory'
import data from '../../temp/apiCategories.json'
import './CardCategory/CardCategory.css'

const Carousel = () => {
  return (
    <div className='carousel'>
      <article>
        <p>Buscar por tipo de alojamiento</p>
      </article>
      <div className='slider-categories' id='slider-categories' >
        {data.map((category) => (
          <CardCategory key={category.id} {...category}/>
        ))}
      </div>
    </div>
  )
}

export default Carousel
