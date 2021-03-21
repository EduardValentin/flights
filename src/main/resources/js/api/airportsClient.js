import { setIn } from "../reducer";
import constants from "./constants";
import { doGet, doPost } from "./utils";

const AIRPORTS_BASE_URL = `${constants.API_URL}/api/v1/airports`;

const fetchAll = () => doGet(AIRPORTS_BASE_URL);

const post = (data) => doPost(AIRPORTS_BASE_URL, {}, data);

export const fetchAirports = (dispatch) => () => {
  dispatch(setIn(["airports", "loading"], true));
  return fetchAll()
    .then((response) => {
      dispatch(setIn(["airports", "data"], response.data));
      dispatch(setIn(["airports", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["airports", "loading"], false));
      dispatch(setIn(["airports", "error"], error));
    });
};

export const createAirport = (dispatch) => (airplane) => {
  dispatch(setIn(["airports", "loading"], true));
  return post(airplane)
    .then(({ data }) => {
      dispatch(setIn(["airports", "data", data.idAeroport], data));
      dispatch(setIn(["airports", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["airports", "loading"], false));
      dispatch(setIn(["airports", "error"], error));
    });
};
