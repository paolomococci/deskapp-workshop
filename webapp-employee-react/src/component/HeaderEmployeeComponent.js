/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
