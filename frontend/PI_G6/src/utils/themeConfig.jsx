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
    htmlFontSize: 12,
    fontFamily: 'Quicksand',
    fontSize: 14,
    fontWeightLight: 300,
    fontWeightRegular: 400,
    fontWeightMedium: 500,
    fontWeightBold: 700,
    h1: {
      fontFamily: 'Quicksand',
      fontWeight: 700,
      fontSize: 24
    },
    h2: {
      fontFamily: 'Quicksand',
      fontWeight: 700,
      fontSize: 20
    },
    h3: {
      fontFamily: 'Quicksand',
      fontWeight: 700,
      fontSize: 16
    },
    h4: {
      fontFamily: 'Quicksand',
      fontWeight: 700,
      fontSize: 14
    },
    button1: {
      fontFamily: 'Quicksand',
      fontWeight: 700,
      fontSize: 14
    },
    button2: {
      fontFamily: 'Quicksand',
      fontWeight: 700,
      fontSize: 16
    }
  }
})

export default theme
