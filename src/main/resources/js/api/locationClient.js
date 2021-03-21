import { setIn } from "../reducer";
import constants from "./constants";
import { doGet, doPost } from "./utils";

const LOCATION_BASE_URL = `${constants.API_URL}/api/v1/locations`;

const fetchAll = () => doGet(LOCATION_BASE_URL);

const post = (data) => doPost(LOCATION_BASE_URL, {}, data);

export const fetchLocations = (dispatch) => () => {
  dispatch(setIn(["locations", "loading"], true));
  return fetchAll()
    .then(({ data }) => {
      dispatch(setIn(["locations", "data"], data));
      dispatch(setIn(["locations", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["locations", "loading"], false));
      dispatch(setIn(["locations", "error"], error));
    });
};
