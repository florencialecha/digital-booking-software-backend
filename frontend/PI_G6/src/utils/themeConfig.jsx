import { createTheme } from '@mui/material/styles'

const theme = createTheme({
  palette: {
    primary: {
      main: '#F0572D'
    },
    secondary: {
      main: '#31363F'
    },
    info: {
      main: '#191B1D'
    },
    error: {
      main: '#DFE4EA'
    }
  },
  typography: {
    htmlFontSize: 16,
    fontFamily: 'Quicksand',
    fontSize: 14,
    fontWeightLight: 300,
    fontWeightRegular: 400,
    fontWeightMedium: 500,
    fontWeightBold: 700,
    h1: {
      fontFamily: 'Quicksand',
      fontSize: '6rem'
    },
    h2: {
      fontFamily: 'Quicksand',
      fontSize: '3.75rem'
    },
    h3: {
      fontFamily: 'Quicksand',
      fontSize: '3rem'
    },
    h4: {
      fontFamily: 'Quicksand',
      fontSize: '2.15rem'
    },
    h5: {
      fontFamily: 'Quicksand',
      fontSize: '1,5rem'
    }
  }
})

export default theme
