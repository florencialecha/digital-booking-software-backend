import { React, useState } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLocationDot } from '@fortawesome/free-solid-svg-icons'
import './Searcher.css'

const selectorTarget = () => {
  const [isActive, setIsActive] = useState(true)
  const [search, setSearch] = useState('')

  const inputToSearch = (e) => {
    setSearch(e.target.value)
  }

  return (
    <form action="" className='formClass' >
      <div className='selectbox' onClick={() => setIsActive(!isActive)}>
        <div id='select' className='select'>
          <FontAwesomeIcon icon={faLocationDot} />
          <input className="select-content" value={search} onClick={() => setSearch('')} onChange={inputToSearch} placeholder='A donde vamos'></input>
        </div>
        {/* <div id='options' className={isActive ? 'inactive' : 'active'}>
          {data.map((countrys) => {
            return (
              <div key={countrys.id} >{
                countrys.cities.filter((city) => {
                  if (!search) {
                    return city
                  } else {
                    city = city.name.toLowerCase().includes(search.toLowerCase())
                    return city
                  }
                }).map((city) => {
                  return (
                    <a href="#" key={city.id} onClick={() => setSearch(`${city.name}, ${countrys.country}`)}>
                      <div className="content-option" >
                        <FontAwesomeIcon icon={faLocationDot} />
                        <div className='texts'>
                          <p>{city.name}</p>
                          <p>{countrys.country}</p>
                        </div>
                      </div>
                    </a>
                  )
                })
              }</div>
            )
          })}
        </div> */}
      </div>
    </form>
  )
}

export default selectorTarget
