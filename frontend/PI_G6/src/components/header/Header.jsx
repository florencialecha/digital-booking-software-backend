import React, { useState } from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";
import Social from "../socials/Social";
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
    toggleMenu();
  };

  const handleLogin = () => {
    navigate("/login");
    toggleMenu();
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
            src="./src/assets/logo_orange.png"
            alt="Logo from Digital Booking"
          />

          <p className="slogan">Sentite como en tu hogar</p>
        </div>
      </Link>
      <button onClick={handleMenu} className="hamburgerMenu">
        🍔
      </button>
      <div className={`${!openMenu ? "hideMenu" : "navMenu"}`}>
        <div className="menuHeader">
          <button onClick={handleMenu} className="closeMenu">
            X
          </button>
          <h3 className={`${loggedUser ? "hide" : "menuHeading"}`}>Menu</h3>
        </div>
        {loggedUser ? (
          <div className="profileInfo">
            <div className={openMenu ? "hide" : "logout"}>
              <Link onClick={handleLogout}>X</Link>
            </div>
            <div>
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
              ¿Deseas{" "}
              <Link onClick={handleLogout}>
                <span>cerrar sesión</span>
              </Link>
              ?
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
