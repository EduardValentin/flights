import React, { useEffect, useState } from "react";
import { Form, Button } from "react-bootstrap";
import { Link, Redirect } from "react-router-dom";
import Select from "react-select";

const CreateRoutePage = ({
  airports,
  actions: { fetchAirports, createRoute },
}) => {
  const [departureAirport, setDepartureAirport] = useState(null);
  const [arrivalAirport, setArrivalAirport] = useState(null);
  const [shouldRedirect, setShouldRedirect] = useState(false);

  useEffect(() => {
    fetchAirports();
  }, []);

  if (!airports || airports.loading) {
    return "Loading...";
  }

  const airportsList = airports.data;

  const airportsOptions = airportsList.map((airport) => ({
    value: airport.idAeroport,
    label: `${airport.denumire}, ${airport.locatie.tara}`,
  }));

  if (shouldRedirect) {
    return <Redirect to="/routes" />;
  }

  return (
    <div className="CreateRoutePage w-50 mx-5 my-5">
      <Link className="btn btn-secondary mb-5" to="/routes">
        Inapoi
      </Link>

      <Form>
        <div className="my-2">
          <div className="my-1">Aeroport plecare: </div>
          <Select
            options={airportsOptions}
            placeholder="Alege aeroport plecare"
            onChange={(airport) => {
              setDepartureAirport(airport);
            }}
            name="departure_airport"
          />
        </div>

        <div className="my-2">
          <div className="my-1">Aeroport sosire: </div>
          <Select
            options={airportsOptions}
            placeholder="Alege aeroport sosire"
            onChange={(airport) => {
              setArrivalAirport(airport);
            }}
            name="arrival_airport"
          />
        </div>

        <Button
          onClick={() => {
            if (!departureAirport || !arrivalAirport) {
              console.error(
                "You must chose the departure and arrival airports"
              );
              return;
            }

            if (departureAirport.value == arrivalAirport.value) {
              console.error("Airports must be different");
              return;
            }

            createRoute({
              idAeroportPlecare: departureAirport.value,
              idAeroportSosire: arrivalAirport.value,
            }).then(() => {
              setShouldRedirect(true);
            });
          }}
          variant="primary"
          type="button"
        >
          Trimite
        </Button>
      </Form>
    </div>
  );
};

export default CreateRoutePage;
