package com.ycedres.todomgr.web.commons;


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.ycedres.todomgr.model.User;
import com.ycedres.todomgr.service.TaskService;
import com.ycedres.todomgr.service.UserService;
import com.ycedres.todomgr.web.tasks.TaskEditor;
import com.ycedres.todomgr.web.users.ShowUserLayoutFactory;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
@Theme("mytheme")
public class TodoMgrUI extends UI {


    Grid<User> grid;

    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskEditor editor;

    @Autowired
    private ShowUserLayoutFactory usuario;
    private Button addNewBtn;

    private Panel changeTab = new Panel();


    @Override
    protected void init(VaadinRequest request) {

        VerticalLayout root = new VerticalLayout();
        root.setSizeFull();
        root.setMargin(true);

        Panel content = new Panel();
        content.setWidth("75%");
        content.setHeight("100%");

        HorizontalLayout uiLayout = new HorizontalLayout();
        uiLayout.setSizeFull();
        uiLayout.setMargin(true);

        uiLayout.addComponent(usuario.createComponent());

        content.setContent(uiLayout);

        root.addComponent(content);

        // Set the VerticalLayout as the content of the UI
        setContent(root);
    }
}