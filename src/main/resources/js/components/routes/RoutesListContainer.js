import { path } from "ramda";
import React, { useContext, useCallback } from "react";
import { fetchAllRoutes } from "../../api/routesClient";
import { AppContext } from "../../app";
import RoutesList from "./RoutesList";

const RoutesListContainer = () => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <RoutesList
      actions={{
        fetchAllRoutes: fetchAllRoutes(dispatch),
      }}
      routes={path(["routes"], state)}
    />
  );
};

export default RoutesListContainer;
