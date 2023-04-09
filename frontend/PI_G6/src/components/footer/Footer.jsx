import React from 'react'
import Social from '../socials/Social'
import styles from'./Footer.module.css'

const Footer = () => {
  return (
    <div className={styles.footer}>
      <div className={styles.copyright}>
        <span>©2023 Digital Booking</span>
      </div>
      <div className={styles.socialFooter}>
        <Social styles={styles}/>
      </div>
    </div>
  )
}

export default Footer
