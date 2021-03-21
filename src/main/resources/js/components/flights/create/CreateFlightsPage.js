import React, { useState, useEffect } from "react";
import { Button, Form } from "react-bootstrap";
import { Link, Redirect } from "react-router-dom";
import Select from "react-select";
import "react-datepicker/dist/react-datepicker.css";
import ReactDatePicker from "react-datepicker";

const CreateFlightsPage = ({
  airplanes,
  routes,
  pilots,
  actions: { fetchPilots, fetchAirplanes, fetchRoutes, createFlight },
}) => {
  const [pilot, setPilot] = useState(null);
  const [route, setRoute] = useState(null);
  const [airplane, setAirplane] = useState(null);
  const [departureDate, setDepartureDate] = useState(null);
  const [arrivalDate, setArrivalDate] = useState(null);
  const [shouldRedirect, setShouldRedirect] = useState(false);

  useEffect(() => {
    fetchPilots();
    fetchAirplanes();
    fetchRoutes();
  }, []);

  const airplanesLoading = !airplanes || airplanes.loading;
  const routesLoading = !routes || routes.loading;
  const pilotsLoading = !pilots || pilots.loading;

  if (pilotsLoading || routesLoading || airplanesLoading) {
    return "Loading...";
  }

  const airplaneOptions = airplanes.data.map((airplane) => ({
    value: airplane.id,
    label: airplane.marca.nume,
  }));

  const routesOptions = routes.data.map((route) => ({
    value: route.idRuta,
    label:
      route.aeroportPlecare.denumire +
      " -> " +
      route.aeroportDestinatie.denumire,
  }));

  const pilotsOptions = pilots.data.map((pilot) => ({
    value: pilot.idPilot,
    label: pilot.nume + " " + pilot.prenume,
  }));

  if (shouldRedirect) {
    return <Redirect to="/flights" />
  }
  
  return (
    <div className="CreateFlightsPage w-50 mx-5 my-5">
      <Link className="btn btn-secondary mb-5" to="/flights">
        Inapoi
      </Link>

      <Form>
        <div className="my-2">
          <div className="my-1">Pilot: </div>
          <Select
            options={pilotsOptions}
            placeholder="Alege pilot"
            onChange={(pilot) => {
              setPilot(pilot);
            }}
            name="pilot"
          />
        </div>

        <div className="my-2">
          <div className="my-1">Avion: </div>
          <Select
            options={airplaneOptions}
            placeholder="Alege avion"
            onChange={(avion) => {
              setAirplane(avion);
            }}
            name="airplanes"
          />
        </div>

        <div className="my-2">
          <div className="my-1">Ruta: </div>
          <Select
            options={routesOptions}
            placeholder="Alege ruta"
            onChange={(ruta) => {
              setRoute(ruta);
            }}
            name="routes"
          />
        </div>

        <div className="my-2">
          <div>Data plecare:</div>
          <ReactDatePicker
            selected={departureDate}
            showTimeSelect
            onChange={(date) => setDepartureDate(date)}
          />
        </div>

        <div className="my-2">
          <div>Data sosire:</div>
          <ReactDatePicker
            selected={arrivalDate}
            showTimeSelect
            onChange={(date) => setArrivalDate(date)}
          />
        </div>

        <Button
          onClick={() => {
            createFlight({
              idAvion: airplane.value,
              idPilot: pilot.value,
              idRuta: route.value,
              dataPlecare: departureDate,
              dataSosire: arrivalDate,
            }).then(() => setShouldRedirect(true));
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

export default CreateFlightsPage;
