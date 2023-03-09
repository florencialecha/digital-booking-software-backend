import React from "react";
import "./Features.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faKitchenSet,
  faPersonSwimming,
  faWifi,
  faSnowflake,
  faPaw,
  faCar,
  faTv,
} from "@fortawesome/free-solid-svg-icons";
import { useLocation } from "react-router";

const icon = [
  {
    title: "Cocina",
    iconName: faKitchenSet,
  },
  { title: "WiFi", iconName: faWifi },
  { title: "Pileta", iconName: faPersonSwimming },
  { title: "Aire acondicionado", iconName: faSnowflake },
  { title: "Apto mascotas", iconName: faPaw },
  { title: "Estacionamiento gratuito", iconName: faCar },
  { title: "Televisor", iconName: faTv },
];

const Features = ({ specs }) => {
  const location = useLocation();

  return (
    <div className={location.pathname !== "/" ? "features-home" : ""}>
      <div
        className={
          location.pathname !== "/" ? "features-body" : "features-body-home"
        }
      >
        {specs.map((item) => {
          let iconos = icon.find(
            (i) => i.title.toLowerCase() === item.title.toLowerCase()
          );
          return (
            <div
              key={item.title}
              className={
                location.pathname !== "/"
                  ? "feature-icons"
                  : "feature-icons-home"
              }
            >
              <FontAwesomeIcon
                icon={iconos?.iconName}
                size="lg"
              ></FontAwesomeIcon>
              <span
                className={
                  location.pathname === "/" ? "hide-icon-title" : "icon-name"
                }
              >
                {iconos?.title}
              </span>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default Features;
