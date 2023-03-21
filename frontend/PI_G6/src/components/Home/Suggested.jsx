import { React, useEffect, useContext } from 'react'
import CardSuggested from './CardSuggested/CardSuggested'
import { GlobalContext } from '../../utils/globalContext'
import styles from '../Home/Suggested.module.css'
import axios from 'axios'
import staticData from '../../temp/apiProducts.json'

const Suggested = () => {
  const { state, dispatch } = useContext(GlobalContext)

  useEffect(() => {
    const fetchData = async () => {
      if (state.data === 0 && !state.city) {
        try {
          const res = await axios.get('http://3.131.138.206:8080/product/random')
          dispatch({ type: 'bd', payload: res.data })
        } catch (error) {
          console.log('Error al obtener datos de la API. Usando datos estáticos...')
          const fallbackData = await axios.get('/apiProducts.json')
          dispatch({ type: 'bd', payload: fallbackData.data })
        }
      } else if (state.data > 0) {
        try {
          const res = await axios.get(`http://3.131.138.206:8080/product/byCategory/${state.data}`)
          dispatch({ type: 'bd', payload: res.data })
        } catch (error) {
          console.log('Error al obtener datos de la API. Usando datos estáticos...')
          const fallbackData = await axios.get('/apiProducts.json')
          dispatch({ type: 'bd', payload: fallbackData.data })
        }
      } else {
        try {
          const res = await axios.get(`http://3.131.138.206:8080/product/byCity/${state.city}`)
          dispatch({ type: 'bd', payload: res.data })
        } catch (error) {
          console.log('Error al obtener datos de la API. Usando datos estáticos...')
          const fallbackData = await axios.get('/apiProducts.json')
          dispatch({ type: 'bd', payload: fallbackData.data })
        }
      }
    }
    fetchData()
  }, [])

  return (
    <section className={styles.suggestedMainContainer}>
      <p className={styles.recomendationContainer}>Recomendaciones</p>
      <section className={styles.suggestedRenderContainer}>
        {state.bd?.map((suggest) => (
          <CardSuggested key={suggest.id} suggest={suggest} styles={styles} />
        ))}
      </section>
    </section>
  )
}

export default Suggested
