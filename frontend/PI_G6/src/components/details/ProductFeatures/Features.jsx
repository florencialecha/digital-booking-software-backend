/* eslint-disable react/prop-types */
import React from "react";
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

const Features = ({ specs, styles }) => {
  const location = useLocation();

  return (
    <div>
      <div className={styles.featuresBody}>
        {specs?.map((item) => {
          const iconos = icon.find(
            (i) => i.title.toLowerCase() === item.title.toLowerCase()
          );
          return (
            <div key={item.title} className={styles.featureIcons}>
              <FontAwesomeIcon
                icon={iconos?.iconName}
                size="lg"
              ></FontAwesomeIcon>
              <span className={styles.iconName}>{iconos?.title}</span>
            </div>
          );
        })}
      </div>
    </div>
  );
};

export default Features;
