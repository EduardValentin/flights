import { setIn } from "../reducer";
import constants from "./constants";
import { doGet, doPost } from "./utils";

const ROUTES_BASE_URL = `${constants.API_URL}/api/v1/routes`;

const fetchAll = () => doGet(ROUTES_BASE_URL);

const post = (data) => doPost(ROUTES_BASE_URL, {}, data);

export const fetchAllRoutes = (dispatch) => () => {
  dispatch(setIn(["routes", "loading"], true));
  return fetchAll()
    .then(({ data }) => {
      dispatch(setIn(["routes", "data"], data));
      dispatch(setIn(["routes", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["routes", "loading"], false));
      dispatch(setIn(["routes", "error"], error));
    });
};

export const createRoute = (dispatch) => (route) => {
  dispatch(setIn(["routes", "loading"], true));
  return post(route)
    .then(({ data }) => {
      dispatch(setIn(["routes", "data", data.idRuta], data));
      dispatch(setIn(["routes", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["routes", "loading"], false));
      dispatch(setIn(["routes", "error"], error));
    });
};
