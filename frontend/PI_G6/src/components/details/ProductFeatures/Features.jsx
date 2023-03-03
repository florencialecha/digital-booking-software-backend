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

const icon = [
  {
    title: "cocina",
    iconName: faKitchenSet,
  },
  { title: "wifi", iconName: faWifi },
  { title: "pileta", iconName: faPersonSwimming },
  { title: "aire acondicionado", iconName: faSnowflake },
  { title: "apto mascotas", iconName: faPaw },
  { title: "estacionamiento gratuito", iconName: faCar },
  { title: "television", iconName: faTv },
];

const Features = ({ specs }) => {
  return (
    <div>
      {specs.map((item) => {
        let iconos = icon.find((i) => i.title === item.title);
        console.log(iconos);
        return (
          <div key={item.title}>
            <FontAwesomeIcon icon={iconos?.iconName}></FontAwesomeIcon>
            <span>{iconos?.title}</span>
          </div>
        );
      })}
    </div>
  );
};

export default Features;
