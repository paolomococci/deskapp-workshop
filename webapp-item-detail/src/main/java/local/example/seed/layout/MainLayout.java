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

package local.example.seed.layout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Theme(value = Lumo.class, variant = Lumo.DARK)
public class MainLayout
        extends AppLayout {

    private final Tabs tabs;
    private H1 title;

    @Autowired
    public MainLayout() {
        tabs = null;
    }

    private Component createHeaderContent() {
        // TODO
        return null;
    }

    private Component createDrawerContent(Tabs tabs) {
        // TODO
        return null;
    }

    private Tabs createMenu() {
        // TODO
        return null;
    }

    private Component[] createMenuItems() {
        // TODO
        return new Component[0];
    }

    private Optional<Tab> getTabForComponent(Component component) {
        // TODO
        return null;
    }

    private static Tab createTab() {
        // TODO
        return null;
    }

    private String getCurrentPageTitle() {
        // TODO
        return null;
    }

    @Override
    protected void afterNavigation() {
        super.afterNavigation();
        // TODO
    }
}
