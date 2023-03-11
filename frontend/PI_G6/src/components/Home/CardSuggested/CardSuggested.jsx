import { React, useState } from "react";
import "./CardSuggested";
import CardStars from "./CardStars";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faLocationDot, faHeart } from "@fortawesome/free-solid-svg-icons";
import Features from "../../details/ProductFeatures/Features";

const CardSuggested = (suggest) => {
  const [isActive, setActive] = useState(false);

  const handleToggle = () => {
    setActive(!isActive);
  };

  const handleClickMap = () => {
    window.open(
      `https://www.google.com/maps/embed/v1/place?key=AIzaSyDO5woQG6Ni56if3gOVoVoP3coiwxg4huI
  &q=${suggest.address.street}+${suggest.address.number},${suggest.address.city.name}+${suggest.address.city.state.name}+${suggest.address.city.state.country.name}&zoom=19`,
      "register",
      'width=800,height=600, top=0, left=960"'
    );
    return false;
  };

  return (
    <div className="card-container">
      <FontAwesomeIcon
        className={`fav-icon full-${isActive}`}
        icon={faHeart}
        onClick={handleToggle}
      />
      <section>
        <img src={suggest.imageList[0]?.imageUrl} />
        <div className="card-information">
          <div className="card-title">
            <article>
              <div>
                {suggest.category.title} <CardStars {...suggest} />
              </div>
              <p id="suggest-name">{suggest.title}</p>
            </article>
            <div className="valoration">
              <p>{suggest.scoring}</p>
              <p>{suggest.review}</p>
            </div>
          </div>
          <div className="card-location" id="card-location">
            <div>
              <FontAwesomeIcon icon={faLocationDot} />
              <p>a 300m del centro</p>
            </div>
            <a href="" onClick={handleClickMap}>
              <p>MOSTRAR EN EL MAPA</p>
            </a>
          </div>
          <Features className="service-icons" specs={suggest.featureList} />
          <div id="card-description">
            {suggest.description?.length > 30 ? (
              <p>
                {suggest.description.substring(0, 30)}
                <a className="moreText" href="#">
                  {" "}
                  mas...
                </a>
              </p>
            ) : (
              <p>{suggest.description}</p>
            )}
          </div>
          <div className="see-more">
            <button>
              <a href={`/product/${suggest.id}`}>ver más</a>
            </button>
          </div>
        </div>
      </section>
    </div>
  );
};

export default CardSuggested;
