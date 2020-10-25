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
import com.vaadin.flow.component.Unit;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import local.example.seed.layout.MainLayout;
import local.example.seed.model.Customer;
import local.example.seed.model.util.Link;
import local.example.seed.service.CustomerRetrieverService;

import java.util.Optional;

@PageTitle("customer")
@CssImport("style.css")
@Route(value = "customer", layout = MainLayout.class)
public class CustomerView
        extends Main {

    private final Grid<Customer> customerGrid;
    private final Binder<Customer> customerBinder;

    private Customer customer;
    private final CustomerRetrieverService customerRetrieverService;

    private TextField name;
    private TextField surname;
    private EmailField email;

    private final Button cancel;
    private final Button update;
    private final Button create;
    private final Button delete;

    public CustomerView() {
        addClassName("main-view");

        this.customerGrid = new Grid<>(Customer.class);
        this.customerBinder = new Binder<>(Customer.class);
        this.customerBinder.bindInstanceFields(this);

        this.customer = new Customer();
        this.customerRetrieverService = new CustomerRetrieverService();

        this.cancel = new Button("cancel");
        this.cancel.addClickListener(listener -> {
            this.clear();
            this.refresh();
        });
        this.update = new Button("update");
        this.update.addClickListener(listener -> {
            try {
                if (this.customer != null) {
                    this.customerBinder.writeBean(this.customer);
                    this.customerRetrieverService.update(
                            this.customer,
                            this.customer.get_links().getSelf().getHref()
                    );
                    this.clear();
                    this.refresh();
                    this.reload();
                    Notification.show("customer details have been updated");
                }
            } catch (ValidationException validationException) {
                Notification.show("sorry, the customer details have not been updated");
                validationException.printStackTrace();
            }
        });
        this.create = new Button("create");
        this.create.addClickListener(listener -> {
            try {
                if (
                        !this.name.getValue().isEmpty() &
                                !this.surname.getValue().isEmpty() &
                                !this.email.getValue().isEmpty()
                ) {
                    this.customer = new Customer(
                            this.name.getValue(),
                            this.surname.getValue(),
                            this.email.getValue(),
                            new Link()
                    );
                    this.customerBinder.writeBean(this.customer);
                    this.customerRetrieverService.create(
                            this.customer
                    );
                    this.clear();
                    this.refresh();
                    this.reload();
                    Notification.show("new customer's details have been created");
                }
            } catch (ValidationException validationException) {
                Notification.show("sorry, the customer details have not been created");
                validationException.printStackTrace();
            }
        });
        this.delete = new Button("delete");
        this.delete.addClickListener(listener -> {
            try {
                if (this.customer != null) {
                    this.customerBinder.writeBean(this.customer);
                    this.customerRetrieverService.delete(
                            this.customer.get_links().getSelf().getHref()
                    );
                    this.clear();
                    this.refresh();
                    this.reload();
                    Notification.show("the selected customer has been deleted");
                }
            } catch (ValidationException validationException) {
                Notification.show("sorry, the selected customer has not been deleted");
                validationException.printStackTrace();
            }
        });

        SplitLayout splitLayout = new SplitLayout();
        splitLayout.setSizeFull();

        this.customerGrid.setColumns(
                "name", "surname", "email"
        );
        this.customerGrid.setItems(customerRetrieverService.readAll());
        this.customerGrid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
        this.customerGrid.setHeightByRows(true);
        this.customerGrid.asSingleSelect().addValueChangeListener(listener -> {
            if (listener.getValue() != null) {
                Optional<Customer> customerFromBackend = this.customerRetrieverService.read(
                        listener.getValue().get_links().getSelf().getHref()
                );
                if (customerFromBackend.isPresent()) {
                    this.populate(customerFromBackend.get());
                } else {
                    this.refresh();
                }
            } else {
                this.clear();
            }
        });

        this.createGridLayout(splitLayout);
        this.createEditorLayout(splitLayout);
        this.add(splitLayout);
    }

    private void createEditorLayout(
            SplitLayout splitLayout
    ) {
        Div divEditorLayout = new Div();
        Div divEditor = new Div();
        divEditorLayout.add(divEditor);
        FormLayout formLayout = new FormLayout();
        this.name.setAutofocus(true);
        this.name.setMinWidth(100, Unit.PIXELS);
        this.surname.setMinWidth(100, Unit.PIXELS);
        this.email.setMinWidth(100, Unit.PIXELS);
        this.email.setClearButtonVisible(true);
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
        this.update.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        this.create.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        this.delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        buttonHorizontalLayout.add(
                this.cancel, this.update, this.create, this.delete
        );
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

    private void reload() {
        this.customerGrid.setItems(customerRetrieverService.readAll());
    }
}
