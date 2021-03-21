import { doGet } from "./utils";
import constants from "./constants";
import { setIn } from "../reducer";

const AIRPLANES_BASE_URL = `${constants.API_URL}/api/v1/plane-brands`;

const fetchAll = () => doGet(AIRPLANES_BASE_URL);

export const fetchPlaneBrands = (dispatch) => () => {
  dispatch(setIn(["planeBrands", "loading"], true));
  return fetchAll()
    .then(({ data }) => {
      dispatch(setIn(["planeBrands", "data"], data));
      dispatch(setIn(["planeBrands", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["planeBrands", "loading"], false));
      dispatch(setIn(["planeBrands", "error"], error));
    });
};
