import React from 'react'
import './Searcher.css'

const Searcher = () => {
  return (
    <section className='searcher'>
        <p>Busca ofertas en hoteles, casas y mucho más</p>
        <section>
          <div>
            <img src="https://i.ibb.co/vjD4XmB/localizador.png" alt="" />
            <input type="text" placeholder='¿A donde vamos?' />
          </div>
          <div>
            <img src="https://i.ibb.co/Dz2w3VJ/calendar.png" alt="" />
            <input type="text" placeholder='Check in - Check out' />
          </div>
          <button>Buscar</button>
        </section>
    </section>
  )
}

export default Searcher
