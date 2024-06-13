import React, {useEffect, useState} from 'react';
import EShopService from "./repo";
import {Link} from "react-router-dom";

function Hosts(props) {

    const [hosts, setHosts] = useState([]);
    useEffect(() => {
        loadHosts()
    }, [])

    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Surname</th>
                            <th scope={"col"}>Country</th>
                        </tr>
                        </thead>
                        <tbody>
                        {hosts.map((term) => (
                                <tr key={term.id}>
                                    <td>{term.name}</td>
                                    <td>{term.surrname}</td>
                                    <td>{term.country.name}</td>
                                </tr>
                            )
                        )}
                        </tbody>
                    </table>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/add-host"}>Add new host</Link>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    );
    function loadHosts(){
        EShopService.fetchHosts()
            .then((data) => {
                setHosts(
                    data.data
                )
            });
    }
}

export default Hosts;