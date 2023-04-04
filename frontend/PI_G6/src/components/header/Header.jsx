import React, { useContext, useEffect, useState } from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";
import Social from "../socials/Social";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faBars, faXmark } from "@fortawesome/free-solid-svg-icons";
import { faHeart } from "@fortawesome/free-regular-svg-icons";
import "./header.css";
import { GlobalContext } from "../../utils/globalContext";
import Favorites from "../favorites/Favorites";
import Spinner from "../favorites/Spinner";

const Header = () => {
  const loggedUser = JSON.parse(localStorage.getItem("JWT"));
  const user = JSON.parse(localStorage.getItem("user"));
  const [openMenu, setOpenMenu] = useState(false);
  const { state } = useContext(GlobalContext);
  const navigate = useNavigate();
  const location = useLocation();
  const [loading, setLoading] = useState(false);
  const [show, setShow] = useState(false);

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
      localStorage.removeItem("JWT");
      localStorage.removeItem("goToFavs");
      navigate("/");
    }
  };

  const handleMenu = () => {
    toggleMenu();
  };

  const handleFavs = () => {
    navigate("/favorites");
    if (window.screen.width <= 600) {
      toggleMenu();
    }
  };

  const loadFavs = () => {
    if (!show)
      setTimeout(() => {
        setLoading(!loading);
      }, 1000);
    setShow(true);
  };

  const reset = () => {
    setShow(false);
    setLoading(false);
  };

  return (
    <nav className="header">
      <Link to={"/"}>
        <div className="logo">
          <img
            src="https://i.ibb.co/W5J7Jy6/logo-orange.png"
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
          <>
            <div
              onMouseLeave={reset}
              onMouseEnter={loadFavs}
              className={
                location.pathname === "/favorites" ? "hide" : "favContainer"
              }
            >
              <div className="favIcon" onClick={handleFavs}>
                {!openMenu ? (
                  <FontAwesomeIcon className="fav" icon={faHeart} size="xl" />
                ) : (
                  <p className="favLink">Favoritos</p>
                )}
              </div>
              <div className="favsMenu">
                <h4>Favoritos</h4>
                {show && loading ? (
                  <>
                    <Favorites />
                    <div
                      className={
                        state.favs.length === 0 ? "hideButton" : "favButtonDiv"
                      }
                    >
                      <a href="/favorites">Ver todos</a>
                    </div>
                  </>
                ) : (
                  <Spinner />
                )}
              </div>
            </div>
            <div className="profileInfo">
              <div className="logout">
                <FontAwesomeIcon
                  onClick={handleLogout}
                  icon={faXmark}
                ></FontAwesomeIcon>
              </div>
              <div className="profile-info-web">
                <p className="profileAvatar">JD</p>
                <p className="profileName">
                  Hola, <br></br>
                  <span>John Doe</span>
                </p>
              </div>
              <p className="logoutMobile">
                ¿Deseas <span onClick={handleLogout}>cerrar sesión</span>?
              </p>
              <hr />
            </div>
          </>
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
