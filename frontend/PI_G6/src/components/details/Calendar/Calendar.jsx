import React, { useState } from "react";
import "./Calendar.css";
import { endOfMonth, startOfMonth } from "date-fns/fp";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faChevronLeft,
  faChevronRight,
} from "@fortawesome/free-solid-svg-icons";

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
  const [currentDate, setCurrentDate] = useState(new Date());
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

  console.log(dates);
  const unavailableDates = (i, month, year) => {
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

    return "available";
  };

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

  const followingMonth = () => {
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

  const completeCalendar = (month, year) => {
    return 42 - getStartOfMonth(year, month) - getDaysInAMonth(year, month);
  };

  const pastDates = (day, month) => {
    if (
      (day < currentDate.getDate() &&
        month <= currentDate.getMonth() + 1 &&
        currentYear <= currentDate.getYear() + 1900) ||
      (day >= currentDate.getDate() &&
        month < currentDate.getMonth() + 1 &&
        currentYear <= currentDate.getYear() + 1900) ||
      currentYear < currentDate.getYear() + 1900
    ) {
      return "past-date";
    } else return "";
  };

  return (
    <div className="calendar-layout">
      <div className="calendar-details">
        <button onClick={prevMonth} className="change-month-button">
          <FontAwesomeIcon icon={faChevronLeft}></FontAwesomeIcon>
        </button>

        <div className="grid-first-month">
          <div className="month">
            <h4>
              {months[currentMonth - 1]} {currentYear}
            </h4>
          </div>

          {}
          {days.map((day, i) => (
            <p key={i} className="week-days">
              {day}
            </p>
          ))}
          {Array.from({
            length: getStartOfMonth(currentYear, currentMonth),
          }).map((_, i) => (
            <p key={i}></p>
          ))}
          {Array.from({
            length: getDaysInAMonth(currentYear, currentMonth),
          }).map((_, i) => (
            <p
              className={`${unavailableDates(
                i,
                currentMonth,
                currentYear
              )} day-of-month ${pastDates(i + 1, currentMonth)}`}
              onClick={() => handleSelectDates(i, currentYear, currentMonth)}
              key={i}
            >
              {i + 1}
            </p>
          ))}
          {Array.from({
            length: completeCalendar(currentMonth, currentYear),
          }).map((_, i) => (
            <p key={i} className="day-of-other-month">
              {i + 1}
            </p>
          ))}
        </div>
        <div className="grid-second-month">
          <div className="month">
            <h4>
              {months[nextMonth - 1]} {currentYear}
            </h4>
          </div>

          {}
          {days.map((day, i) => (
            <p key={i} className="week-days">
              {day}
            </p>
          ))}
          {Array.from({ length: getStartOfMonth(currentYear, nextMonth) }).map(
            (_, i) => (
              <p key={i}></p>
            )
          )}
          {Array.from({ length: getDaysInAMonth(currentYear, nextMonth) }).map(
            (_, i) => (
              <p
                className={`${unavailableDates(
                  i,
                  nextMonth,
                  currentYear
                )} day-of-month ${pastDates(i + 1, nextMonth)}`}
                onClick={() => handleSelectDates(i, currentYear, nextMonth)}
                key={i}
              >
                {i + 1}
              </p>
            )
          )}
          {Array.from({ length: completeCalendar(nextMonth, currentYear) }).map(
            (_, i) => (
              <p key={i} className="day-of-other-month">
                {i + 1}
              </p>
            )
          )}
        </div>
        <button className="change-month-button" onClick={followingMonth}>
          <FontAwesomeIcon icon={faChevronRight}></FontAwesomeIcon>
        </button>
      </div>

      <div className="reservation-details">
        <p>Agregá tus fechas de viaje para obtener previos exactos</p>
        <button className="reservation-button">Iniciar reserva</button>
      </div>
      {/* <button onClick={() => setSelectDate([])}>clear selection</button> */}
    </div>
  );
};

export default Calendar;
