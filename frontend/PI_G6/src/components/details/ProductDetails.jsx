import React from "react";
import styles from "../details/ProductDetails.module.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faShareNodes,
  faHeart,
  faLocationDot,
} from "@fortawesome/free-solid-svg-icons";
import Gallery from "./Gallery/Gallery";
import ProductHeader from "./ProductHeader/ProductHeader";
import Description from "./ProductDescription/Description";
import Features from "./ProductFeatures/Features";
import Policies from "./ProductPolicies/Policies";
import Calendar from "./Calendar/Calendar";
import Map from "./Map/Map";
import CardStars from "../Home/CardSuggested/CardStars";

const ProductDetails = () => {
  const product = JSON.parse(localStorage.getItem("hotelSelected"));

  const reservations = [
    {
      id: 1,
      fechaInicial: "2023/03/18",
      fechaFinal: "2023/03/19",
    },
    {
      id: 2,
      fechaInicial: "2023/04/02",
      fechaFinal: "2023/04/10",
    },
    {
      id: 3,
      fechaInicial: "2023/04/12",
      fechaFinal: "2023/04/22",
    },
  ];

  return (
    <>
      {product ? (
        <div className={styles.detailsContainer}>
          <div className={styles.detailsHeader}>
            <ProductHeader generalInfo={product} />
          </div>
          <div className={styles.detailsBody}>
            <div className={styles.detailsLocationScoringInfo}>
              <div className={styles.detailsLocation}>
                <div className={styles.detailsLocationIcon}>
                  <FontAwesomeIcon icon={faLocationDot}></FontAwesomeIcon>
                </div>
                <div className={styles.detailsLocationInfo}>
                  <p>
                    {" "}
                    {product.address.street} {product.address.number}
                    {", "}
                    {product.address.city.name}
                    {", "}
                    {product.address.city.state.country.name}
                  </p>
                  <p className={styles.detailsDistance}>A 940 m del centro</p>
                </div>
              </div>
              <div className={styles.detailsScoring}>
                <div className={styles.detailsReview}>
                  <p>{product.review}</p>
                  <CardStars {...product} />{" "}
                </div>
                <div className={styles.detailsScore}>
                  <p>{product.scoring}</p>
                </div>
              </div>
            </div>
            <div>
              <div className={styles.detailsShare}>
                <FontAwesomeIcon
                  icon={faShareNodes}
                  size="lg"
                ></FontAwesomeIcon>
                <FontAwesomeIcon icon={faHeart} size="lg"></FontAwesomeIcon>
              </div>
              <div className={styles.detailsGalery}>
                <Gallery pictures={product.imageList} />
              </div>
            </div>
            <div className={styles.detailsDescription}>
              <h2>Alójate en el corazón de {product.address.city.name}</h2>
              <Description data={product} />
            </div>
            <h2>¿Qué ofrece este lugar?</h2>
            <hr className={styles.detailsLine} />
            <div className={styles.detailsChar}>
              <Features styles={styles} specs={product.featureList} />
            </div>
            <div className={styles.detailsAvailableDates}>
              <h2>Fechas disponibles</h2>
              <Calendar
                product={product}
                styles={styles}
                reservations={reservations}
              />
              <div className={styles.reservationDetails}>
                <p>Agregá tus fechas de viaje para obtener precios exactos</p>
                <button className={styles.reservationButton}>
                  <a href={`/product/${product.id}/reserve`}>Iniciar reserva</a>
                </button>
              </div>
            </div>
            <div className={styles.detailsMap}>
              <h2>¿Dónde vas a estar?</h2>

              <hr className={styles.detailsLine} />
              <p>
                {product.address.city.name},{" "}
                {product.address.city.state.country.name}
              </p>
              <Map address={product.address} />
            </div>
            <div className={styles.detailsPolicies}>
              <h2> ¿Qué tenés que saber?</h2>
              <hr className={styles.detailsLine} />
              <Policies policies={product.policy} />
            </div>
          </div>
        </div>
      ) : (
        ""
      )}
    </>
  );
};

export default ProductDetails;
