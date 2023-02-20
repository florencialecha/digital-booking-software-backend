import { React, useState } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLocationDot } from '@fortawesome/free-solid-svg-icons'
import './Searcher.css'
import data from '../../../temp/citiList.json'

const selectorTarget = () => {
  const [isActive, setIsActive] = useState(true)

  return (
    <form action="" >
      <div className='selectbox' onClick={() => setIsActive(!isActive)}>
        <div id='select' className='select'>
          <FontAwesomeIcon icon={faLocationDot} />
          <div className="select-content">
            <p>¿A donde vamos?</p>
          </div>
        </div>
        <div id='options' className={isActive ? 'active' : 'inactive'}>
          {data.map((cities) => {
            return (
              <a href="#" key={cities.cities}>{
                cities.cities.map((city) => {
                  return (
                    <div key={city} className="content-option">
                      <FontAwesomeIcon icon={faLocationDot} />
                      <div className='texts'>
                        <p>{city}</p>
                        <p>{cities.country}</p>
                      </div>
                    </div>
                  )
                })
              }</a>
            )
          })}
        </div>
      </div>
    </form>
  )
}

export default selectorTarget
