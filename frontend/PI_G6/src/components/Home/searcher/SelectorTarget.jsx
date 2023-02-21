import { React, useState } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLocationDot } from '@fortawesome/free-solid-svg-icons'
import './Searcher.css'
import data from '../../../temp/citiList.json'

const selectorTarget = () => {
  const [isActive, setIsActive] = useState(true)
  const [selectedCity, setSelectedCity] = useState(<p>¿A donde vamos?</p>)

  return (
    <form action="" className='formClass' >
      <div className='selectbox' onClick={() => setIsActive(!isActive)}>
        <div id='select' className='select'>
          <FontAwesomeIcon icon={faLocationDot} />
          <div className="select-content">
            {selectedCity}
          </div>
        </div>
        <div id='options' className={isActive ? 'inactive' : 'active'}>
          {data.map((cities) => {
            return (
              <div key={cities.cities} >{
                cities.cities.map((city) => {
                  return (
                    <a href="#" key={city} onClick={() => setSelectedCity(<p>{city}, {cities.country}</p>)}>
                      <div className="content-option" >
                        <FontAwesomeIcon icon={faLocationDot} />
                        <div className='texts'>
                          <p>{city}</p>
                          <p>{cities.country}</p>
                        </div>
                      </div>
                    </a>
                  )
                })
              }</div>
            )
          })}
        </div>
      </div>
    </form>
  )
}

export default selectorTarget
