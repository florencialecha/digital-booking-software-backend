import React from 'react'
import { Outlet } from 'react-router'
import Header from '../components/Header'
import Footer from '../components/Footer'

const Layout = () => {
  return (
    <div style={{ width: '100 vw' }}>
      <Header />
        <Outlet/>
      <Footer/>
    </div>
  )
}
export default Layout
