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

package local.example.seed.view;

import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import local.example.seed.layout.MainLayout;
import local.example.seed.model.Customer;

@PageTitle("customer")
@CssImport("style.css")
@Route(value = "customer", layout = MainLayout.class)
public class CustomerView
        extends Main {

    private Grid<Customer> customerGrid;
    private Binder<Customer> customerBinder;

    private Customer customer;
    // TODO

    private TextField name;
    private TextField surname;
    private TextField email;

    private final Button cancel;
    private final Button save;
    private final Button delete;

    private final SplitLayout splitLayout;

    public CustomerView() {
        addClassName("main-view");

        this.customerGrid = new Grid<>(Customer.class);
        this.customerBinder = new Binder<>(Customer.class);

        this.customer = new Customer();
        // TODO

        this.cancel = new Button("");
        this.save = new Button("");
        this.delete = new Button("");

        this.splitLayout = new SplitLayout();
        this.splitLayout.setSizeFull();

        this.add(this.splitLayout);
    }

    private void createEditorLayout(
            SplitLayout splitLayout
    ) {
        // TODO
    }

    private void createButtonLayout(
            Div divEditorLayout
    ) {
        // TODO
    }

    private void createGridLayout(
            SplitLayout splitLayout
    ) {
        // TODO
    }

    private void addFormItem(
            Div divWrapper,
            FormLayout formLayout,
            AbstractField abstractField,
            String fieldName
    ) {
        // TODO
    }

    private void refresh() {
        // TODO
    }

    private void clear() {
        // TODO
    }
}
