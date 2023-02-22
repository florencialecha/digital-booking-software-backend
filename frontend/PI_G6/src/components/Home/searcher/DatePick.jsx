import { DatePicker } from 'antd'
import { React } from 'react'
import moment from 'moment'
import './DatePick.css'

const { RangePicker } = DatePicker

const DatePick = () => {
  return (
      <div className='picker'>
        < RangePicker
          onChange={(values) => {
            (values.map(item => {
              return moment(item).format('YYYY-DD-MM')
            }))
          }}
        />
      </div>
  )
}

export default DatePick
