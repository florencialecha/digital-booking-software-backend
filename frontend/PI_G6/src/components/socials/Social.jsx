import React from "react";
import "./social.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faFacebook,
  faLinkedinIn,
  faTwitter,
  faInstagram,
} from "@fortawesome/free-brands-svg-icons";

const Social = () => {
  return (
    <div className="socials">
      <FontAwesomeIcon icon={faFacebook} size="xl" />
      <FontAwesomeIcon icon={faLinkedinIn} size="xl" />
      <FontAwesomeIcon icon={faTwitter} size="xl" />
      <FontAwesomeIcon icon={faInstagram} size="xl" />
    </div>
  );
};

export default Social;
