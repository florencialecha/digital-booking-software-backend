import React, { useState } from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";
import Social from "../socials/Social";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBars, faXmark } from "@fortawesome/free-solid-svg-icons";
import "./header.css";

const Header = () => {
  const loggedUser = JSON.parse(localStorage.getItem("userLoggedIn"));
  const user = JSON.parse(localStorage.getItem("user"));
  const [openMenu, setOpenMenu] = useState(false);
  const navigate = useNavigate();
  const location = useLocation();

  const toggleMenu = () => {
    setOpenMenu(!openMenu);
  };

  const handleRegister = () => {
    navigate("/register");
    if (window.screen.width <= 600) {
      toggleMenu();
    }
  };

  const handleLogin = () => {
    navigate("/login");
    if (window.screen.width <= 600) {
      toggleMenu();
    }
  };

  const handleLogout = () => {
    const confirmLogout = confirm(
      "¿Estás seguro de que quieres cerrar la sesión?"
    );
    if (confirmLogout) {
      localStorage.removeItem("userLoggedIn");
      navigate("/");
    }
  };

  const handleMenu = () => {
    toggleMenu();
  };

  return (
    <nav>
      <Link to={"/"}>
        <div className="logo">
          <img
            src="/src/assets/logo_orange.png"
            alt="Logo from Digital Booking"
          />
          <p className="slogan">Sentite como en tu hogar</p>
        </div>
      </Link>
      <button onClick={handleMenu} className="hamburgerMenu">
        <FontAwesomeIcon icon={faBars} size="2xl"></FontAwesomeIcon>
      </button>
      <div
        className={`${
          window.screen.width > 600 && !openMenu ? "navMenu" : ""
        } ${
          window.screen.width <= 600 && openMenu
            ? "navMenuMobile slide-in"
            : "hideMenu"
        }`}
      >
        <div className="menuHeader">
          <button onClick={handleMenu} className="closeMenu">
            <FontAwesomeIcon icon={faXmark}></FontAwesomeIcon>
          </button>
          <h3 className={`${loggedUser ? "hide" : "menuHeading"}`}>MENÚ</h3>
        </div>
        {loggedUser ? (
          <div className="profileInfo">
            <div className="logout">
              <FontAwesomeIcon
                onClick={handleLogout}
                icon={faXmark}
              ></FontAwesomeIcon>
            </div>
            <div className="profile-info-web">
              <p className="profileAvatar">
                {user.name.slice(0, 1)}
                {user.lastName.slice(0, 1)}
              </p>
              <p className="profileName">
                Hola, <br></br>
                <span>
                  {user.name}
                  {""} {user.lastName}
                </span>
              </p>
            </div>
            <p className="logoutMobile">
              ¿Deseas <span onClick={handleLogout}>cerrar sesión</span>?
            </p>
            <hr />
          </div>
        ) : (
          <div className="formButtons">
            <button
              className={location.pathname !== "/register" ? "btn" : "hidden"}
              onClick={handleRegister}
            >
              Crear cuenta
            </button>
            <hr
              className={
                location.pathname !== "/" || window.screen.width > 600
                  ? "hide"
                  : "hr"
              }
            />
            <button
              className={location.pathname === "/login" ? "hidden" : "btn"}
              onClick={handleLogin}
            >
              Iniciar Sesión
            </button>
          </div>
        )}
        <Social />
      </div>
    </nav>
  );
};

export default Header;
