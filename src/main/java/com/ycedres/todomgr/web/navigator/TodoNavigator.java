package com.ycedres.todomgr.web.navigator;


import com.vaadin.navigator.Navigator;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.UI;

public class TodoNavigator extends Navigator {

    public TodoNavigator(UI ui, SingleComponentContainer container) {
        super(ui, container);
    }

    private static TodoNavigator getNavigator() {
        UI ui = UI.getCurrent();
        Navigator navigator = ui.getNavigator();
        return (TodoNavigator) navigator;
    }

    public static void navigate(String path) {
        try {
            TodoNavigator.getNavigator().navigateTo(path);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void navigateTo(String viewName) {
        super.navigateTo(viewName);
    }
}
