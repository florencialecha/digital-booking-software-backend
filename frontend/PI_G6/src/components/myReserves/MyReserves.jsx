import React, { useEffect, useState } from "react";
import "./MyReserves.css";
import ReserveCard from "./ReserveCard";
import { apiMyReserves } from "../../utils/apiEndpoints";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faChevronLeft } from "@fortawesome/free-solid-svg-icons";
import { useNavigate } from "react-router";

const MyReserves = () => {
  const [reserves, setReserves] = useState([]);
  const token = JSON.parse(localStorage.getItem("JWT"));

  const navigate = useNavigate();

  const goBack = () => {
    navigate("/");
  };

  //   useEffect(() => {
  //     axios
  //       .get(apiMyReserves, {
  //         headers: {
  //           "Content-Type": "application/json",
  //           Authorization: `Bearer ${token}`,
  //         },
  //       })
  //       .then((response) => {
  //         console.log(response);
  //         // setReserves();
  //       })
  //       .catch((error) => {
  //         console.log(error);
  //       });
  //   });

  return (
    <div className="reserveWrapper">
      <div className="reserveHeader">
        <h1>Mis reservas</h1>
        <FontAwesomeIcon
          onClick={goBack}
          inverse
          icon={faChevronLeft}
          size="2xl"
        />
      </div>
      <div className="reserveCardContainer">
        <ReserveCard reserves={reserves} />
        <ReserveCard reserves={reserves} />
        <ReserveCard reserves={reserves} />
        <ReserveCard reserves={reserves} />
        <ReserveCard reserves={reserves} />
      </div>
    </div>
  );
};

export default MyReserves;
