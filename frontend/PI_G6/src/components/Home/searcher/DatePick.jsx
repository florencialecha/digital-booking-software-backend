import { React, useContext } from "react";
import Calendar from "../../details/Calendar/Calendar";
import styles from "./DatePick.module.css";
import { GlobalContext } from "../../../utils/globalContext";
import { format } from "date-fns/esm";
import es from "date-fns/locale/es";

const DatePick = ({ toggleCalendar, handleCalendar }) => {
  const { state } = useContext(GlobalContext);

  const handleSubmit = () => {
    handleCalendar();
    localStorage.setItem("reservation", JSON.stringify(state.reservation));
  };

  const reservation = JSON.parse(localStorage.getItem("reservation"));
  const reservations = reservation?.map((re) =>
    format(new Date(re), "dd 'de' MMM.", { locale: es })
  );
  const selectedRange = state.reservation?.map((re) =>
    format(new Date(re), "dd 'de' MMM.", { locale: es })
  );

  return (
    <div className={styles.picker}>
      <div
        className={styles.checkInCheckOut}
        onClick={
          (reservations?.length === 0 && selectedRange?.length === 0) ||
          reservations?.length === 2 ||
          !reservation
            ? handleCalendar
            : null
        }
      >
        <label htmlFor="check-in"></label>

        <input
          className={styles.checkIn}
          type="text"
          id="check-in"
          name="check-in"
          placeholder="Check in"
          autoComplete="off"
          readOnly
          value={
            reservation
              ? reservations[0]
                ? reservations[0]
                : selectedRange[0]
                ? selectedRange[0]
                : ""
              : ""
          }
        />

        <label className={styles.checkOut} htmlFor="check-out">
          -
        </label>
        <input
          type="text"
          id="check-out"
          name="check-out"
          placeholder="Check out"
          autoComplete="off"
          readOnly
          value={
            reservation
              ? reservations[1]
                ? reservations[1]
                : selectedRange[1]
                ? selectedRange[1]
                : ""
              : ""
          }
        />
      </div>
      <div
        className={
          toggleCalendar
            ? `${styles.datePickCalendar}`
            : `${styles.hideCalendar}`
        }
      >
        <Calendar styles={styles} />
        <button
          className={styles.btnDatePick}
          disabled={selectedRange.length <= 1 ? true : false}
          onClick={handleSubmit}
        >
          Aplicar
        </button>
      </div>
    </div>
  );
};

export default DatePick;
