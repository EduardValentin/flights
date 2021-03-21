import { Form, Button } from "react-bootstrap";
import React, { useEffect, useState } from "react";
import Select from "react-select";
import { Redirect } from "react-router";
import { Link } from "react-router-dom";

const CreateAirportPage = ({
  actions: { fetchLocations, createAirport },
  locations,
}) => {
  const [selectedLocations, setSelectedLocations] = useState(null);
  const [denumire, setDenumire] = useState(null);
  const [shouldRedirect, setShouldRedirect] = useState(false);

  useEffect(() => {
    fetchLocations();
  }, []);

  if (!locations || locations.loading) {
    return <div>Loading...</div>;
  }

  const locationsData = locations.data || [];
  const locationsOptions = locationsData.map((location) => ({
    value: location.idLocatie,
    label: location.tara + ", " + location.oras + ", " + location.adresa,
  }));

  if (shouldRedirect) {
    return <Redirect to="/airports" />;
  }

  return (
    <div className="CreateAirports__page w-50 mx-5 my-5">
      <Link className="btn btn-secondary mb-5" to="/airports">
        Inapoi
      </Link>

      <Form>
        <div className="my-2">
          <div className="my-1">Locatie: </div>
          <Select
            defaultValue={locationsOptions[0]}
            options={locationsOptions}
            placeholder="Alege locatie"
            onChange={(locatie) => {
              setSelectedLocations(locatie);
            }}
            name="locations"
          />
        </div>

        <Form.Group controlId="formDenumire">
          <Form.Label>Denumire:</Form.Label>
          <Form.Control
            onChange={({ target: { value } }) => setDenumire(value)}
            type="text"
            placeholder="Denumire..."
          />
        </Form.Group>

        <Button
          onClick={() => {
            const location = selectedLocations || locationsOptions[0];
            createAirport({
              denumire: denumire,
              idLocatie: location.value,
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

export default CreateAirportPage;
