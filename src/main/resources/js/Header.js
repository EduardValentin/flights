import React from 'react';
import {Link} from "react-router-dom";

export default () => {
    const allLinks = links;

    return (
        <nav className="Header navbar navbar-expand navbar-dark bg-dark">
            <ul className="navbar-nav">
                {allLinks.map(link => (
                    <li className="Header__item nav-item">
                        <Link className="nav-link" to={link.path}>{link.name}</Link>
                    </li>
                ))}
            </ul>
        </nav>
    );
}

const createLink = (name, path) => {
    return {
        name,
        path
    };
};


const links = [
    createLink("Avioane", "/airplanes"),
    createLink("Aeroporturi", "/airports"),
    createLink("Rute", "/routes"),
    createLink("Zboruri", "/flights"),
    createLink("Rezervari", "/reservations"),
];
