import React, { useState } from "react";
import "./Calendar.css";
import { endOfMonth, startOfMonth } from "date-fns/fp";

const months = [
  "Enero",
  "Febrero",
  "Marzo",
  "Abril",
  "Mayo",
  "Junio",
  "Julio",
  "Agosto",
  "Septiembre",
  "Octubre",
  "Noviembre",
  "Diciembre",
];

const days = ["D", "L", "M", "M", "J", "V", "S"];

const Calendar = () => {
  const [selectDate, setSelectDate] = useState([]);
  const [currentMonth, setCurrentMonth] = useState(new Date().getMonth() + 1);
  const [nextMonth, setNextMonth] = useState(new Date().getMonth() + 2);
  const [currentYear, setCurrentYear] = useState(new Date().getYear() + 1900);

  const dates = [
    new Date(),
    new Date("2023-04-23"),
    new Date("2023-03-23"),
    new Date("2023-04-24"),
    new Date("2023-04-25"),
    new Date("2023-05-25"),
    new Date("2023-05-26"),
    new Date("2023-04-26"),
  ];

  const doesItExist = (i, month, year) => {
    if (
      dates.find(
        (date) =>
          date.getDate() + 1 === i + 1 &&
          date.getMonth() + 1 === month &&
          date.getYear() + 1900 === year
      )
    ) {
      return "unavailable";
    } else if (
      !dates.find(
        (date) =>
          date.getDate() + 1 === i + 1 &&
          date.getMonth() + 1 === month &&
          date.getYear() + 1900 === year
      ) &&
      selectDate.find((day) => day === `${year}-${month}-${i + 1}`)
    ) {
      return "selected";
    }
  };

  console.log(selectDate);
  const handleSelectDates = (i, year, month) => {
    let displayDate = `${year}-${month}-${i + 1}`;
    if (
      !selectDate.includes(displayDate) &&
      !dates.find(
        (date) =>
          date.getDate() + 1 === i + 1 &&
          date.getMonth() + 1 === month &&
          date.getYear() + 1900 === year
      )
    ) {
      setSelectDate([...selectDate, displayDate]);
    }
    let index = selectDate.indexOf(displayDate);
    if (index !== -1) {
      selectDate.splice(index, 1);
      setSelectDate([...selectDate]);
    }
  };

  const getDaysInAMonth = (year, month) => {
    return new Date(year, month, 0).getDate();
  };

  const getStartOfMonth = (year, month) => {
    let date = new Date(`${year}-${month}-1`);
    const startDate = startOfMonth(date);
    return startDate.getDay();
  };

  const getEndOfMonth = (year, month) => {
    const date = new Date(`${year}-${month}-1`);
    const endDate = endOfMonth(date);
    return endDate.getDay();
  };

  const nexxtMonth = () => {
    if (currentMonth < 12 && nextMonth < 12) {
      setCurrentMonth((prev) => prev + 1);
      setNextMonth((prev) => prev + 1);
    } else {
      setCurrentMonth(1);
      setNextMonth(2);
      setCurrentYear((prev) => prev + 1);
    }
  };

  const prevMonth = () => {
    if (currentMonth > 1 && nextMonth > 1) {
      setCurrentMonth((prev) => prev - 1);
      setNextMonth((prev) => prev - 1);
    } else {
      setCurrentMonth(11);
      setNextMonth(12);
      setCurrentYear((prev) => prev - 1);
    }
  };

  return (
    <div className="calendarLayout">
      <button onClick={nexxtMonth}>next</button>
      <button onClick={prevMonth}>prev</button>
      <div className="grid">
        <div className="month">
          <h2>
            {months[currentMonth - 1]} {currentYear}
          </h2>
        </div>

        {}
        {days.map((day, i) => (
          <p key={i}>{day}</p>
        ))}
        {Array.from({ length: getStartOfMonth(currentYear, currentMonth) }).map(
          (_, i) => (
            <p></p>
          )
        )}
        {Array.from({ length: getDaysInAMonth(currentYear, currentMonth) }).map(
          (_, i) => (
            <p
              className={doesItExist(i, currentMonth, currentYear)}
              onClick={() => handleSelectDates(i, currentYear, currentMonth)}
              key={i}
            >
              {i + 1}
            </p>
          )
        )}
        {Array.from({ length: getEndOfMonth(currentYear, currentMonth) }).map(
          (_, i) => (
            <p key={i}></p>
          )
        )}
      </div>
      <div className="grid">
        <div className="month">
          <h2>
            {months[nextMonth - 1]} {currentYear}
          </h2>
        </div>

        {}
        {days.map((day, i) => (
          <p key={i}>{day}</p>
        ))}
        {Array.from({ length: getStartOfMonth(currentYear, nextMonth) }).map(
          (_, i) => (
            <p></p>
          )
        )}
        {Array.from({ length: getDaysInAMonth(currentYear, nextMonth) }).map(
          (_, i) => (
            <p
              className={doesItExist(i, nextMonth, currentYear)}
              onClick={() => handleSelectDates(i, currentYear, nextMonth)}
              key={i}
            >
              {i + 1}
            </p>
          )
        )}
        {Array.from({ length: getEndOfMonth(currentYear, nextMonth) }).map(
          (_, i) => (
            <p key={i}></p>
          )
        )}
      </div>
      <button onClick={() => setSelectDate([])}>clear selection</button>
    </div>
  );
};

export default Calendar;
