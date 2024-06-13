import React from 'react';
import {Link} from 'react-router-dom';


function Header(props) {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark navbar-fixed bg-dark">

                <div className="collapse navbar-collapse" id="navbarCollapse">
                    <ul className="navbar-nav mr-auto">
                        <li className="nav-item active">
                            <Link className="nav-link" to={"/places"}>Places</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className="nav-link" to={"/"}>Countries</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className={"nav-link"} to={"/hosts"}>Hosts</Link>
                        </li>
                        <li className="nav-item active">
                            <Link className={"nav-link"} to={"/categories"}>Categories</Link>
                        </li>
                    </ul>

                </div>
            </nav>
        </header>

    );
}

export default Header;