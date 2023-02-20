import React from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";
import "./header.css";

const Header = () => {
  const loggedUser = JSON.parse(localStorage.getItem("userLoggedIn"));
  const user = JSON.parse(localStorage.getItem("user"));

  const navigate = useNavigate();
  const location = useLocation();

  const handleRegister = () => {
    navigate("/register");
  };

  const handleLogin = () => {
    navigate("/login");
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

  return (
    <nav>
      <Link to={"/"}>
        <div className="">
          <img
            src="./src/assets/logo_orange.png"
            alt="Logo from Digital Booking"
          />

          <p>Sentite como en tu hogar</p>
        </div>
      </Link>

      <div>
        {loggedUser ? (
          <div className="profileInfo">
            <div className="logout">
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
          </div>
        ) : (
          <div>
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
      </div>
    </nav>
  );
};

export default Header;
