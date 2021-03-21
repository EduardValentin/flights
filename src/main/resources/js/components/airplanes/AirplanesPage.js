import React, { useEffect } from "react";
import { Link } from "react-router-dom";

const AirplanesPage = ({ actions: { fetchAirplanes }, airplanes }) => {
  useEffect(() => {
    fetchAirplanes();
  }, []);

  if (!airplanes || airplanes.loading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="p-5">
      <Link className="btn btn-primary mb-5" to="/airplanes/create">
        Avion nou
      </Link>

      <div className="list-group">
        {airplanes.data.map((airplane) => (
          <div className="list-group-item" key={airplane.id}>
            <div>
              <span className="mr-1 font-weight-bold">ID:</span>
              <span>{airplane.id}</span>
            </div>

            <div>
              <span className="mr-1 font-weight-bold">Locuri maxime:</span>
              <span>{airplane.locuriMaxime}</span>
            </div>

            <div>
              <span className="mr-1 font-weight-bold">Model avion:</span>
              <span>{airplane.marca.nume}</span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AirplanesPage;
