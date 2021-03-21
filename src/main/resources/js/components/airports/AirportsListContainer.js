import React from "react";
import { useContext } from "react";
import { AppContext } from "../../app";
import { path } from "ramda";
import AirportsList from "./AirportsList";
import { fetchAirports } from "../../api/airportsClient";

const AirportsListContainer = (props) => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <AirportsList
      actions={{
        fetchAirports: fetchAirports(dispatch),
      }}
      airports={path(["airports"], state)}
    />
  );
};

export default AirportsListContainer;
