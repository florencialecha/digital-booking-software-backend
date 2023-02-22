/* eslint-disable array-callback-return */
import React from 'react'
import './Searcher.css'
import SelectorTarget from './SelectorTarget'
import DatePick from './DatePick'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCalendarDay } from '@fortawesome/free-solid-svg-icons'

const Searcher = () => (
  <section className='searcher'>
    <h1>Busca ofertas en hoteles, casas y mucho más</h1>
    <section>
      <div className='location-container'>
        <SelectorTarget />
      </div>
      <div className='calendar' id='calendar'>
        <FontAwesomeIcon icon={faCalendarDay} />
        <DatePick />
      </div>
      <button id='btn-search' >
        Buscar
      </button>
    </section>
  </section>
)

export default Searcher
