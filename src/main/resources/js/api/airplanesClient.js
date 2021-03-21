import {setIn} from "../reducer";
import constants from "./constants";
import {doGet, doPost} from "./utils";
import {findIndex, propEq} from "ramda";

const AIRPLANES_BASE_URL = `${constants.API_URL}/api/v1/airplanes`;

const fetchAll = () => doGet(AIRPLANES_BASE_URL);

const post = (data) => doPost(AIRPLANES_BASE_URL, {}, data);

export const fetchAirplanes = (dispatch) => () => {
  dispatch(setIn(["airplanes", "loading"], true));
  return fetchAll()
    .then((response) => {
      dispatch(setIn(["airplanes", "data"], response.data));
      dispatch(setIn(["airplanes", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["airplanes", "loading"], false));
      dispatch(setIn(["airplanes", "error"], error));
    });
};

export const fetchAirplaneSeats = (dispatch, state) => (airplaneId) => {
  const index = findIndex(propEq('id', airplaneId))(state.airplanes.data);

  dispatch(setIn(["airplanes", "data", index, "loading"], true));
  return doGet(AIRPLANES_BASE_URL + "/" + airplaneId + "/seats")
    .then((response) => {
      dispatch(
        setIn(["airplanes", "data", index, "seats"], response.data)
      );
      dispatch(setIn(["airplanes", "data", index, "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["airplanes", "data", index, "loading"], false));
      dispatch(setIn(["airplanes", "data", index, "error"], error));
    });
};

export const createAirplane = (dispatch) => (airplane) => {
  dispatch(setIn(["airplanes", "loading"], true));
  return post(airplane)
    .then(({data}) => {
      dispatch(setIn(["airplanes", "data", data.id], data));
      dispatch(setIn(["airplanes", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["airplanes", "loading"], false));
      dispatch(setIn(["airplanes", "error"], error));
    });
};
