import React from 'react'
import './CardSuggested'
import CardStars from './CardStars'

const CardSuggested = (suggest) => {
  return (
    <div className='card-container'>
        <section>
            <img src={suggest.imageUrl} />
            <div className='card-information'>
                <div className='card-title'>
                    <article>
                        <div>{suggest.SuggestCategory} <CardStars {...suggest}/></div>
                        <p>{suggest.name}</p>
                    </article>
                    <div className='valoration'>
                        <p>{suggest.scoring}</p>
                        <p>{suggest.review}</p>
                    </div>
                </div>
                <div id='card-location'>{suggest.location}</div>
                <div id='card-description'>{suggest.description}</div>
                <div className='see-more'><button>ver más</button></div>
            </div>
        </section>
    </div>
  )
}

export default CardSuggested
