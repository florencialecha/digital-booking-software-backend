import React from 'react'
import CardSuggested from './CardSuggested/CardSuggested'
import './CardSuggested/CardSuggested.css'
import data from '../../temp/apiSuggested.json'

const Suggested = () => {
  return (
    <section className='suggested-main-container'>
      <p className='recomendation'>Recomendaciones</p>
      <section className='suggested-render-container'>
        {data.map((suggest) => (
          <CardSuggested key={suggest.id} {...suggest}/>
        ))}
      </section>
    </section>
  )
}

export default Suggested
