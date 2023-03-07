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
  return (
    <div className="features">
      <div className="features-body">
        {specs.map((item) => {
          let iconos = icon.find((i) => i.title.toLowerCase() === item.title);
          console.log(iconos);
          return (
            <div key={item.title} className="feature-icons">
              <FontAwesomeIcon
                icon={iconos?.iconName}
                size="lg"
              ></FontAwesomeIcon>
              <span>{iconos?.title}</span>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default Features;
