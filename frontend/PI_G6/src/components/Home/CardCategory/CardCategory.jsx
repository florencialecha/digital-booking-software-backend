import React, { useContext } from 'react'
import './CardCategory.css'
import { GlobalContext } from '../../../utils/globalContext'

const Carousel = (category) => {
  const { dispatch } = useContext(GlobalContext)

  // const navigate = useNavigate()

  const handleClickCategory = (e) => {
    dispatch({ type: 'data', payload: e.target.id })
  }

  return (
    <div className='slider-item' id={category.id} onDoubleClick={handleClickCategory} >
        <img src={category.imageUrl} alt='' />
        <div>
            <p className='category-title  '>{category.title}</p>
            <p>{category.quantity} availables</p>
        </div>
    </div>
  )
}

export default Carousel
