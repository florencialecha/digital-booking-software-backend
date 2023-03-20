import React, { createContext, useReducer } from 'react'

export const GlobalContext = createContext()

const initialState = {
  data: 0,
  bd: [],
  city: ''
}

const reducer = (state, action) => {
  switch (action.type) {
    case 'data':
      return { ...state, data: action.payload }
    case 'bd':
      return { ...state, bd: action.payload }
    case 'city':
      return { ...state, city: action.payload }
    default:
      return state
  }
}

export const ContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState)

  return (
    <GlobalContext.Provider value={{ state, dispatch }}>
      {children}
    </GlobalContext.Provider>
  )
}