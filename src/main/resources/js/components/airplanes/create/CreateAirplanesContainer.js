import React from "react";
import { useContext } from "react";
import { AppContext } from "../../../app";
import { createAirplane } from "../../../api/airplanesClient";
import { path } from "ramda";
import CreateAirplanesPage from "./CreateAirplanesPage";
import { fetchPlaneBrands } from "../../../api/planeBrandsClient";

const CreateAirplanesContainer = (props) => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <CreateAirplanesPage
      actions={{
        fetchPlaneBrands: fetchPlaneBrands(dispatch),
        createAirplane: createAirplane(dispatch),
      }}
      planeBrands={path(["planeBrands"], state)}
      airplanesLoading={path(["airplanes", "loading"], state)}
    />
  );
};

export default CreateAirplanesContainer;
