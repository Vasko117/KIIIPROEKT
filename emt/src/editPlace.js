import React, {useEffect} from 'react';
import {useState} from 'react';
import {useNavigate} from 'react-router-dom';
import EShopService from "./repo";
function EditPlace(props) {
    const history = useNavigate();
    const [hosts, setHosts] = useState([]);
    const [categories, setCategories] = useState([]);

    useEffect(() => {
        loadHosts()
        loadCategories()
    }, [])
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
        const category =formData.category !== "" ? formData.category : props.place.category;
        const hostId = formData.hostId !== "" ? formData.hostId : props.place.host.id;
        const numRooms = formData.numRooms !== "" ? formData.numRooms : props.place.numRooms;

        props.onEditPlace(props.place.id,category, hostId, numRooms);
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
                                {
                                    if(props.place.category !== undefined &&
                                        props.place.category === term)
                                        return <option selected={props.place.category} value={term}>{term}</option>
                                    else return <option value={term}>{term}</option>}
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Host</label>
                        <select name="hostId" className="form-control" onChange={handleChange}>
                            {hosts.map((term) =>{
                                if(props.place.host !== undefined &&
                                props.place.host.id === term.id)
                                return <option selected={props.place.host.id} value={term.id}>{term.id}</option>
                        else return <option value={term.id}>{term.id}</option>}

                        )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="numRooms">NumRooms</label>
                        <input type="number"
                               className="form-control"
                               id="numRooms"
                               name="numRooms"
                               placeholder={props.place.numRooms}
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )

    function loadHosts(){
        EShopService.fetchHosts()
            .then((data) => {
                setHosts(
                    data.data
                )
            });
    }
    function loadCategories() {
        EShopService.fetchCategories()
            .then((data) => {
                setCategories(
                    data.data
                )
            });
    }
}

export default EditPlace;