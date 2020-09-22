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
import com.vaadin.flow.component.ComponentUtil
import com.vaadin.flow.component.applayout.AppLayout
import com.vaadin.flow.component.applayout.DrawerToggle
import com.vaadin.flow.component.html.H1
import com.vaadin.flow.component.icon.VaadinIcon
import com.vaadin.flow.component.orderedlayout.FlexComponent
import com.vaadin.flow.component.orderedlayout.HorizontalLayout
import com.vaadin.flow.component.orderedlayout.VerticalLayout
import com.vaadin.flow.component.tabs.Tab
import com.vaadin.flow.component.tabs.Tabs
import com.vaadin.flow.component.tabs.TabsVariant
import com.vaadin.flow.router.PageTitle
import com.vaadin.flow.router.RouterLink
import com.vaadin.flow.theme.Theme
import com.vaadin.flow.theme.lumo.Lumo
import local.example.seed.view.AboutView
import local.example.seed.view.AlternativeView
import local.example.seed.view.HelpView
import local.example.seed.view.MainView
import java.util.*

@Theme(value = Lumo::class, variant = Lumo.DARK)
class MainLayout : AppLayout() {

    private var menu: Tabs
    private lateinit var title: H1

    private val currentPageTitle: String get() = content
            .javaClass.getAnnotation(PageTitle::class.java).value

    private fun createHeaderContent() : Component {
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

    private fun createDrawerContent(menu: Tabs) : Component {
        val verticalLayout = VerticalLayout()
        val horizontalLayout = HorizontalLayout()
        verticalLayout.setSizeFull()
        verticalLayout.isPadding = false
        verticalLayout.isSpacing = false
        verticalLayout.alignItems = FlexComponent.Alignment.STRETCH
        horizontalLayout.setId("logo")
        horizontalLayout.alignItems = FlexComponent.Alignment.BASELINE
        horizontalLayout.add(VaadinIcon.FOLDER_OPEN.create())
        horizontalLayout.add(" ")
        horizontalLayout.add("example-empty")
        verticalLayout.add(horizontalLayout, menu)
        return verticalLayout
    }

    private fun createMenu() : Tabs {
        val tabs = Tabs()
        tabs.orientation = Tabs.Orientation.VERTICAL
        tabs.addThemeVariants(TabsVariant.LUMO_MINIMAL)
        tabs.setId("tabs")
        tabs.add(*createMenuItems())
        return tabs
    }

    private fun createMenuItems(): Array<Tab> {
        return arrayOf(
                createTab("Main", MainView::class.java),
                createTab("Alternative", AlternativeView::class.java),
                createTab("Help", HelpView::class.java),
                createTab("About", AboutView::class.java)
        )
    }

    private fun getTabForComponent(component: Component): Optional<Tab> {
        return menu.children
                .filter { tab: Component? ->
                    (ComponentUtil.getData(tab, Class::class.java)
                            == component.javaClass)
                }
                .findFirst().map { obj: Component? -> Tab::class.java.cast(obj) }
    }

    init {
        primarySection = Section.DRAWER
        addToNavbar(true, createHeaderContent())
        menu = createMenu()
        addToDrawer(createDrawerContent(menu))
    }

    override fun afterNavigation() {
        super.afterNavigation()
        getTabForComponent(content).ifPresent {
            selectedTab: Tab? -> menu.selectedTab = selectedTab
        }
        title.text = currentPageTitle
    }

    companion object {
        private fun createTab(text: String, navigationTarget: Class<out Component>): Tab {
            val tab = Tab()
            tab.add(RouterLink(text, navigationTarget))
            ComponentUtil.setData(tab, Class::class.java, navigationTarget)
            return tab
        }
    }
}
