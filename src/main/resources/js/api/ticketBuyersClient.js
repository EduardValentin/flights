import { setIn } from "../reducer";
import constants from "./constants";
import { doGet } from "./utils";

const CLIENTS_BASE_URL = `${constants.API_URL}/api/v1/clients`;

const fetchAll = () => doGet(CLIENTS_BASE_URL);

export const fetchClients = (dispatch) => () => {
  dispatch(setIn(["clients", "loading"], true));
  fetchAll()
    .then((response) => {
      dispatch(setIn(["clients", "data"], response.data));
      dispatch(setIn(["clients", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["clients", "loading"], false));
      dispatch(setIn(["clients", "error"], error));
    });
};