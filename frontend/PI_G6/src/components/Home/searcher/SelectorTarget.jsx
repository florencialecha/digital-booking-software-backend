import React, { useState, useEffect } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faLocationDot } from "@fortawesome/free-solid-svg-icons";
import "./Searcher.css";
import axios from "axios";
import useComponentVisible from "../../../hooks/useComponentVisible";
import { apiCountry } from "../../../utils/apiEndpoints";

const selectorTarget = ({ setSelected }) => {
  // const [isActive, setIsActive] = useState(true)
  const [search, setSearch] = useState("");
  const [data, setData] = useState([]);

  const inputToSearch = (e) => {
    setSearch(e.target.value);
  };

  useEffect(() => {
    axios
      .get(apiCountry)
      .then((res) => setData(res.data))
      .catch((error) => console.log(error));
  }, []);

  const places = [
    ...new Map(data.map((place) => [place.name, place])).values(),
  ];

  const { selectorRef, isActive, setIsActive } = useComponentVisible(false);

  return (
    <form action="" className="formClass">
      <div
        ref={selectorRef}
        className="selectbox"
        onClick={() => setIsActive((prev) => !prev)}
      >
        <div id="select" className="select">
          <FontAwesomeIcon icon={faLocationDot} />
          <input
            className="select-content"
            value={search}
            onClick={() => setSearch("")}
            onChange={inputToSearch}
            placeholder="A donde vamos"
          ></input>
        </div>
        <div id="options" className={isActive ? "active" : "inactive"}>
          {places.map((countrys) => {
            return (
              <div key={countrys.id}>
                {countrys.states.map((state) => {
                  return (
                    <div key={state.id} className="states">
                      {state.cities
                        .filter((city) => {
                          if (!search) {
                            return city;
                          } else {
                            city = city.name
                              .toLowerCase()
                              .includes(search.toLowerCase());
                            return city;
                          }
                        })
                        .map((city) => {
                          return (
                            <a
                              href="#"
                              key={city.id}
                              onClick={() => {
                                setSearch(`${city.name}, ${countrys.name}`);
                                setSelected(`${city.name}, ${countrys.name}`);
                              }}
                            >
                              <div className="content-option">
                                <FontAwesomeIcon icon={faLocationDot} />
                                <div className="texts">
                                  <p>{city.name} </p>
                                  <p>{countrys.name}</p>
                                </div>
                              </div>
                            </a>
                          );
                        })}
                    </div>
                  );
                })}
              </div>
            );
          })}
        </div>
      </div>
    </form>
  );
};

export default selectorTarget;
