import React from 'react'
import { Outlet } from 'react-router'
import Header from '../components/Header'
import Footer from '../components/Footer'

const Layout = () => {
  return (
    <div style={{ width: '100 vh' }}>
      <Header />
        <div style={{ padding: '50px 50px' }}>
            <Outlet/>
        </div>
      <Footer/>
    </div>
  )
}
export default Layout
