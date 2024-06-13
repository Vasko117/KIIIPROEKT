import React, {useEffect, useState} from 'react';
import {useNavigate} from 'react-router-dom';
import EShopService from "./repo";
function AddPlace(props) {
    useEffect(() => {
        loadCategories()
        loadHosts()
    }, []);
    const history = useNavigate();
    const [categories, setCategories] = useState([]);
    const [hosts, setHosts] = useState([]);
    const [formData, updateFormData] = useState({

        category: "",
        hostId: "",
        numRooms:""
    })

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim()
        })
    }

    const onFormSubmit = (e) => {
        e.preventDefault();
        const category = formData.category;
        const hostId = formData.hostId;
        const numRooms = formData.numRooms;

        props.onAddPlace(category, hostId, numRooms);
        history("/places");
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label>Host</label>
                        <select name="category" className="form-control" onChange={handleChange}>
                            {categories.map((term) =>
                                <option value={term}>{term}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Host</label>
                        <select name="hostId" className="form-control" onChange={handleChange}>
                            {hosts.map((term) =>
                                <option value={term.id}>{term.id}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="numRooms">Quantity</label>
                        <input type="number"
                               className="form-control"
                               id="numRooms"
                               name="numRooms"
                               placeholder="numRooms"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )
    function loadCategories() {
        EShopService.fetchCategories()
            .then((data) => {
                setCategories(
                    data.data
                )
            });
    }
    function loadHosts(){
        EShopService.fetchHosts()
            .then((data) => {
                setHosts(
                    data.data
                )
            });
    }
}

export default AddPlace;