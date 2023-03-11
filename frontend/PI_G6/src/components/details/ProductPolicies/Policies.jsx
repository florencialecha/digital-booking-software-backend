import React from "react";
import "./Policies.css";

const Policies = ({ policies }) => {
  const rules = policies.rulesDescription.split(".");
  const security = policies.securityDescription.split(".");
  const cancellation = policies.cancellationDescription.split(".");

  return (
    <div className="detail-policies">
      <div className="detail-rules">
        <h3>Normas de la casa</h3>
        <p className="rules-body">
          {rules?.map((rule) => (
            <span>{rule}</span>
          ))}
        </p>
      </div>
      <div className="detail-security">
        <h3>Salud y seguridad</h3>
        <p className="security-body">
          {" "}
          {security?.map((sec) => (
            <span>{sec}</span>
          ))}
        </p>
      </div>

      <div className="detail-cancelation">
        <h3>Política de cancelación</h3>
        <p className="cancellation-body">
          {" "}
          {cancellation?.map((can) => (
            <span>{can}</span>
          ))}
        </p>
      </div>
    </div>
  );
};

export default Policies;
