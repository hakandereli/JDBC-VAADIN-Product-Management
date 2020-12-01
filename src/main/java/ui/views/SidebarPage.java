package ui.views;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import core.domain.Menu;
import core.service.MenuService;
import ui.components.Content;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SidebarPage extends VerticalLayout {
    static Content content;
    public SidebarPage(Content content){
        this.content=content;
        buildMainLayout();
    }

    private void buildMainLayout(){
        List<Menu> menuList = getMenuList();
        buildButtons(menuList);
    }

    private List<Menu> getMenuList() {
        List<Menu> menuList = new ArrayList<Menu>();
        MenuService menuService=new MenuService();

        try {
            menuList = menuService.menuGetir();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return menuList;
    }

    private void buildButtons(List<Menu> menuList) {
        for (Menu menuItem : menuList) {
            Button menuButtons=new Button(menuItem.getAd());
            addComponent(menuButtons);

            menuButtons.addClickListener(new Button.ClickListener() {
                @Override
                public void buttonClick(Button.ClickEvent clickEvent) {
                    menuGetButtons(menuItem);
                }
            });
        }
    }

    private void menuGetButtons(Menu menuItem) {
        try {
            Class<?> createClass = Class.forName("ui.views."+menuItem.getClassdirectory());
            Object obj = createClass.newInstance();
            Component component = (Component) obj;
            content.setContent(component);
        } catch (ClassNotFoundException hata) {
            Notification.show(menuItem.getClassdirectory());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
