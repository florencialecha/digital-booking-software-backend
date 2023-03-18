import axios from 'axios'
import { React, useRef, useEffect, useState } from 'react'
import { motion } from 'framer-motion'
import CardCategory from './CardCategory/CardCategory'
import './CardCategory/CardCategory.css'

const Carousel = () => {
  const [width, setWidht] = useState(0)
  const [categorys, setCategorys] = useState([])

  const carousel = useRef()

  useEffect(() => {
    setWidht(carousel.current.scrollWidth - carousel.current.offsetWidth)
  }, [carousel.current])

  useEffect(() => {
    axios.get('http://3.131.138.206:8080/category')
      .then(res => setCategorys(res.data))
      .catch(error => console.log(error))
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
