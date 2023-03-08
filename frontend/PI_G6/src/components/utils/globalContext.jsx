import { createContext, useReducer, React } from 'react'

export const GlobalContext = createContext(undefined)

const initialState = { data: 0, bd: [] }

const reducer = (state, action) => {
  switch (action.type) {
    case 'data':
      return { ...state, data: action.payload }
    case 'bd':
      return { ...state, bd: action.payload }
    default:
      return state
  }
}

export const ContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(reducer, initialState)

  const store = {
    state,
    dispatch
  }

  return (
    <GlobalContext.Provider value={store}>
        {children}
    </GlobalContext.Provider>
  )
}
