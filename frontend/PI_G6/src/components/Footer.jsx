import React from 'react'
import { Instagram, Facebook } from '@mui/icons-material'
import { AppBar, Box, Container, IconButton, Typography } from '@mui/material'
import LinkedInIcon from '@mui/icons-material/LinkedIn'
import TwitterIcon from '@mui/icons-material/Twitter'

const Footer = () => {
  return (
    <AppBar position='static' sx={{ minHeight: '10vh', display: 'flex', justifyContent: 'center' }} >
      <Container maxWidth='x2' sx={{ display: 'flex', flexDirection: 'column' }}>
        <Box
        sx={{
          display: 'flex',
          flexDirection: 'row',
          alignItems: 'center',
          justifyContent: 'space-between'
        }}
        >
            <Typography
            color='secondary.main'
            variant='h6'
            fontWeight='bold'
            sx={{
              typography: 'h3'
            }}>
                ©2023 Digital Booking
            </Typography>
            <Box >
              <IconButton role='facebook' href='https://www.facebook.com/' ><Facebook color='error' /></IconButton>
              <IconButton role='instagram' href='https://www.instagram.com/'><Instagram color='error' /></IconButton>
              <IconButton role='LinkedInIcon' href='https://www.LinkedInIcon.com/' ><LinkedInIcon color='error' /></IconButton>
              <IconButton role='tiktok' href='https://www.twitter.com/'><TwitterIcon color='error' /></IconButton>
            </Box>
        </Box>
      </Container>
    </AppBar>
  )
}

export default Footer
