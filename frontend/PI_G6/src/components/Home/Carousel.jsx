import { React, useRef, useEffect, useState } from 'react'
import CardCategory from './CardCategory/CardCategory'
import data from '../../temp/apiCategories.json'
import './CardCategory/CardCategory.css'
import { motion } from 'framer-motion'

const Carousel = () => {
  const [width, setWidht] = useState(0)
  const carousel = useRef()

  useEffect(() => {
    setWidht(carousel.current.scrollWidth - carousel.current.offsetWidth)
  }, [])

  return (
    <motion.div ref={carousel} className='carousel' whileTap={{ cursor: 'grabbing' }}>
      <article>
        <p>Buscar por tipo de alojamiento</p>
      </article>
      <motion.div drag='x' dragConstraints={{ right: 0, left: -width }} className='slider-categories' id='slider-categories' >
        {data.map((category) => (
          <CardCategory key={category.id} {...category}/>
        ))}
      </motion.div>
    </motion.div>
  )
}

export default Carousel
