import React, {Component} from 'react';

export default class HeaderEmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {};
    }

    render() {
        return (
            <header>
                <nav className="navbar navbar-expand-lg navbar-light bg-dark">
                    <h2 className="navbar-brand">employee data management</h2>
                </nav>
            </header>
        )
    }
}
