import React from "react";
import Social from "../socials/Social";
import "./footer.css";

const Footer = () => {
  return (
    <div className="footer">
      <div className="copyright">
        <span>©2023 Digital Booking</span>
      </div>
      <div className="socialFooter">
        <Social />
      </div>
    </div>
  );
};

export default Footer;
