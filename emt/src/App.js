import {BrowserRouter as Router, Route, Routes} from 'react-router-dom'
import Header from "./Header";
import Countries from "./Countries";
import Hosts from "./Hosts";
import {useEffect, useState} from "react";
import EShopService from "./repo";
import AddPlace from "./addPlace";
import Places from "./Places";
import EditPlace from "./editPlace";
import AddCountries from "./addCountries";
import AddHost from "./addHosts";
import Categories from "./Categories";


function App() {



  const [place, setPlac] = useState("");
    useEffect(() => {

    }, [place]);

    return (
      <Router>
          <Header/>
          <Routes>
              <Route exact path={"/"} element={
                  <Countries />}/>
              <Route exact path={"/categories"} element={
                  <Categories />}/>
                      <Route exact path={"/hosts"} element={
                          <Hosts/>}/>
                      <Route exact path={"/places/add-place"} element={
                          <AddPlace
                                    onAddPlace={addPlace}/>}/>
                      <Route exact path={"/countries/add-country"} element={
                          <AddCountries
                              onAddCountry={addCountry}/>}/>
              <Route exact path={"/add-host"} element={
                  <AddHost
                      onAddHost={addHost}/>}/>
                      <Route exact path={"/places/edit-place/:id"} element={
                          <EditPlace
                                     onEditPlace={editPlace}
                                     place={place}/>}/>
                      <Route exact path={"/places"} element={
                          <Places
                              onDelete={deletePlace}
                              onEdit={getPlace}
                          onMark={markPlace}/>}/>
          </Routes>

      </Router>

  );


  //

  //
    function markPlace(id){
        EShopService.markPlace(id)
            .then(() => {

            });
    }
    function deletePlace(id){
    EShopService.deletePlace(id)
        .then(() => {

        });
  }
  //
    function addPlace(category, hostId, numRooms){
    EShopService.addPlace(category,hostId, numRooms)
        .then(() => {
        });
  }
    function addCountry(name, continent){
        EShopService.addCountry(name,continent)
            .then(() => {
            });
    }
    function addHost(name,surname, countryId){
        EShopService.addHost(name,surname,countryId)
            .then(() => {

            });
    }
    async function getPlace(id) {
        try {
            const response = await EShopService.getPlace(id);
            setPlac(response.data);
            console.log("vlaga",place)
        } catch (error) {
            console.error("Error fetching place data:", error);
        }
    }
  //
    function editPlace(id, category, hostId, numRooms){
    EShopService.editPlace(id, category, hostId, numRooms)
        .then(() => {

        });
  }

}

export default App;
