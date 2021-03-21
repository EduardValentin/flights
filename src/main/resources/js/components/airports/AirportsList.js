import React, { useEffect } from "react";
import { Link } from "react-router-dom";

const AirportsList = ({ actions: { fetchAirports }, airports }) => {
  useEffect(() => {
    fetchAirports();
  }, []);

  if (!airports || airports.loading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="p-5">
      <Link className="btn btn-primary mb-5" to="/airports/create">
        Aeroport nou
      </Link>

      <div className="list-group">
        {airports.data.map((airplane) => (
          <div className="list-group-item" key={airplane.id}>
            <div>
              <span className="mr-1 font-weight-bold">ID:</span>
              <span>{airplane.idAeroport}</span>
            </div>

            <div>
              <span className="mr-1 font-weight-bold">Denumire:</span>
              <span>{airplane.denumire}</span>
            </div>

            <div>
              <span className="mr-1 font-weight-bold">Locatie:</span>
              <span>{`${airplane.locatie.tara}, ${airplane.locatie.oras}, ${airplane.locatie.adresa}`}</span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default AirportsList;
