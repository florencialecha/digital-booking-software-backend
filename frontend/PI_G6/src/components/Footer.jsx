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
            // color='secondary'
            variant='h6'
            fontWeight='bold'>
                ©2023 Digital Booking
            </Typography>
            <Box>
              <IconButton role='facebook' href='https://www.facebook.com/' ><Facebook /*color='secondary'*//></IconButton>
              <IconButton role='instagram' href='https://www.instagram.com/'><Instagram /*color='secondary'*//></IconButton>
              <IconButton role='LinkedInIcon' href='https://www.LinkedInIcon.com/' ><LinkedInIcon /*color='secondary'*//></IconButton>
              <IconButton role='tiktok' href='https://www.twitter.com/'><TwitterIcon /*color='secondary'*//></IconButton>
            </Box>
        </Box>
      </Container>
    </AppBar>
  )
}

export default Footer
