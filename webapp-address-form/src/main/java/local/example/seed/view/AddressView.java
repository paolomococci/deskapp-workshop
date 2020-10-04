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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import local.example.seed.layout.MainLayout;
import local.example.seed.model.Address;
import local.example.seed.service.AddressRetrieverService;

@PageTitle("address")
@CssImport("style.css")
@Route(value = "address", layout = MainLayout.class)
public class AddressView
        extends Main {

    private final Grid<Address> addressGrid;
    private final Binder<Address> addressBinder;

    private Address address;
    private AddressRetrieverService addressRetrieverService;

    private TextField country;
    private TextField city;
    private TextField street;
    private TextField civic;
    private TextField code;

    private final Button cancel;
    private final Button save;
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

        this.addressGrid.setColumns(
                "country", "city", "street", "civic", "code"
        );
        // TODO: import data values
        //this.addressGrid.setItems(Collection<Address> addresses);
        this.addressGrid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS);
        this.addressGrid.setHeightFull();

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
}
