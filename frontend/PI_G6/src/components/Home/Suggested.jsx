import { React, useEffect, useContext } from 'react'
import CardSuggested from './CardSuggested/CardSuggested'
import { GlobalContext } from '../utils/globalContext'
import './CardSuggested/CardSuggested.css'
import axios from 'axios'

const Suggested = () => {
  const { state, dispatch } = useContext(GlobalContext)

  useEffect(() => {
    if (state.data === 0 && !state.city) {
      axios
        // endopint de los 8 randoms
        .get('http://3.131.138.206:8080/product/random')
        .then((res) => dispatch({ type: 'bd', payload: res.data }))
        .catch((error) => console.log(error))
    } else if (state.data !== 0 && state.city) {
      axios
        .get(`http://3.131.138.206:8080/product/byCategory/${state.data}`)
        .then((res) => dispatch({ type: 'bd', payload: res.data }))
        .catch((error) => console.log(error))
    } else if (state.city) {
      axios
        .get(`http://3.131.138.206:8080/product/byCity/${state.city}`)
        .then((res) => dispatch({ type: 'bd', payload: res.data }))
        .catch((error) => console.log(error))
    }
  }, [state.data, state.city])

  return (
    <section className='suggested-main-container'>
      <p className='recomendation'>Recomendaciones</p>
      <section className='suggested-render-container'>
        {state.bd.map((suggest) => (
          <CardSuggested key={suggest.id} {...suggest} />
        ))}
      </section>
    </section>
  )
}

export default Suggested
