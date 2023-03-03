import { React, useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router";
import "./ProductDetails.css";
import data from "../../temp/apiProducts.json";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faLessThan,
  faLocationDot,
  faShareNodes,
  faHeart,
} from "@fortawesome/free-solid-svg-icons";
import Gallery from "./Gallery/Gallery";
import ProductHeader from "./ProductHeader/ProductHeader";
import Description from "./ProductDescription/Description";
import Features from "./ProductFeatures/Features";
import Policies from "./ProductPolicies/Policies";
import Calendar from "./Calendar/Calendar";
import Map from "./Map/Map";

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
  console.log(data);
  console.log(data.specifications);
  //   for (const char in data.specifications) {
  //     console.log(char);
  //   }

  return (
    <div className="details">
      <div className="details-header">
        <ProductHeader generalInfo={data} />
      </div>
      <div className="details-location">
        <div>
          <FontAwesomeIcon icon={faLocationDot}></FontAwesomeIcon>
          <p>
            {" "}
            {data.address.street} {data.address.number} {data.address.town}{" "}
            {data.address.country}
          </p>

          <p>dist to center</p>
        </div>
      </div>
      <div className="details-scoring">
        <div>
          <p></p>
          <div>
            <p>{data.review}</p>
            <p>{data.stars}</p>
          </div>
        </div>

        <p>{data.scoring}</p>
      </div>

      <div>
        <div>
          <FontAwesomeIcon icon={faShareNodes}></FontAwesomeIcon>
          <FontAwesomeIcon icon={faHeart}></FontAwesomeIcon>
        </div>
        <div className="details-galery">
          <Gallery pictures={data.imageUrl} />
        </div>
      </div>
      <div className="details-description">
        <h2>Alejate en el corazón de {data.address.town}</h2>
        <Description description={data.description} />
      </div>
      <div className="details-char">
        <h2>¿Qué ofrece este lugar?</h2>
        <Features specs={data.specifications} />
      </div>
      <div className="details-availableDates">
        <h2>Fechas disponibles</h2>
        <Calendar />
      </div>
      <div>
        <h2>¿Dónde vas a estar?</h2>
        <Map address={data.address} />
      </div>
      <div>
        <h2> ¿Qué tenés que saber?</h2>

        <Policies policies={data.policies} />
      </div>
    </div>
  );
};

export default ProductDetails;
