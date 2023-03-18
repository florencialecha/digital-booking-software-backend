import { useState } from "react";
import "./Calendar.css";
import { startOfMonth } from "date-fns/fp";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faChevronLeft,
  faChevronRight,
} from "@fortawesome/free-solid-svg-icons";
import { format } from "date-fns";

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

function Calendar() {
  const [currentDate, setCurrentDate] = useState(new Date());
  const [selectDate, setSelectDate] = useState([]);
  const [currentMonth, setCurrentMonth] = useState(new Date().getMonth() + 1);
  const [nextMonth, setNextMonth] = useState(new Date().getMonth() + 2);
  const [currentYear, setCurrentYear] = useState(new Date().getYear() + 1900);
  const [changeMonth, setChangeMonth] = useState(false);

  const reservations = [
    {
      id: 1,
      fechaInicial: "2023-03-18",
      fechaFinal: "2023-03-21",
    },
    {
      id: 2,
      fechaInicial: "2023-04-02",
      fechaFinal: "2023-04-10",
    },
    {
      id: 3,
      fechaInicial: "2023-04-12",
      fechaFinal: "2023-04-22",
    },
  ];

  const getDatesRange = (start, finish) => {
    const date = new Date(start.setDate(start.getDate() + 1));
    const finishDate = new Date(finish.setDate(finish.getDate() + 1));
    const dates = [];

    while (date <= finishDate) {
      dates.push(new Date(date));
      date.setDate(date.getDate() + 1);
    }

    return dates;
  };

  let newReservation = [];
  if (selectDate.length === 2) {
    newReservation = getDatesRange(
      new Date(selectDate[0]),
      new Date(selectDate[1])
    );
  }

  let unavailableDatesRange = reservations.map((date, i) =>
    getDatesRange(new Date(date.fechaInicial), new Date(date.fechaFinal))
  );

  const alreadyReserved = unavailableDatesRange.flat(1);

const Calendar = ({ productId }) => {
  const [currentDate, setCurrentDate] = useState(new Date())
  const [selectDate, setSelectDate] = useState([])
  const [currentMonth, setCurrentMonth] = useState(new Date().getMonth() + 1)
  const [nextMonth, setNextMonth] = useState(new Date().getMonth() + 2)
  const [currentYear, setCurrentYear] = useState(new Date().getYear() + 1900)
  const [changeMonth, setChangeMonth] = useState(false)

  const unavailable = formateDate(alreadyReserved);
  const formatedNewReservation = formateDate(newReservation);
  console.log(selectDate);

  const unavailableDates = (i, month, year) => {
    let selected = format(new Date(`${year}-${month}-${i + 1}`), "yyyy-MM-dd");

    if (unavailable.includes(selected)) {
      return "unavailable";
    } else if (
      (!unavailable.includes(selected) &&
        formatedNewReservation.includes(selected)) ||
      selectDate.includes(selected)
    ) {
      return "selected";
    }

    return "available";
  };

  const handleSelectDates = (i, year, month) => {
    let displayDate = format(
      new Date(`${year}-${month}-${i + 1}`),
      "yyyy-MM-dd"
    );

    const range = formateDate(
      getDatesRange(new Date(selectDate[0]), new Date(displayDate))
    );

    if (
      !selectDate.includes(displayDate) &&
      !unavailable.includes(displayDate) &&
      selectDate.length <= 2
    ) {
      setSelectDate([...selectDate, displayDate]);
    }

    if (selectDate.length === 1) {
      if (range.some((i) => unavailable.includes(i))) {
        setSelectDate([displayDate]);
      } else if (selectDate[0] > displayDate) {
        setSelectDate([displayDate]);
      } else if (selectDate[0] == displayDate) {
        setSelectDate([]);
      }
    }

    if (selectDate.length === 2) {
      setSelectDate([displayDate]);
    }
  };

  const getDaysInAMonth = (year, month) => {
    return new Date(year, month, 0).getDate();
  };

  const getStartOfMonth = (year, month) => {
    const date = new Date(`${year}-${month}-1`);
    const startDate = startOfMonth(date);
    return startDate.getDay();
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
    toggleAnimation();
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
    toggleAnimation();
  };

  const completeCalendar = (month, year) => {
    return 42 - getStartOfMonth(year, month) - getDaysInAMonth(year, month);
  };

  const toggleAnimation = () => {
    setChangeMonth(!changeMonth);
  };

  const pastDates = (day, month) => {
    if (
      (day < currentDate.getDate() &&
        month <= currentDate.getMonth() + 1 &&
        currentYear <= currentDate.getFullYear()) ||
      (day >= currentDate.getDate() &&
        month < currentDate.getMonth() + 1 &&
        currentYear <= currentDate.getFullYear()) ||
      currentYear < currentDate.getFullYear()
    ) {
      return "past-date";
    } else return "";
  };

  const getToday = (day, month, year) => {
    if (
      day + 1 === currentDate.getDate() &&
      month === currentDate.getMonth() + 1 &&
      year === currentDate.getFullYear()
    ) {
      return "today";
    }
    ("");
  };

  return (
    <div className="calendar-layout">
      <div className="calendar-details">
        <button onClick={prevMonth} className="change-month-button left">
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
              )} day-of-month ${pastDates(i + 1, currentMonth)} ${
                changeMonth ? "fade-in" : "fade-out"
              } ${getToday(i, currentMonth, currentYear)} `}
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
          {Array.from({
            length: getStartOfMonth(currentYear, nextMonth),
          }).map((_, i) => (
            <p key={i}></p>
          ))}
          {Array.from({
            length: getDaysInAMonth(currentYear, nextMonth),
          }).map((_, i) => (
            <p
              className={`${unavailableDates(
                i,
                nextMonth,
                currentYear
              )} day-of-month ${pastDates(i + 1, nextMonth)} ${
                changeMonth ? "fade-in" : "fade-out"
              } ${getToday(i, nextMonth, currentYear)}`}
              onClick={() => handleSelectDates(i, currentYear, nextMonth)}
              key={i}
            >
              {i + 1}
            </p>
          ))}
          {Array.from({
            length: completeCalendar(nextMonth, currentYear),
          }).map((_, i) => (
            <p key={i} className="day-of-other-month">
              {i + 1}
            </p>
          ))}
        </div>
        <button className="change-month-button right" onClick={followingMonth}>
          <FontAwesomeIcon icon={faChevronRight}></FontAwesomeIcon>
        </button>
      </div>
    </div>
  );
}

export default Calendar;
