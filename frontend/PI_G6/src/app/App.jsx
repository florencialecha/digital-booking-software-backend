import React from 'react'
import { Routes, Route } from 'react-router-dom'
import Layout from '../routes/Layout'
import Home from '../routes/Home/Home'
import Login from '../routes/Login'
import Register from '../routes/Register'
// import NotFound from '../routes/NotFound'
import ProductDetails from '../components/details/ProductDetails'
import Reserve from '../components/reserve/Reserve'
import '../index.css'
import AdminPage from '../components/administration/AdminPage'

function App () {
  return (
    <Routes>
      <Route element={<Layout />}>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/administration" element={<AdminPage />} />
        <Route path='/product/:id' element={ <ProductDetails/> }/>
        <Route path='/product/:id/reserve' className='reserve' element={ <Reserve/> }/>
      </Route>
        {/* <Route path="/*" element={<NotFound />} /> */}
    </Routes>
  )
}

export default App
