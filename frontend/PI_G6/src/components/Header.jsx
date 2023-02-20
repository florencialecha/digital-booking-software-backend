import React from 'react'
import '@fontsource/quicksand'

const Header = () => {
  return (
    <div style={{ display: 'flex', justifyContent: 'space-between', backgroundColor: '#DFE4EA', padding: '10px 20px', width: '100vW', boxSizing: 'border-box', position: 'fixed', top: '0', zIndex: 2 }}>
      <div style={{ display: 'flex', alignItems: 'flex-end', gap: '5px' }}>
      <img src="https://i.ibb.co/nPrrkLc/logo-1-2.png" alt="Logo Digital Booking" border="0" />
        <span style={{ paddingBottom: '2px', fontFamily: 'Quicksand', fontStyle: 'italic', fontWeight: '600' }}>Sentite como en tu hogar</span>
      </div>
      <div style={{ display: 'flex', alignItems: 'center', gap: '10px' }}>
        <button style={{ height: '40px', fontFamily: 'Quicksand', borderRadius: '15px', borderColor: 'F0572D' }}>Crear Cuenta</button>
        <button style={{ height: '40px', fontFamily: 'Quicksand', borderRadius: '15px', borderColor: 'F0572D' }}>Iniciar sesion</button>
      </div>
    </div>
  )
}

export default Header
