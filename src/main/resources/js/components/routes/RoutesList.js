import React, { useEffect } from "react";
import { Link } from "react-router-dom";

const RoutesList = ({ routes, actions: { fetchAllRoutes } }) => {
  useEffect(() => {
    fetchAllRoutes();
  }, []);

  if (!routes || routes.loading) {
    return "Loading...";
  }

  return (
    <div className="RoutesListPage p-5">
      <Link className="btn btn-primary mb-5" to="/routes/create">
        Ruta noua
      </Link>

      <div className="list-group">
        {routes.data.map((route) => (
          <div className="list-group-item" key={route.idRuta}>
            <div>
              <span className="mr-1 font-weight-bold">ID:</span>
              <span>{route.idRuta}</span>
            </div>

            <div>
              <span className="mr-1 font-weight-bold">Plecare:</span>
              <span>{`${route.aeroportPlecare.denumire}, ${route.aeroportPlecare.locatie.tara}`}</span>
            </div>

            <div>
              <span className="mr-1 font-weight-bold">Destinatie:</span>
              <span>{`${route.aeroportDestinatie.denumire}, ${route.aeroportDestinatie.locatie.tara}`}</span>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default RoutesList;
