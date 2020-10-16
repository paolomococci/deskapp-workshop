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
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Main;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import local.example.seed.layout.MainLayout;
import local.example.seed.model.Address;
import local.example.seed.model.Link;
import local.example.seed.service.AddressRetrieverService;

import java.util.Optional;

@PageTitle("address")
@CssImport("style.css")
@Route(value = "address", layout = MainLayout.class)
public class AddressView
        extends Main {

    private final Grid<Address> addressGrid;
    private final Binder<Address> addressBinder;

    private Address address;
    private final AddressRetrieverService addressRetrieverService;

    private TextField country;
    private TextField city;
    private TextField street;
    private TextField civic;
    private TextField code;

    private final Button cancel;
    private final Button update;
    private final Button create;
    private final Button delete;

    private final SplitLayout splitLayout;

    public AddressView() {
        addClassName("main-view");

        this.addressGrid = new Grid<>(Address.class);
        this.addressBinder = new Binder<>(Address.class);
        this.addressBinder.bindInstanceFields(this);

        this.address = new Address();
        this.addressRetrieverService = new AddressRetrieverService();

        this.cancel = new Button("cancel");
        this.cancel.addClickListener(listener -> {
            this.clear();
            this.refresh();
        });
        this.update = new Button("update");
        this.update.addClickListener(listener -> {
            try {
                if (this.address != null) {
                    this.addressBinder.writeBean(this.address);
                    this.addressRetrieverService.update(
                            this.address,
                            this.address.get_links().getSelf().getHref()
                    );
                    this.clear();
                    this.refresh();
                    this.reload();
                    Notification.show("address details have been updated");
                }
            } catch (ValidationException validationException) {
                Notification.show("sorry, the address details have not been updated");
                validationException.printStackTrace();
            }
        });
        this.create = new Button("create");
        this.create.addClickListener(listener -> {
            try {
                if (
                        !this.country.getValue().isEmpty() &
                        !this.city.getValue().isEmpty() &
                        !this.street.getValue().isEmpty() &
                        !this.civic.getValue().isEmpty() &
                        !this.code.getValue().isEmpty()
                ) {
                    this.address = new Address(
                            this.country.getValue(),
                            this.city.getValue(),
                            this.street.getValue(),
                            this.civic.getValue(),
                            this.code.getValue(),
                            null,
                            new Link()
                    );
                    this.addressBinder.writeBean(this.address);
                    this.addressRetrieverService.create(
                            this.address
                    );
                    this.clear();
                    this.refresh();
                    this.reload();
                    Notification.show("new address's details have been created");
                }
            } catch (ValidationException validationException) {
                Notification.show("sorry, the address details have not been created");
                validationException.printStackTrace();
            }
        });
        this.delete = new Button("delete");
        this.delete.addClickListener(listener -> {
            try {
                if (this.address != null) {
                    this.addressBinder.writeBean(this.address);
                    this.addressRetrieverService.delete(
                            this.address.get_links().getSelf().getHref()
                    );
                    this.clear();
                    this.refresh();
                    this.reload();
                    Notification.show("the selected address has been deleted");
                }
            } catch (ValidationException validationException) {
                Notification.show("sorry, the selected address has not been deleted");
                validationException.printStackTrace();
            }
        });

        this.splitLayout = new SplitLayout();
        this.splitLayout.setSizeFull();

        this.addressGrid.setColumns("country", "city", "street", "civic", "code");
        this.addressGrid.setItems(this.addressRetrieverService.readAll());
        this.addressGrid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
        this.addressGrid.setHeightFull();
        this.addressGrid.asSingleSelect().addValueChangeListener(listener -> {
            if (listener.getValue() != null) {
                Optional<Address> addressFromBackend = addressRetrieverService.read(
                        listener.getValue().get_links().getSelf().getHref()
                );
                if (addressFromBackend.isPresent()) {
                    this.populate(addressFromBackend.get());
                } else {
                    this.refresh();
                }
            } else {
                this.clear();
            }
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
        addFormItem(divEditor, formLayout, this.country, "country");
        addFormItem(divEditor, formLayout, this.city, "city");
        addFormItem(divEditor, formLayout, this.street, "street");
        addFormItem(divEditor, formLayout, this.civic, "civic");
        addFormItem(divEditor, formLayout, this.code, "code");
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
                this.cancel, this.update, this.create, this.delete);
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
        divWrapper.add(this.addressGrid);
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
        this.addressGrid.select(null);
        this.addressGrid.getDataProvider().refreshAll();
    }

    private void clear() {
        this.populate(null);
    }

    private void populate(Address address) {
        this.address = address;
        this.addressBinder.readBean(this.address);
    }

    private void reload() {
        this.addressGrid.setItems(addressRetrieverService.readAll());
    }
}
