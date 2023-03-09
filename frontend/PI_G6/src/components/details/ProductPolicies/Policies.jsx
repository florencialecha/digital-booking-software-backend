import React from "react";
import "./Policies.css";

const Policies = ({ policies }) => {
  return (
    <div className="detail-policies">
      <div className="detail-rules">
        <h3>Normas de la casa</h3>
        <p>{policies?.rulesDescription}</p>
      </div>
      <div className="detail-security">
        <h3>Salud y seguridad</h3>
        <p>{policies?.securityDescription}</p>
      </div>

      <div className="detail-cancelation">
        <h3>Política de cancelación</h3>
        <p>{policies?.cancellationDescription}</p>
      </div>
    </div>
  );
};

export default Policies;
