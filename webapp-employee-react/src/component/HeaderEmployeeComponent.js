import React, {Component} from 'react';

export default class HeaderEmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {};
    }

    render() {
        return (
            <div>
                <header>
                    <nav class="navbar navbar-expand-lg navbar-light bg-dark">
                        <h2 class="navbar-brand">employee data management</h2>
                    </nav>
                </header>
            </div>
        )
    }
}
