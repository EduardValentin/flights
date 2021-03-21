import React from "react";
import AirplanesPage from "./AirplanesPage";
import { useContext } from "react";
import { AppContext } from "../../app";
import { fetchAirplanes } from "../../api/airplanesClient";
import { path } from "ramda";

const AirplanesContainer = (props) => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <AirplanesPage
      actions={{
        fetchAirplanes: fetchAirplanes(dispatch),
      }}
      airplanes={path(["airplanes"], state)}
    />
  );
};

export default AirplanesContainer;
