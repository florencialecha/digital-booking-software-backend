/* eslint-disable react/prop-types */
import React, { useState } from 'react'
import CardStars from './CardStars'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLocationDot, faHeart } from '@fortawesome/free-solid-svg-icons'
import Features from '../../details/ProductFeatures/Features'

const CardSuggested = ({ suggest, styles }) => {
  const [isActive, setActive] = useState(false)

  const handleToggle = () => {
    setActive(!isActive)
  }

  const handleClickMap = () => {
    window.open(
      `https://www.google.com/maps/embed/v1/place?key=AIzaSyDO5woQG6Ni56if3gOVoVoP3coiwxg4huI
  &q=${suggest.address.street}+${suggest.address.number},${suggest.address.city.name}+${suggest.address.city.state.name}+${suggest.address.city.state.country.name}&zoom=19`,
      'register',
      'width=800,height=600, top=0, left=960"'
    )
    return false
  }

  const handleReserv = () => {
    const hotelSelected = JSON.stringify(suggest)
    localStorage.setItem('hotelSelected', hotelSelected)
    window.location.href = `/product/${suggest.id}`
  }

  return (
    <div className={styles.cardContainer}>
      <FontAwesomeIcon
        className={styles.favIcon + ' ' + styles[`full-${isActive}`]}
        icon={faHeart}
        onClick={handleToggle}
      />
      <section>
        <img src={suggest.imageList[0]?.imageUrl} />
        <div className={styles.cardInformation}>
          <div className={styles.cardTitle}>
            <div className={styles.productCategoryNameAndStars}>
              <p className={styles.productCategory}>{suggest.category.title}</p>
              <CardStars {...suggest} styles={styles}/>
              <p id={styles.suggestName}>{suggest.title}</p>
            </div>
            <div className={styles.valorationInfo}>
              <p>{suggest.scoring}</p>
              <p>{suggest.review}</p>
            </div>
          </div>
          <div className={styles.cardLocation} id={styles.cardLocation} >
            <div>
              <FontAwesomeIcon icon={faLocationDot} />
              <p>a 300m del centro</p>
            </div>
            <div className={styles.onClickMap} onClick={handleClickMap}>
              <p>MOSTRAR EN EL MAPA</p>
            </div>
          </div>
          <div className={styles.cardAddress} id={styles.cardAddress} >
            <div>
              <FontAwesomeIcon icon={faLocationDot} />
              <p>{suggest.address.street} {suggest.address.number}, {suggest.address.city.name}, {suggest.address.city.state.name}, {suggest.address.city.state.country.name}</p>
            </div>
          </div>
          <Features className={styles.serviceIcons} styles={styles} specs={suggest.featureList} />
          <div id={styles.cardDescription}>
            {suggest.description?.length > 30
              ? (
              <p>
                {suggest.description.substring(0, 30)}
                <a className={styles.moreText} href='#'>
                  {' '}
                  mas...
                </a>
              </p>
                )
              : (
              <p>{suggest.description}</p>
                )}
          </div>
          <div className={styles.seeMore}>
            <button>
              <a onClick={handleReserv}>
                ver más
              </a>
            </button>
          </div>
        </div>
      </section>
    </div>
  )
}

export default CardSuggested
