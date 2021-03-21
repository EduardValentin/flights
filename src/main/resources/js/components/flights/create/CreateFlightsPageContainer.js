import { path } from "ramda";
import React, { useContext } from "react";
import { fetchAirplanes } from "../../../api/airplanesClient";
import { createFlight } from "../../../api/flightsClient";
import { fetchAllPilots } from "../../../api/pilotsClient";
import { fetchAllRoutes } from "../../../api/routesClient";
import { AppContext } from "../../../app";
import CreateFlightsPage from "./CreateFlightsPage";

const CreateFlightsPageContainer = () => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <CreateFlightsPage
      airplanes={path(["airplanes"], state)}
      pilots={path(["pilots"], state)}
      routes={path(["routes"], state)}
      actions={{
        fetchAirplanes: fetchAirplanes(dispatch),
        fetchPilots: fetchAllPilots(dispatch),
        fetchRoutes: fetchAllRoutes(dispatch),
        createFlight: createFlight(dispatch),
      }}
    />
  );
};

export default CreateFlightsPageContainer;
