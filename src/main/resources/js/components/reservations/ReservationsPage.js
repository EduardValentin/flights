import React, {useEffect} from "react";
import {Link} from "react-router-dom";

const formatDate = (dateArray) => `${dateArray[0]}-${dateArray[1]}-${dateArray[2]} ${dateArray[3]}:${dateArray[4] == 0 ? '00' : dateArray[4]}`;

const ReservationsPage = ({reservations, actions: {fetchReservations}}) => {
    useEffect(() => {
        fetchReservations();
    }, []);

    if (!reservations || reservations.loading) {
        return "Loading...";
    }
    const recordsExist = reservations.data && reservations.data.length > 0;
    return (
        <div className="ReservationsPage p-5">
            <Link className="btn btn-primary mb-5" to="/reservations/create">
                Rezervare noua
            </Link>

            <div className="list-group">
                {recordsExist && reservations.data.map(
                    ({
                         idRezervare,
                         client: {nume, prenume, cnp, email, telefon, actIdentitate},
                         avion: {
                             marca: {nume: numeMarca},
                         },
                         zbor: {dataPlecare, dataSosire, rute},
                         loc: {nrLoc},
                         pret,
                         discount,
                         status,
                     }) => {
                        const ruta = rute[0];
                        const aeroportPlecare = ruta.aeroportPlecare;
                        const aeroportDestinatie = ruta.aeroportDestinatie;

                        return (
                            <div className="list-group-item" key={idRezervare}>
                                <div>
                                    <span className="mr-1 font-weight-bold">ID:</span>
                                    <span>{idRezervare}</span>
                                </div>

                                <div>
                                    <span className="mr-1 font-weight-bold">Data plecare:</span>
                                    <span>{formatDate(dataPlecare)}</span>
                                </div>

                                <div>
                                    <span className="mr-1 font-weight-bold">Data sosire:</span>
                                    <span>{formatDate(dataSosire)}</span>
                                </div>

                                <div>
                  <span className="mr-1 font-weight-bold">
                    Aeroport plecare:
                  </span>
                                    <span>{`${aeroportPlecare.locatie.tara}, ${aeroportPlecare.locatie.oras}, ${aeroportPlecare.locatie.adresa}`}</span>
                                </div>

                                <div>
                  <span className="mr-1 font-weight-bold">
                    Aeroport sosire:
                  </span>
                                    <span>{`${aeroportDestinatie.locatie.tara}, ${aeroportDestinatie.locatie.oras}, ${aeroportDestinatie.locatie.adresa}`}</span>
                                </div>

                                <div>
                                    <span className="mr-1 font-weight-bold">Avion:</span>
                                    <span>{numeMarca}</span>
                                </div>

                                <div>
                                    <div className="mr-1 font-weight-bold">Client:</div>
                                    <div>
                                        <span>Nume: </span>
                                        <span>{nume}</span>
                                    </div>

                                    <div>
                                        <span>Prenume: </span>
                                        <span>{prenume}</span>
                                    </div>

                                    <div>
                                        <span>Email: </span>
                                        <span>{email}</span>
                                    </div>

                                    <div>
                                        <span>CNP: </span>
                                        <span>{cnp}</span>
                                    </div>

                                    <div>
                                        <span>Act identitate: </span>
                                        <span>{actIdentitate}</span>
                                    </div>

                                    <div>
                                        <span>Telefon: </span>
                                        <span>{telefon}</span>
                                    </div>
                                </div>

                                <div>
                                    <span className="mr-1 font-weight-bold">Loc:</span>
                                    <span>{nrLoc}</span>
                                </div>

                                <div>
                                    <span className="mr-1 font-weight-bold">Pret:</span>
                                    <span>{pret}</span>
                                </div>

                                <div>
                                    <span className="mr-1 font-weight-bold">Discount:</span>
                                    <span>{discount}</span>
                                </div>

                                <div>
                                    <span className="mr-1 font-weight-bold">Status:</span>
                                    <span>{status}</span>
                                </div>
                            </div>
                        );
                    }
                )}
            </div>
        </div>
    );
};

export default ReservationsPage;
