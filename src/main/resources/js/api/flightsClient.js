import { setIn } from "../reducer";
import constants from "./constants";
import { doGet, doPost } from "./utils";

const FLIGHTS_BASE_URL = `${constants.API_URL}/api/v1/flights`;

const fetchAll = () => doGet(FLIGHTS_BASE_URL);

const post = (data) => doPost(FLIGHTS_BASE_URL, {}, data);

export const fetchFlights = (dispatch) => () => {
  dispatch(setIn(["flights", "loading"], true));
  fetchAll()
    .then((response) => {
      dispatch(setIn(["flights", "data"], response.data));
      dispatch(setIn(["flights", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["flights", "loading"], false));
      dispatch(setIn(["flights", "error"], error));
    });
};

export const createFlight = (dispatch) => (flight) => {
  dispatch(setIn(["flights", "loading"], true));
  return post(flight)
    .then(({ data }) => {
      dispatch(setIn(["flights", "data", data.idZbor], data));
      dispatch(setIn(["flights", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["flights", "loading"], false));
      dispatch(setIn(["flights", "error"], error));
    });
};
