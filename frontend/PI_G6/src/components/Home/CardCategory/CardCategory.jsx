import React, { useContext } from 'react'
import './CardCategory.css'
import { GlobalContext } from '../../../utils/globalContext'

const Carousel = (category) => {
  const { dispatch } = useContext(GlobalContext)

  return (
    <div className='slider-item' id={category.id} onDoubleClick={() => dispatch({ type: 'data', payload: {data: category.id, categorySelected: category.title}})} >
        <img src={category.imageUrl} alt='' />
        <div>
            <p className='category-title  '>{category.title}</p>
            <p>{category.quantity} availables</p>
        </div>
    </div>
  )
}

export default Carousel
