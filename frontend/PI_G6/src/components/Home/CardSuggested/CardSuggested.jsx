import { React, useState } from 'react'
import './CardSuggested'
import CardStars from './CardStars'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLocationDot, faPersonSwimming, faWifi, faHeart } from '@fortawesome/free-solid-svg-icons'

const CardSuggested = (suggest) => {
  console.log(suggest.array.wifi)

  const [isActive, setActive] = useState(false)

  const handleToggle = () => {
    setActive(!isActive)
  }

  return (
    <div className='card-container'>
        <FontAwesomeIcon className={`fav-icon full-${isActive}`} icon={faHeart} onClick={handleToggle} />
        <section>
            <img src={suggest.imageUrl} />
            <div className='card-information'>
                <div className='card-title'>
                    <article>
                        <div>{suggest.SuggestCategory} <CardStars {...suggest}/></div>
                        <p id='suggest-name'>{suggest.name}</p>
                    </article>
                    <div className='valoration'>
                        <p>{suggest.scoring}</p>
                        <p>{suggest.review}</p>
                    </div>
                </div>
                <div>
                    <div className='card-location' id='card-location'>
                        <div>
                            <FontAwesomeIcon icon={faLocationDot} />
                            <p>{suggest.location}</p>
                        </div>
                        <a href={`https://www.google.com.uy/maps/@${suggest.coordinates.coordX},${suggest.coordinates.coordY},13z`}><p>MOSTRAR EN EL MAPA</p></a>
                    </div>
                    <div className='service-icons'>
                        { suggest.array.wifi ? <FontAwesomeIcon icon={faWifi} /> : ''}
                        { suggest.array.pool ? <FontAwesomeIcon className='fa-flip-horizontal' icon={faPersonSwimming} /> : ''}
                    </div>
                </div>
                <div id='card-descridivtion'>
                    {suggest.description.length > 250 ? <p>{suggest.description.substring(0, 200)}<a className='moreText' href='#'> mas...</a></p> : <p>{suggest.description}</p> }
                </div>
                <div className='see-more'>
                    <button>ver más</button>
                </div>
            </div>
        </section>
    </div>
  )
}

export default CardSuggested
