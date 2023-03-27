import axios from 'axios'
import React, { useRef, useEffect, useState } from 'react'
import { motion } from 'framer-motion'
import CardCategory from './CardCategory/CardCategory'
import './CardCategory/CardCategory.css'
import { apiCategory } from '../../utils/apiEndpoints'

const Carousel = () => {
  const [width, setWidht] = useState(0)
  const [categorys, setCategorys] = useState([])

  const carousel = useRef()

  useEffect(() => {
    setWidht(carousel.current.scrollWidth - carousel.current.offsetWidth)
  }, [carousel.current])

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(apiCategory)
        setCategorys(response.data)
      } catch (error) {
        console.log('Error al obtener datos de la API. Usando datos estáticos...')
        const fallbackData = await axios.get('/apiCategories.json')
        setCategorys(fallbackData.data)
      }
    }
    fetchData()
  }, [])

  return (
    <motion.div ref={carousel} className='carousel' whileTap={{ cursor: 'grabbing' }}>
      <article>
        <p>Buscar por tipo de alojamiento</p>
      </article>
      <motion.div drag='x' dragConstraints={{ right: 0, left: -width }} className='slider-categories' id='slider-categories' >
        {categorys.map((category) => (
          <CardCategory key={category.id} {...category}/>
        ))}
      </motion.div>
    </motion.div>
  )
}

export default Carousel
