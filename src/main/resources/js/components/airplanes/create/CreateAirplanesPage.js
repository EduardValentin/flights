import { Form, Button } from "react-bootstrap";
import React, { useEffect, useState } from "react";
import Select from "react-select";
import { Redirect } from "react-router";
import { Link } from "react-router-dom";

const CreateAirplanesPage = ({
  actions: { fetchPlaneBrands, createAirplane },
  airplanesLoading,
  planeBrands,
}) => {
  const [brand, setBrand] = useState(null);
  const [weight, setWeight] = useState(null);
  const [availableSpots, setAvailableSpots] = useState(null);
  const [shouldRedirect, setShouldRedirect] = useState(false);

  useEffect(() => {
    fetchPlaneBrands();
  }, []);

  if (!planeBrands || planeBrands.loading || airplanesLoading) {
    return <div>Loading...</div>;
  }

  const planeBrandsData = planeBrands.data || [];
  const planeBrandsAsOptions = planeBrandsData.map((brand) => ({
    value: brand.id,
    label: brand.nume,
  }));

  if(shouldRedirect) {
    return <Redirect to="/airplanes" />;
  }

  return (
    <div className="CreateAirplanes__page w-50 mx-5 my-5">
      <Link className="btn btn-secondary mb-5" to="/airplanes">Inapoi</Link>

      <Form>
        <div className="my-2">
          <div className="my-1">Marca: </div>
          <Select
            defaultValue={planeBrandsAsOptions[0]}
            options={planeBrandsAsOptions}
            placeholder="Alege marca"
            onChange={(brand) => {
              setBrand(brand);
            }}
            name="brands"
          />
        </div>

        <Form.Group controlId="formLocuriMaxime">
          <Form.Label>Locuri maxime:</Form.Label>
          <Form.Control
            onChange={({ target: { value } }) => setAvailableSpots(value)}
            type="text"
            placeholder="Locuri maxime..."
          />
        </Form.Group>

        <Form.Group controlId="formGreutateTone">
          <Form.Label>Greutate tone:</Form.Label>
          <Form.Control
            onChange={({ target: { value } }) => setWeight(value)}
            type="text"
            placeholder="Greutate tone..."
          />
        </Form.Group>

        <Button
          onClick={() => {
            const selectedBrand = brand || planeBrandsAsOptions[0];

            createAirplane({
              locuriMaxime: availableSpots,
              greutateTone: weight,
              marca:
                {
                  id: selectedBrand.value,
                  nume: selectedBrand.label,
                },
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

export default CreateAirplanesPage;
