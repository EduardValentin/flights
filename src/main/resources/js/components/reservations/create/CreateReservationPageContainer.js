import { path } from "ramda";
import React, { useContext } from "react";
import { fetchAirplanes, fetchAirplaneSeats } from "../../../api/airplanesClient";
import { fetchFlights } from "../../../api/flightsClient";
import { createReservation } from "../../../api/reservationsClient";
import { fetchClients } from "../../../api/ticketBuyersClient";
import { AppContext } from "../../../app";
import CreateReservationPage from "./CreateReservationPage";

const CreateReservationPageContainer = () => {
  const { dispatch, state } = useContext(AppContext);

  return (
    <CreateReservationPage
      clients={path(["clients"], state)}
      airplanes={path(["airplanes"], state)}
      flights={path(["flights"], state)}
      actions={{
        createReservation: createReservation(dispatch),
        fetchClients: fetchClients(dispatch),
        fetchFlights: fetchFlights(dispatch),
        fetchAirplanes: fetchAirplanes(dispatch),
        fetchAirplaneSeats: fetchAirplaneSeats(dispatch, state),
      }}
    />
  );
};

export default CreateReservationPageContainer;
