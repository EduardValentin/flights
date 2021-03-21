import { path } from "ramda";
import React, { useContext } from "react";
import { fetchReservations } from "../../api/reservationsClient";
import { AppContext } from "../../app";
import ReservationsPage from "./ReservationsPage";

const ReservationsPageContainer = () => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <ReservationsPage
      actions={{
        fetchReservations: fetchReservations(dispatch),
      }}
      reservations={path(["reservations"], state)}
    />
  );
};

export default ReservationsPageContainer;
