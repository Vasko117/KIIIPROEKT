import React, {useEffect, useState} from 'react';
import EShopService from "./repo";
import {useNavigate} from "react-router-dom";

function Categories(props) {
    const [categories, setCategories] = useState([]);
    useEffect(() => {
        loadCategories()
    }, []);

    return (
        <table className={"table table-striped"}>
            <thead>
            <tr>
                <th scope={"col"}>Category</th>

            </tr>
            </thead>
            <tbody>
            {categories.map((term) =>
                <tr ><td>{term}</td></tr>
            )}
            </tbody>
        </table>
    );
    function loadCategories() {
        EShopService.fetchCategories()
            .then((data) => {
                setCategories(
                    data.data
                )
            });
    }
}

export default Categories;