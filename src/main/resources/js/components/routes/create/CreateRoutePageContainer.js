import { path } from "ramda";
import React, { useContext } from "react";
import { fetchAirports } from "../../../api/airportsClient";
import { createRoute } from "../../../api/routesClient";
import { AppContext } from "../../../app";
import CreateRoutePage from "./CreateRoutePage";

const CreateRoutePageContainer = (props) => {
  const { dispatch, state } = useContext(AppContext);
  
  return (
    <CreateRoutePage
      actions={{
        fetchAirports: fetchAirports(dispatch),
        createRoute: createRoute(dispatch),
      }}
      airports={path(["airports"], state)}
    />
  );
};

export default CreateRoutePageContainer;
