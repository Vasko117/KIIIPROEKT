import React, {useEffect, useState} from 'react';
import {useNavigate} from 'react-router-dom';
import EShopService from "./repo";


function AddHost(props) {
    useEffect(() => {
        loadCountries()
    }, []);
    const [countries, setCountries] = useState([]);
    const history = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        surname:"",
        countryId:""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name;
        const surname = formData.surname;
        const countryId = formData.countryId;
        props.onAddHost(name, surname,countryId);
        history("/hosts")
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Host name</label>
                        <input type="text"
                               className="form-control"
                               id="name"
                               name="name"
                               required
                               placeholder="Enter product name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="surname">Host surname</label>
                        <input type="text"
                               className="form-control"
                               id="surname"
                               name="surname"
                               required
                               placeholder="Enter product name"
                               onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>CountryId</label>
                        <select name="countryId" className="form-control" onChange={handleChange}>
                            {countries.map((term) =>
                                <option value={term.id}>{term.id}</option>
                            )}
                        </select>
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
    function loadCountries() {
        EShopService.fetchCountries()
            .then((data) => {
                setCountries(
                    data.data
                )
            });
    }
}

export default AddHost;