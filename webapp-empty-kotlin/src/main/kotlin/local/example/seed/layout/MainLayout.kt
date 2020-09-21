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

package local.example.seed.layout

import com.vaadin.flow.component.Component
import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.dependency.CssImport
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.icon.Icon
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo


@CssImport(value = "style.css")
@Theme(value = Lumo::class, variant = Lumo.DARK)
class MainLayout : AppLayout() {

    private lateinit var menu: Tabs
    private lateinit var title: H1

    init {
        primarySection = Section.DRAWER
        addToNavbar(true)
    }

    fun createHeaderContent() : Component {
        val horizontalLayout = HorizontalLayout()
        horizontalLayout.setId("header")
        horizontalLayout.themeList.set("dark", true)
        horizontalLayout.setSizeFull()
        horizontalLayout.isSpacing = false
        horizontalLayout.alignItems = FlexComponent.Alignment.CENTER
        horizontalLayout.add(DrawerToggle())
        title = H1()
        horizontalLayout.add(title)
        return horizontalLayout
    }

    fun createDrawerContent(menu: Tabs) : Component {
        val verticalLayout = VerticalLayout()
        val horizontalLayout = HorizontalLayout()
        verticalLayout.setSizeFull()
        verticalLayout.isPadding = false
        verticalLayout.isSpacing = false
        verticalLayout.alignItems = FlexComponent.Alignment.STRETCH
        horizontalLayout.alignItems = FlexComponent.Alignment.CENTER
        // TODO
        horizontalLayout.add("icon")
        horizontalLayout.add("label")
        verticalLayout.add(horizontalLayout, menu)
        return verticalLayout
    }

    fun createMenu() : Tabs {
        val tabs = Tabs()
        tabs.orientation = Tabs.Orientation.VERTICAL
        // TODO
        return tabs
    }

    fun createMenuItems() {
        // TODO
    }
}
