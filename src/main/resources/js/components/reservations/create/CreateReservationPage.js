import React, {useEffect, useState} from "react";
import {Form, Button} from "react-bootstrap";
import {Link} from "react-router-dom";
import Select from "react-select";

const CreateReservationPage = ({
                                 clients,
                                 airplanes,
                                 flights,
                                 actions: {
                                   fetchFlights,
                                   fetchClients,
                                   fetchAirplanes,
                                   fetchAirplaneSeats,
                                   createReservation,
                                 },
                               }) => {
  const [client, setClient] = useState(null);
  const [flight, setFlight] = useState(null);
  const [airplane, setAirplane] = useState(null);
  const [pret, setPret] = useState(null);
  const [discount, setDiscount] = useState(null);
  const [status, setStatus] = useState(null);
  const [shouldRedirect, setShouldRedirect] = useState(null);
  const [showNewClientForm, setShowNewClientForm] = useState(false);
  const [loc, setLoc] = useState(null);

  useEffect(() => {
    fetchFlights();
    fetchClients();
    fetchAirplanes();
  }, []);

  const clientsLoading = !clients || clients.loading;
  const airplanesLoading = !airplanes || airplanes.loading;
  const flightsLoading = !flights || flights.loading;

  if (clientsLoading || airplanesLoading || flightsLoading) {
    return "Loading...";
  }

  const airplaneOptions = airplanes.data.map((a) => ({
    value: a.id,
    label: a.marca.nume,
  }));

  const clientsOptions = clients.data.map((c) => ({
    value: c.cnp,
    label: c.nume + " " + c.prenume,
  }));

  const flightsOptions = flights.data.map((f) => {
    const route = f.rute[0];

    return {
      value: f.idZbor,
      label:
        route.aeroportPlecare.denumire +
        " -> " +
        route.aeroportDestinatie.denumire,
    };
  });

  let airplaneSeatsOptions = [];

  if (airplane) {
    const seats = airplanes.data.find((a) => a.id === airplane.value).seats;
    if (seats) {
      airplaneSeatsOptions = seats.map((s) => ({
        value: s.idLoc,
        label: s.nrLoc,
      }));
    }
  }

  return (
    <div className="CreateReservationPage w-50 mx-5 my-5">
      <Link className="btn btn-secondary mb-5" to="/reservations">
        Inapoi
      </Link>

      <Form>
        <div className="my-2">
          <div className="my-1">Zbor:</div>
          <Select
            options={flightsOptions}
            placeholder="Alege zbor"
            onChange={(sel) => {
              setFlight(sel);
            }}
            name="flight"
          />
        </div>

        <div className="my-2">
          <div className="my-1">Avion:</div>
          <Select
            options={airplaneOptions}
            placeholder="Alege avion"
            onChange={(sel) => {
              fetchAirplaneSeats(sel.value).then(() => {
                setAirplane(sel);
              });
            }}
            name="airplane"
          />
        </div>

        <Form.Group controlId="formPret">
          <Form.Label>Pret:</Form.Label>
          <Form.Control
            onChange={({target: {value}}) => setPret(value)}
            type="number"
            placeholder="Pret..."
          />
        </Form.Group>

        <Form.Group controlId="formDiscount">
          <Form.Label>Discount:</Form.Label>
          <Form.Control
            onChange={({target: {value}}) => setDiscount(value)}
            type="number"
            placeholder="Discount..."
          />
        </Form.Group>

        <div className="my-2">
          <div className="my-1">Loc:</div>
          <Select
            options={airplaneSeatsOptions}
            placeholder="Alege loc"
            onChange={(sel) => {
              setLoc(sel);
            }}
            name="airplane"
          />
        </div>

        <Form.Group controlId="formStatus">
          <Form.Label>Status:</Form.Label>
          <Form.Control
            onChange={({target: {value}}) => setStatus(value)}
            type="text"
            placeholder="Status..."
          />
        </Form.Group>

        <Button
          className="my-3"
          onClick={() => {
            setShowNewClientForm(!showNewClientForm);
          }}
          variant="secondary"
          type="button"
        >
          {showNewClientForm ? "Alege client existent" : "Creaza client now"}
        </Button>

        {!showNewClientForm && (
          <div className="my-2">
            <div className="my-1">Client:</div>
            <Select
              options={clientsOptions}
              placeholder="Alege client"
              onChange={(sel) => {
                setClient(sel);
              }}
              name="client"
            />
          </div>
        )}

        {showNewClientForm && (
          <div>
            <Form.Group controlId="formNume">
              <Form.Label>Nume:</Form.Label>
              <Form.Control
                onChange={({target: {value}}) =>
                  setClient({...client, nume: value})
                }
                type="text"
                placeholder="Nume..."
              />
            </Form.Group>

            <Form.Group controlId="formPrenume">
              <Form.Label>Prenume:</Form.Label>
              <Form.Control
                onChange={({target: {value}}) =>
                  setClient({...client, prenume: value})
                }
                type="text"
                placeholder="Prenume..."
              />
            </Form.Group>

            <Form.Group controlId="formCnp">
              <Form.Label>Status:</Form.Label>
              <Form.Control
                onChange={({target: {value}}) =>
                  setClient({...client, cnp: value})
                }
                type="text"
                placeholder="CNP..."
              />
            </Form.Group>

            <Form.Group controlId="formActIdentitate">
              <Form.Label>Act Identitate:</Form.Label>
              <Form.Control
                onChange={({target: {value}}) =>
                  setClient({...client, actIdentitate: value})
                }
                type="text"
                placeholder="Act Identitate..."
              />
            </Form.Group>

            <Form.Group controlId="formEmail">
              <Form.Label>Email:</Form.Label>
              <Form.Control
                onChange={({target: {value}}) =>
                  setClient({...client, email: value})
                }
                type="email"
                placeholder="Email..."
              />
            </Form.Group>

            <Form.Group controlId="formTelefon">
              <Form.Label>Telefon:</Form.Label>
              <Form.Control
                onChange={({target: {value}}) =>
                  setClient({...client, telefon: value})
                }
                type="email"
                placeholder="Email..."
              />
            </Form.Group>
          </div>
        )}
        <Button
          onClick={() => {
            createReservation({
              idZbor: flight.value,
              idAvion: airplane.value,
              client: showNewClientForm ? client : {cnp: client.value},
              idLoc: loc.value,
              pret,
              discount,
              status,
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

export default CreateReservationPage;
