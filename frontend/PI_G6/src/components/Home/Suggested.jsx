import { React, useEffect, useContext } from 'react'
import CardSuggested from './CardSuggested/CardSuggested'
import { GlobalContext } from '../../utils/globalContext'
import styles from '../Home/Suggested.module.css'
import axios from 'axios'
import staticData from '../../temp/apiProducts.json'

const Suggested = () => {
  const { state, dispatch } = useContext(GlobalContext)

  useEffect(() => {
    if (state.data === 0 && !state.city) {
      axios
        .get('http://3.131.138.206:8080/product/random')
        .then((res) => dispatch({ type: 'bd', payload: res.data }))
        .catch((error) => {
          console.log(error)
          dispatch({ type: 'bd', payload: staticData })
        })
    } else if (state.data > 0) {
      axios
        .get(`http://3.131.138.206:8080/product/byCategory/${state.data}`)
        .then((res) => dispatch({ type: 'bd', payload: res.data }))
        .catch((error) => {
          console.log(error)
          dispatch({ type: 'bd', payload: staticData })
        })
    } else {
      axios
        .get(`http://3.131.138.206:8080/product/byCity/${state.city}`)
        .then((res) => dispatch({ type: 'bd', payload: res.data }))
        .catch((error) => {
          console.log(error)
          dispatch({ type: 'bd', payload: staticData })
        })
    }
  }, [state.data, state.city])

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
