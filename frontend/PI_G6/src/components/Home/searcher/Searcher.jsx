/* eslint-disable array-callback-return */
import React, { useContext, useState } from 'react'
import './Searcher.css'
import SelectorTarget from './SelectorTarget'
import DatePick from './DatePick'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCalendarDay } from '@fortawesome/free-solid-svg-icons'
import { GlobalContext } from '../../utils/globalContext'

const Searcher = () => {
<<<<<<< HEAD
  const [selected, setSelected] = useState("");
  const { dispatch } = useContext(GlobalContext);

  const handleSelectCity = () => {
    dispatch({ type: "city", payload: selected.split(",")[0] });
    dispatch({ type: "data", payload: "-1" });
  };
=======
  const [selected, setSelected] = useState('')
  const { dispatch } = useContext(GlobalContext)

  const handleSelectCity = () => {
    dispatch({ type: 'city', payload: selected.split(',')[0] })
    console.log(selected.split(',')[0])
  }
>>>>>>> 9ec609bb80afc481ff91c8ee0fbdc7c487d1bf2d

  return (
    <section className="searcher">
      <h1>Busca ofertas en hoteles, casas y mucho más</h1>
      <section>
        <div className="location-container">
          <SelectorTarget selected={selected} setSelected={setSelected} />
        </div>
        <div className="calendar" id="calendar">
          <FontAwesomeIcon icon={faCalendarDay} />
          <DatePick />
        </div>
        <button onClick={handleSelectCity} id="btn-search">
          Buscar
        </button>
      </section>
    </section>
  )
}

export default Searcher
