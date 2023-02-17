import React from 'react'

const Footer = () => {
  return (
    <div style={{ display: 'flex', position: 'fixed', bottom: '0', justifyContent: 'space-between', backgroundColor: '#F0572D', padding: '10px 20px', height: '80px', width: '100vw', boxSizing: 'border-box' }}>
      <div style={{ display: 'flex', alignItems: 'center', gap: '5px' }}>
        <span style={{ paddingBottom: '2px', fontFamily: 'Quicksand', fontWeight: '700' }}>©2023 Digital Booking</span>
      </div>
      <div style={{ display: 'flex', alignItems: 'center', gap: '5px' }}>
        <a href='https://www.facebook.com'><img src="https://i.ibb.co/3f8bLtd/icon-facebook.png" alt="icon-facebook" border="0" /></a>
        <a href='https://www.linkedin.com'><img src="https://i.ibb.co/9cRcLjd/icon-linkedin.png" alt="icon-linkedin" border="0" /></a>
        <a href='https://www.twitter.com'><img src="https://i.ibb.co/7Y5rVDT/tweet.png" alt="icon-twitter" border="0" /></a>
        <a href='https://www.instagram.com'><img src="https://i.ibb.co/hmB2GMV/icon-ig.png" alt="icon-instagram" border="0" /></a>
      </div>
    </div>

  )
}

export default Footer
