import React, { useEffect } from "react";
import { Link } from "react-router-dom";

const formatDate = (dateArray) => `${dateArray[0]}-${dateArray[1]}-${dateArray[2]} ${dateArray[3]}:${dateArray[4] == 0 ? '00' : dateArray[4]}`;

const FlightsPage = ({ flights, actions: { fetchFlights } }) => {
  useEffect(() => {
    fetchFlights();
  }, []);

  if (!flights || flights.loading) {
    return "Loading...";
  }

  return (
    <div className="FlightsPage p-5">
      <Link className="btn btn-primary mb-5" to="/flights/create">
        Zbor nou
      </Link>

      <div className="list-group">
        {flights.data.map(
          ({
            idZbor,
            avion,
            pilot: { nume, prenume, nrOreZbor },
            rute,
            dataPlecare,
            dataSosire,
          }) => {
            const aeroportPlecare = rute[0].aeroportPlecare;
            const aeroportDestinatie = rute[0].aeroportDestinatie;

            return (
              <div className="list-group-item" key={idZbor}>
                <div>
                  <span className="mr-1 font-weight-bold">ID:</span>
                  <span>{idZbor}</span>
                </div>

                <div>
                  <span className="mr-1 font-weight-bold">Data plecare:</span>
                  <span>{formatDate(dataPlecare)}</span>
                </div>

                <div>
                  <span className="mr-1 font-weight-bold">Data sosire:</span>
                  <span>{formatDate(dataSosire)}</span>
                </div>

                <div>
                  <span className="mr-1 font-weight-bold">
                    Aeroport plecare:
                  </span>
                  <span>{`${aeroportPlecare.locatie.tara}, ${aeroportPlecare.locatie.oras}, ${aeroportPlecare.locatie.adresa}`}</span>
                </div>

                <div>
                  <span className="mr-1 font-weight-bold">
                    Aeroport sosire:
                  </span>
                  <span>{`${aeroportDestinatie.locatie.tara}, ${aeroportDestinatie.locatie.oras}, ${aeroportDestinatie.locatie.adresa}`}</span>
                </div>

                <div>
                  <span className="mr-1 font-weight-bold">Avion:</span>
                  <span>{avion.marca.nume}</span>
                </div>

                <div>
                  <span className="mr-1 font-weight-bold">Pilot:</span>
                  <span>{`${nume} ${prenume}. Ore zburate: ${nrOreZbor}`}</span>
                  
                </div>
              </div>
            );
          }
        )}
      </div>
    </div>
  );
};

export default FlightsPage;
