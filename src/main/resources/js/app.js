import React from "react";
import ReactDOM from "react-dom";
import { HashRouter, Route, Switch } from "react-router-dom";
import Header from "./Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { useReducer } from "react";
import { initialState, reducer } from "./reducer";
import AirplanesContainer from "./components/airplanes/AirplanesContainer";
import AirportsListContainer from "./components/airports/AirportsListContainer";
import CreateAirportPageContainer from "./components/airports/create/CreateAirportPageContainer";
import CreateAirplanesContainer from "./components/airplanes/create/CreateAirplanesContainer";
import RoutesListContainer from "./components/routes/RoutesListContainer";
import CreateRoutePageContainer from "./components/routes/create/CreateRoutePageContainer";
import FlightsPageContainer from "./components/flights/FlightsPageContainer";
import CreateFlightsPageContainer from "./components/flights/create/CreateFlightsPageContainer";
import ReservationsPageContainer from "./components/reservations/ReservationsPageContainer";
import CreateReservationPageContainer from "./components/reservations/create/CreateReservationPageContainer";

export const AppContext = React.createContext({});

const App = (props) => {
  const [state, dispatch] = useReducer(reducer, initialState, () => {});
  return (
    <AppContext.Provider value={{ state, dispatch }}>
      <HashRouter>
        <div className="App">
          <Header />
          <Switch>
            <Route exact path="/airplanes" component={AirplanesContainer} />
            <Route
              exact
              path="/airplanes/create"
              component={CreateAirplanesContainer}
            />

            <Route exact path="/airports" component={AirportsListContainer} />
            <Route
              exact
              path="/airports/create"
              component={CreateAirportPageContainer}
            />

            <Route exact path="/routes" component={RoutesListContainer} />
            <Route
              exact
              path="/routes/create"
              component={CreateRoutePageContainer}
            />

            <Route exact path="/flights" component={FlightsPageContainer} />
            <Route
              exact
              path="/flights/create"
              component={CreateFlightsPageContainer}
            />

            <Route
              exact
              path="/reservations"
              component={ReservationsPageContainer}
            />
            <Route
              exact
              path="/reservations/create"
              component={CreateReservationPageContainer}
            />
          </Switch>
        </div>
      </HashRouter>
    </AppContext.Provider>
  );
};

ReactDOM.render(<App />, document.getElementById("react"));
