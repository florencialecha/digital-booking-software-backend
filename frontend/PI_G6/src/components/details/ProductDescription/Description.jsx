import React from "react";
import "./Description.css";

const Description = ({ description }) => {
  console.log(description);
  return (
    <div>
      <p>{description}</p>
    </div>
  );
};

export default Description;
