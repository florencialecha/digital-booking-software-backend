import { React, useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import "./ProductDetails.css";
import data from "../../temp/apiProducts.json";
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

import axios from "axios";

const ProductDetails = () => {
  const [product, setProduct] = useState(null);
  const { id } = useParams();

  useEffect(() => {
    axios
      .get(`https://jsonplaceholder.typicode.com/users/${id}`)
      .then((res) => setProduct(res.data))
      .catch((error) => console.log(error));
  }, [id]);

  const navigate = useNavigate();

  return (
    <div className="details-container">
      <div className="details-header">
        <ProductHeader generalInfo={data} />
      </div>
      <div className="details-body">
        <div className="details-location-scoring-info">
          <div className="details-location">
            <div className="details-location-icon">
              <FontAwesomeIcon icon={faLocationDot}></FontAwesomeIcon>
            </div>
            <div className="details-location-info">
              <p>
                {" "}
                {data.address.street} {data.address.number} {data.address.town}{" "}
                {data.address.country}
              </p>
              <p className="details-distance">A 940 m del centro</p>
            </div>
          </div>
          <div className="details-scoring">
            <div className="details-review">
              <p>{data.review}</p>
              <p>
                <CardStars {...data} />{" "}
              </p>
            </div>
            <div className="details-score">
              <p>{data.scoring}</p>
            </div>
          </div>
        </div>
        <div>
          <div className="details-share">
            <FontAwesomeIcon icon={faShareNodes} size="lg"></FontAwesomeIcon>
            <FontAwesomeIcon icon={faHeart} size="lg"></FontAwesomeIcon>
          </div>
          <div className="details-galery">
            <Gallery pictures={data.imageUrl} />
          </div>
        </div>
        <div className="details-description">
          <h2>Alójate en el corazón de {data.address.town}</h2>
          <Description data={data} />
        </div>
        <h2>¿Qué ofrece este lugar?</h2>
        <hr className="details-line" />
        <div className="details-char">
          <Features specs={data.specifications} />
        </div>
        <div className="details-available-dates">
          <h2>Fechas disponibles</h2>
          <Calendar />
        </div>
        <div className="details-map">
          <h2>¿Dónde vas a estar?</h2>

          <hr className="details-line" />
          <p>
            {data.address.town}, {data.address.country}
          </p>
          <Map address={data.address} />
        </div>
        <div className="details-policies">
          <h2> ¿Qué tenés que saber?</h2>
          <hr className="details-line" />
          <Policies policies={data.policies} />
        </div>
      </div>
    </div>
  );
};

export default ProductDetails;
