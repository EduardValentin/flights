import { setIn } from "../reducer";
import constants from "./constants";
import { doGet, doPost } from "./utils";

const RESERVATIONS_BASE_URL = `${constants.API_URL}/api/v1/reservations`;

const fetchAll = () => doGet(RESERVATIONS_BASE_URL);

const post = (data) => doPost(RESERVATIONS_BASE_URL, {}, data);

export const fetchReservations = (dispatch) => () => {
  dispatch(setIn(["reservations", "loading"], true));
  fetchAll()
    .then((response) => {
      dispatch(setIn(["reservations", "data"], response.data));
      dispatch(setIn(["reservations", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["reservations", "loading"], false));
      dispatch(setIn(["reservations", "error"], error));
    });
};

export const createReservation = (dispatch) => (reservation) => {
  dispatch(setIn(["reservations", "loading"], true));
  return post(reservation)
    .then(({ data }) => {
      dispatch(setIn(["reservations", "data", data.idRezervare], data));
      dispatch(setIn(["reservations", "loading"], false));
    })
    .catch((error) => {
      dispatch(setIn(["reservations", "loading"], false));
      dispatch(setIn(["reservations", "error"], error));
    });
};
