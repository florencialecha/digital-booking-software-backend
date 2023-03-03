import React from "react";
import "./ProductHeader.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faLessThan } from "@fortawesome/free-solid-svg-icons";
import { useNavigate } from "react-router";

const ProductHeader = ({ generalInfo }) => {
  const navigate = useNavigate();
  return (
    <div>
      <p>{generalInfo.Category}</p>
      <p>{generalInfo.title}</p>

      <FontAwesomeIcon
        icon={faLessThan}
        size="xl"
        onClick={() => navigate("/")}
      />
    </div>
  );
};

export default ProductHeader;
