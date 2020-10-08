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
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import local.example.seed.layout.MainLayout;
import local.example.seed.model.Customer;
import local.example.seed.service.CustomerRetrieverService;

@PageTitle("customer")
@CssImport("style.css")
@Route(value = "customer", layout = MainLayout.class)
public class CustomerView
        extends Main {

    private Grid<Customer> customerGrid;
    private Binder<Customer> customerBinder;

    private Customer customer;
    private CustomerRetrieverService customerRetrieverService;

    private TextField name;
    private TextField surname;
    private TextField email;

    private final Button cancel;
    private final Button save;
    private final Button delete;

    private final SplitLayout splitLayout;

    public CustomerView() {
        addClassName("main-view");

        this.customerGrid = new Grid<>();
        this.customerBinder = new Binder<>(Customer.class);
        this.customerBinder.bindInstanceFields(this);

        this.customer = new Customer();
        this.customerRetrieverService = new CustomerRetrieverService();

        this.cancel = new Button("cancel");
        this.cancel.addClickListener(listener -> {
            // TODO: behaviour
        });
        this.save = new Button("save");
        this.save.addClickListener(listener -> {
            // TODO: behaviour
        });
        this.delete = new Button("delete");
        this.delete.addClickListener(listener -> {
            // TODO: behaviour
        });

        this.splitLayout = new SplitLayout();
        this.splitLayout.setSizeFull();

        this.customerGrid.addColumn(
                customer -> this.customer.getName()
        ).setHeader("name").setSortable(true).setTextAlign(ColumnTextAlign.START);
        this.customerGrid.addColumn(
                customer -> this.customer.getSurname()
        ).setHeader("surname").setSortable(true);
        this.customerGrid.addColumn(
                customer -> this.customer.getEmail()
        ).setHeader("email").setSortable(false);
        this.customerGrid.setItems(customerRetrieverService.readAll());
        this.customerGrid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
        this.customerGrid.setHeightFull();
        this.customerGrid.asSingleSelect().addValueChangeListener(listener -> {
            // TODO
        });

        this.createGridLayout(splitLayout);
        this.createEditorLayout(splitLayout);
        this.add(this.splitLayout);
    }

    private void createEditorLayout(
            SplitLayout splitLayout
    ) {
        Div divEditorLayout = new Div();
        Div divEditor = new Div();
        divEditorLayout.add(divEditor);
        FormLayout formLayout = new FormLayout();
        addFormItem(divEditor, formLayout, this.name, "name");
        addFormItem(divEditor, formLayout, this.surname, "surname");
        addFormItem(divEditor, formLayout, this.email, "email");
        createButtonLayout(divEditorLayout);
        splitLayout.addToSecondary(divEditorLayout);
    }

    private void createButtonLayout(
            Div divEditorLayout
    ) {
        HorizontalLayout buttonHorizontalLayout = new HorizontalLayout();
        buttonHorizontalLayout.setWidthFull();
        buttonHorizontalLayout.setSpacing(true);
        this.cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        this.save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        buttonHorizontalLayout.add(this.cancel, this.save, this.delete);
        buttonHorizontalLayout.setSpacing(true);
        buttonHorizontalLayout.setMargin(true);
        divEditorLayout.add(buttonHorizontalLayout);
    }

    private void createGridLayout(
            SplitLayout splitLayout
    ) {
        Div divWrapper = new Div();
        divWrapper.setWidthFull();
        splitLayout.addToPrimary(divWrapper);
        divWrapper.add(this.customerGrid);
    }

    private void addFormItem(
            Div divWrapper,
            FormLayout formLayout,
            AbstractField abstractField,
            String fieldName
    ) {
        formLayout.addFormItem(abstractField, fieldName);
        divWrapper.add(formLayout);
    }

    private void refresh() {
        this.customerGrid.select(null);
        this.customerGrid.getDataProvider().refreshAll();
    }

    private void clear() {
        this.populate(null);
    }

    private void populate(Customer customer) {
        this.customer = customer;
        this.customerBinder.readBean(this.customer);
    }
}
