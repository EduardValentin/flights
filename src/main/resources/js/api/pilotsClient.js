import { setIn } from "../reducer";
import constants from "./constants";
import { doGet } from "./utils";

const PILOTS_BASE_URL = `${constants.API_URL}/api/v1/pilots`;

const fetchAll = () => doGet(PILOTS_BASE_URL);

export const fetchAllPilots = (dispatch) => () => {
  dispatch(setIn(["pilots", "loading"], true));
  return fetchAll()
    .then(({ data }) => {
      dispatch(setIn(["pilots", "data"], data));
      dispatch(setIn(["pilots", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["pilots", "loading"], false));
      dispatch(setIn(["pilots", "error"], error));
    });
};
