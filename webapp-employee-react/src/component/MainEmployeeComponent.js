import React, {Component} from 'react';
import * as Icon from 'react-feather';

export default class MainEmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            
        };
    }

    render() {
        return (
            <main className="col-md-9 ml-sm-auto col-lg-10 px-md-4">
                <div className="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 className="h1">employee</h1>
                    <div ClassName="btn-toolbar mb-2 mb-md-0">
                        <div ClassName="btn-group mr-2">
                            <button type="button" ClassName="btn btn-sm btn-outline-secondary">
                                <Icon.Plus/> add
                            </button>
                        </div>
                    </div>
                </div>
                <div ClassName="table-responsive">
                    <table ClassName="table table-striped table-sm">
                        <thead>
                            <tr>
                                <th>name</th>
                                <th>surname</th>
                                <th>email</th>
                                <th>profession</th>
                                <th>actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>someone</td>
                                <td>someone</td>
                                <td>someone</td>
                                <td>someone</td>
                                <td>
                                    <button type="button" ClassName="btn btn-sm btn-outline-secondary">
                                        <Icon.Upload/> update
                                    </button>
                                    <button type="button" ClassName="btn btn-sm btn-outline-secondary">
                                        <Icon.Delete/> delete
                                    </button>
                                    <button type="button" ClassName="btn btn-sm btn-outline-secondary">
                                        <Icon.Database/> view
                                    </button>
                                </td>
                            </tr>
                        </tbody>
                        <tfoot>
                            <tr>
                                <th>name</th>
                                <th>surname</th>
                                <th>email</th>
                                <th>profession</th>
                                <th></th>
                            </tr>
                        </tfoot>
                    </table>
                </div>
            </main>
        )
    }
}
