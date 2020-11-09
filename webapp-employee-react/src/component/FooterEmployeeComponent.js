import React, {Component} from 'react';

export default class FooterEmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            
        };
    }

    render() {
        return (
            <footer>
                <nav className="footer mt-auto py-3 bg-dark fixed-bottom">
                    <div className="container">
                        <span className="text-muted">employee data management</span>
                    </div>
                </nav>
            </footer>
        )
    }
}
