import axios from './axios';

const EShopService = {
    fetchPlaces: () => {
        return axios.get("/places");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchCategories: () => {
        return axios.get("/places/categories");
    },
    fetchHosts: () => {
        return axios.get("/hosts");
    },
    deletePlace: (id) => {
        return axios.post(`/places/delete-place/${id}`);
    },
    addCountry: (name, continent) => {
        return axios.post("/add-country", {
            "name": name,
            "continent": continent,

        });
    },
    addHost: (name,surname, countryId) => {
        return axios.post("/add-host", {
            "name": name,
            "surname":surname,
            "countryId": countryId
        });
    },
    addPlace: (category,hostId, numRooms) => {
        return axios.post("/places/add-place", {
            "category": category,
            "hostId":hostId,
            "numRooms": numRooms,

        });
    },
    editPlace: (id,category,hostId, numRooms) => {
        return axios.post(`/places/edit-place/${id}`, {
            "category": category,
            "hostId":hostId,
            "numRooms": numRooms,
        });
    },
    getPlace: (id) => {
        return axios.get(`/places/${id}`);
    },
    markPlace: (id) => {
        return axios.post(`/places/mark-place/${id}`);
    },
}

export default EShopService;
