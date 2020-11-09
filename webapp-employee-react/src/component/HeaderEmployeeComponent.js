import React, {Component} from 'react';
import * as Icon from 'react-feather';

export default class HeaderEmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {};
    }

    render() {
        return (
            <header>
                <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                    <h2 className="navbar-brand">employee data management</h2>
                    <form className="form-inline my-2 my-lg-0">
                        <input className="form-control mr-sm-2" type="text" placeholder="search" aria-label="search"/>
                        <button className="btn btn-secondary my-2 my-sm-0" type="submit">
                            <Icon.Search/> search
                        </button>
                    </form>
                </nav>
            </header>
        )
    }
}
