import React from 'react'
import { Outlet } from 'react-router'

const Layout = () => {
  return (
    <div>
        <div>Header</div>
        <div>
            <Outlet/>
        </div>
        <div>Footer</div>
    </div>
  )
}

export default Layout
