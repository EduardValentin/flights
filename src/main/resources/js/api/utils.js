import axios from "axios";

export const request = (url, method, params, data, headers) =>
  axios.request({
    data,
    url,
    params,
    headers,
    method,
  });

export const doGet = (url, params, data, headers) =>
  request(url, "GET", params, data, headers);

export const doPost = (url, params, data, headers) =>
  request(url, "POST", params, data, headers);

export const doPut = (url, params, data, headers) =>
  request(url, "PUT", params, data, headers);

export const doPatch = (url, params, data, headers) =>
  request(url, "PATCH", params, data, headers);

export const doDelete = (url, params, data, headers) =>
  request(url, "DELETE", params, data, headers);
