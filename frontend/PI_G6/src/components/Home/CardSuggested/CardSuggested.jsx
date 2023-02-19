import React from 'react'
import './CardSuggested'

const CardSuggested = (suggest) => {
  return (
    <div className='card-container'>
        <section>
            <img src="https://images.unsplash.com/photo-1613490493576-7fde63acd811?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1471&q=80" alt="card-img" />
            <div className='card-information'>
                <div className='card-title'>
                    <article>
                        <p>{suggest.SuggestCategory} ⭐⭐⭐</p>
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
