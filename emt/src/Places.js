import React, {useEffect, useState} from 'react';
import EShopService from "./repo";
import {Link} from "react-router-dom";
import ReactPaginate from 'react-paginate'
import PlacesTerm from "./PlacesTerm";


function Places(props) {

    const [places, setPlace] = useState([]);

    const [page, setPage] = useState(0);
    const size=5;
    useEffect(() => {
        loadPlaces()
    }, [places]);
    const offset = size * page;
    const nextPageOffset = offset + size;
    const pageCount = Math.ceil(places.length / size);

    const placesss =getProductsPage(offset, nextPageOffset);
    return (
        <div className={"container mm-4 mt-5"}>
            <div className={"row"}>
                <div className={"table-responsive"}>
                    <table className={"table table-striped"}>
                        <thead>
                        <tr>
                            <th scope={"col"}>Category</th>
                            <th scope={"col"}>Host</th>
                            <th scope={"col"}>NumRooms</th>
                        </tr>
                        </thead>
                        <tbody>
                        {placesss}
                        </tbody>
                    </table>
                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 col-md-12">
                                <Link className={"btn btn-block btn-dark"} to={"/places/add-place"}>Add new place</Link>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
            <ReactPaginate previousLabel={"back"}
                           nextLabel={"next"}
                           breakLabel={<a href="/#">...</a>}
                           breakClassName={"break-me"}
                           pageClassName={"ml-1"}
                           pageCount={pageCount}
                           marginPagesDisplayed={2}
                           pageRangeDisplayed={5}
                           onPageChange={handlePageClick}
                           containerClassName={"pagination m-4 justify-content-center"}
                           activeClassName={"active"}/>

        </div>
    );
    function handlePageClick  (data){
        let selected = data.selected;
        console.log(selected)
        setPage(
            selected
        )
    }

    function getProductsPage (offset, nextPageOffset) {
        console.log(offset, nextPageOffset)
        return places.map((term, index) => {
            return (
                <PlacesTerm term={term} onDelete={props.onDelete} onEdit={props.onEdit} onMark={props.onMark}/>
            );
        }).filter((places, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }

    function loadPlaces(){
        EShopService.fetchPlaces()
            .then((data) => {
                setPlace(
                    data.data
                )
            });
    }
}

export default Places;