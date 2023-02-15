import React from 'react'
import ReactDOM from 'react-dom/client'
import { BrowserRouter } from 'react-router-dom'
import App from './app/App'
import { ThemeProvider } from '@mui/material/styles'
import theme from './utils/themeConfig'

ReactDOM.createRoot(document.getElementById('root')).render(
  <ThemeProvider theme={ theme }>
    <BrowserRouter>
      <App />
    </BrowserRouter>
  </ThemeProvider>
)
