import { assocPath, dissocPath, pathOr } from "ramda";

export const initialState = {};

export const reducer = (state, action) => {
  switch (action.type) {
    case "SET_IN":
      return assocPath(action.path, action.value, state);
    case "GET_IN":
      return pathOr(action.default, action.path, state);
    case "REMOVE_IN":
      return dissocPath(action.path, state);
    default:
      return state;
  }
};

export const setIn = (path, value) => ({
  type: "SET_IN",
  path,
  value,
});

export const getIn = (path) => ({
  type: "GET_IN",
  path,
  value,
});

export const removeIn = (path) => ({
  type: "REMOVE_IN",
  path,
});
