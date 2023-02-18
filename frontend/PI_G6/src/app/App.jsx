import { React } from 'react'
import { Routes, Route } from 'react-router-dom'
import Layout from '../routes/Layout'
import Home from '../routes/Home/Home'
import Login from '../routes/Login'
import Register from '../routes/Register'
import NotFound from '../routes/NotFound'

function App () {
  return (
      <Routes>
        <Route element={<Layout />}>
          <Route path='/' element={ <Home /> } />
          <Route path='/home' element={ <Home /> }/>
          <Route path='/login' element={ <Login /> }/>
          <Route path='/register' element={ <Register /> }/>
          <Route path='/*' element={ <NotFound/> }/>
        </Route>
      </Routes>
  )
}

export default App
