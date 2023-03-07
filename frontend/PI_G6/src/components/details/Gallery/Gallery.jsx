import React from "react";
import "./Gallery.css";

const Gallery = ({ pictures }) => {
  console.log(pictures);
  return (
    <div>
      <div>
        <div className="details-images">
          {pictures.length >= 5
            ? pictures
                .slice(0, 5)
                .map((img, i) => (
                  <img
                    key={img.id}
                    className={`img${i + 1}`}
                    src={img.imageUrl}
                  ></img>
                ))
            : pictures.map((img, i) => (
                <img
                  key={img.id}
                  className={`img${i + 1}`}
                  src={img.imageUrl}
                ></img>
              ))}
        </div>
        <div className="see-more-div">
          {pictures.length >= 5 ? <p className="see-more-btn">Ver más</p> : ""}
        </div>
      </div>
    </div>
  );
};

export default Gallery;
