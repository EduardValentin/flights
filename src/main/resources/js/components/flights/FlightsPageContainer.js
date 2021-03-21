import { path } from "ramda";
import React, { useContext } from "react";
import { fetchFlights } from "../../api/flightsClient";
import { AppContext } from "../../app";
import FlightsPage from "./FlightsPage";

const FlightsPageContainer = () => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <FlightsPage
      flights={path(["flights"], state)}
      actions={{
        fetchFlights: fetchFlights(dispatch),
      }}
    />
  );
};

export default FlightsPageContainer;
