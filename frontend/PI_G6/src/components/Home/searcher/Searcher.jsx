import React, { useContext, useState } from "react";
import "./Searcher.css";
import SelectorTarget from "./SelectorTarget";
import DatePick from "./DatePick";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCalendarDay } from "@fortawesome/free-solid-svg-icons";
import { GlobalContext } from "../../../utils/globalContext";

const Searcher = () => {
  const [selected, setSelected] = useState("");
  const [toggleCalendar, setToggleCalendar] = useState(false);
  const { state, dispatch } = useContext(GlobalContext);

  const handleSelectCity = () => {
    dispatch({ type: "city", payload: selected.split(",")[0] });
    dispatch({ type: "data", payload: "-1" });
  };

  const handleCalendar = () => {
    setToggleCalendar(!toggleCalendar);
  };

  return (
    <section className="searcher">
      <h1>Busca ofertas en hoteles, casas y mucho más</h1>
      <section className="searcher-input-grid">
        <div className="location-container">
          <SelectorTarget selected={selected} setSelected={setSelected} />
        </div>
        <div className="calendar" id="calendar">
          <FontAwesomeIcon onClick={handleCalendar} icon={faCalendarDay} />
          <DatePick
            toggleCalendar={toggleCalendar}
            handleCalendar={handleCalendar}
          />
        </div>
        <button
          onClick={handleSelectCity}
          disabled={selected ? false : true}
          id="btn-search"
        >
          Buscar
        </button>
      </section>
    </section>
  );
};

export default Searcher;
