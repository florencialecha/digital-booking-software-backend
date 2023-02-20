import { DatePicker } from 'antd'
import { React, useState } from 'react'
import moment from 'moment'
import './DatePick.css'

const { RangePicker } = DatePicker

const DatePick = () => {
  const [dates, setDates] = useState([])
  console.log(dates)

  return (
      <div className='picker'>
        < RangePicker
          onChange={(values) => {
            setDates(values.map(item => {
              return moment(item).format('YYYY-DD-MM')
            }))
          }}
        />
      </div>
  )
}

export default DatePick
