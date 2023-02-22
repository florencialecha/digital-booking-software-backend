import React, { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { useFormik } from "formik";
import * as yup from "yup";
import { BsEyeSlash } from "react-icons/bs";
import "./form.css";

const LoginForm = () => {
  const navigate = useNavigate();
  const [showPassword, setShowPassword] = useState(false);

  const onSubmit = async (values, actions) => {
    await new Promise((resolve) => setTimeout(resolve, 1000));
    actions.resetForm();
    const user = JSON.parse(localStorage.getItem("user"));
    if (values.email === user.email && values.password === user.password) {
      navigate("/");
      localStorage.setItem("userLoggedIn", true);
    } else {
      document.querySelector(
        ".failed-validation"
      ).innerHTML = `<p>Por favor vuelva a intentarlo, sus credenciales son inválidas.</p>`;
    }
  };

  const schema = yup.object({
    email: yup
      .string()
      .email("El correo electrónico ingresado no es válido")
      .required("Este campo es obligatorio"),
    password: yup.string().required("Este campo es obligatorio"),
  });

  const {
    values,
    errors,
    touched,
    handleSubmit,
    handleChange,
    handleBlur,
    isSubmitting,
  } = useFormik({
    initialValues: {
      email: "",
      password: "",
    },
    validationSchema: schema,
    onSubmit,
  });

  const handleShowPassword = () => {
    setShowPassword(!showPassword);
  };

  return (
    <div className="loginForm">
      <h1>Iniciar sesión</h1>
      <form onSubmit={handleSubmit}>
        <label htmlFor="email">Correo electrónico</label>
        <input
          type="email"
          id="email"
          name="email"
          value={values.email}
          onChange={handleChange}
          onBlur={handleBlur}
          className={errors.email && touched.email ? "input-error" : ""}
        />

        {errors.email && touched.email && (
          <p className="error">{errors.email}</p>
        )}
        <label htmlFor="password">Contraseña</label>
        <input
          type={showPassword ? "text" : "password"}
          placeholder=""
          id="password"
          name="password"
          value={values.password}
          onChange={handleChange}
          onBlur={handleBlur}
          className={errors.password && touched.password ? "input-error" : ""}
        />
        <span className="showPass" onClick={handleShowPassword}>
          <BsEyeSlash />
        </span>
        {errors.password && touched.password && (
          <p className="error">{errors.password}</p>
        )}
        <div className="failed-validation"></div>
        <button disabled={isSubmitting} type="submit">
          Ingresar
        </button>

        <p className="register">
          ¿Aún no tienes cuenta? <Link to="/register">Registarte</Link>
        </p>
      </form>
    </div>
  );
};

export default LoginForm;
