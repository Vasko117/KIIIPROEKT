import React from 'react';
import {Link} from "react-router-dom";

function PlacesTerm(props) {
    return (
        <tr>
            <td>{props.term.category}</td>
            <td>{props.term.host.name}</td>
            <td>{props.term.numRooms}</td>
            <Link  className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.term.id)} >
                Delete
            </Link>
            <Link className={"btn btn-info ml-2"}
                  onClick={() => props.onEdit(props.term.id)}
                  to={`/places/edit-place/${props.term.id}`}>
                Edit
            </Link>
            <Link  className={"btn btn-block btn-dark"}
                   onClick={() => props.onMark(props.term.id)} >
                Rent
            </Link>
        </tr>
    );
}

export default PlacesTerm;