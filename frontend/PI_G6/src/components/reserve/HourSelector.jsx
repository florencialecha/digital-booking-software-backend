import React, { useState } from 'react'

const checkInHours = [
  {
    type: 'am',
    hours: [
      '10',
      '11',
      '12'
    ]
  },
  {
    type: 'pm',
    hours: [
      '01',
      '02',
      '03',
      '04',
      '05',
      '06',
      '07',
      '08',
      '09',
      '10',
      '11'
    ]
  }

]

const HourSelector = ({ styles }) => {
  const [isActive, setIsActive] = useState(true)

  return (
    <div>
        <form action="" className={styles.formClass}>
            <div className={styles.selectbox} onClick={() => setIsActive(!isActive)}>
                <div id={styles.select} className={styles.select}>
                <input
                    className={styles.selectContent}
                    placeholder="10:00"
                ></input>
                </div>
                <div id={styles.options} className={isActive ? `${styles.inActive}` : `${styles.active}`}>
                    {checkInHours.map((amPm) => {
                      return (
                            <div key={amPm.type}>
                                {amPm.hours.map((hour) => {
                                  return (
                                        <div key={hour} className={styles.contentOption}>
                                            <p>{hour}{amPm.type}</p>
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
