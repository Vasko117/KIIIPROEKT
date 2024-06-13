import React, {useEffect, useState} from 'react';
import {Link} from "react-router-dom";
import EShopService from "./repo";

function Countries(props) {


    const [countries, setCountries] = useState([]);
    useEffect(() => {
        loadCountries()
    }, []);
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Name</th>
                            <th scope={"col"}>Continent</th>
                        </tr>
                        </thead>
                        <tbody>
                        {countries.map((term) =>
                             (
                                <tr key={term.id}>
                                    <td>{term.name}</td>
                                    <td>{term.continent}</td>
                                </tr>
                            )
                        )}
                        </tbody>
                    </table>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/countries/add-country"}>Add new country</Link>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    );
    function loadCountries() {
        EShopService.fetchCountries()
            .then((data) => {
                setCountries(
                    data.data
                )
            });
    }
}

export default Countries;