import React from "react";
import "./ReserveCard.css";

const ReserveCard = ({ reserves }) => {
  return (
    <div className="reserveCard">
      <h1>Titulo del producto</h1>
      <p>Check In</p>
      <p>Check Out</p>
      <p>Hora?</p>
    </div>
  );
};

export default ReserveCard;
