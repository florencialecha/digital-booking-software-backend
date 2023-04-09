import React from "react";

const ReserveCard = ({ styles }) => {
  return (
    <div className={styles.reserveCard}>
      <h1>Titulo del producto</h1>
      <p>Check In</p>
      <p>Check Out</p>
      <p>Hora?</p>
    </div>
  );
};

export default ReserveCard;
