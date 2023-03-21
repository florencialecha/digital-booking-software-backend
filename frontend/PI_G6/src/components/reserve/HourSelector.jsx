/* eslint-disable react/prop-types */
import React, { useState } from 'react'
import { faChevronDown } from '@fortawesome/free-solid-svg-icons'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import useComponentVisible from '../../hooks/useComponentVisible'

const checkInHours = [
  {
    type: 'am',
    hours: [
      '10:00',
      '11:00',
      '12:00'
    ]
  },
  {
    type: 'pm',
    hours: [
      '01:00',
      '02:00',
      '03:00',
      '04:00',
      '05:00',
      '06:00',
      '07:00',
      '08:00',
      '09:00',
      '10:00',
      '11:00'
    ]
  }

]

const HourSelector = ({ styles }) => {
  const [hourSelect, setHourSelect] = useState('')

  const { selectorRef, isActive, setIsActive } = useComponentVisible(false)

  return (
    <div>
        <form action="" className={styles.formClass}>
            <div ref={selectorRef} className={styles.selectbox} onClick={() => setIsActive(prev => !prev)}>
                <div id={styles.select} className={styles.select}>
                  <div
                      className={styles.selectContent}
                  >
                    <div className={styles.messageToRender}>
                      <p>{`${hourSelect}` ? `${hourSelect}` : 'Seleccionar tu hora de llegada'}</p>
                    </div>
                  </div>
                  <FontAwesomeIcon icon={faChevronDown}/>
                </div>
                <div id={styles.options} className={isActive ? `${styles.active}` : `${styles.inActive}`}>
                    {checkInHours.map((amPm) => {
                      return (
                            <div key={amPm.type}>
                                {amPm.hours.map((hour) => {
                                  return (
                                        <div key={hour} className={styles.contentOption}>
                                            <p onClick={() => {
                                              setHourSelect(`${hour} ${amPm.type}`)
                                            }}>{hour} {amPm.type}</p>
                                        </div>
                                  )
                                })}
                            </div>
                      )
                    })}
                </div>
            </div>
        </form>
    </div>
  )
}

export default HourSelector
