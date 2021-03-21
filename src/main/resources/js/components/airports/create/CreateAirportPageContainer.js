import React from "react";
import { useContext } from "react";
import { AppContext } from "../../../app";
import { path } from "ramda";
import { createAirport } from "../../../api/airportsClient";
import { fetchLocations } from "../../../api/locationClient";
import CreateAirportPage from "./CreateAirportPage";

const CreateAirportPageContainer = () => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <CreateAirportPage
      actions={{
        fetchLocations: fetchLocations(dispatch),
        createAirport: createAirport(dispatch),
      }}
      locations={path(["locations"], state)}
    />
  );
};

export default CreateAirportPageContainer;
