import React from 'react';
import {useNavigate} from 'react-router-dom';


function AddCountries(props) {

    const history = useNavigate();
    const [formData, updateFormData] = React.useState({
        name: "",
        continent:""
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
        const continent = formData.continent;

        props.onAddCountry(name, continent);
        history("/")
    }

    return(
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Country name</label>
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
                        <label htmlFor="continent">Continent</label>
                        <input type="text"
                               className="form-control"
                               id="price"
                               name="continent"
                               placeholder="continent"
                               required
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    )

}

export default AddCountries;