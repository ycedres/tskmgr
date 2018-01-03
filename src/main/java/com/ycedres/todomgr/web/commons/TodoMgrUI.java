package com.ycedres.todomgr.web.commons;


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.ycedres.todomgr.model.Task;
import com.ycedres.todomgr.model.User;
import com.ycedres.todomgr.service.TaskService;
import com.ycedres.todomgr.service.UserService;
import com.ycedres.todomgr.web.tasks.TaskEditor;
import com.ycedres.todomgr.web.users.ShowUser;
import com.ycedres.todomgr.web.users.ShowUserLayoutFactory;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
@Theme("mytheme")
public class TodoMgrUI extends UI {

    //Grid<Task> grid;
    Grid<User> grid;
    //final Grid<User> grid;
    @Autowired
    private TaskService taskService;
    @Autowired
    private UserService userService;
    @Autowired
    private TaskEditor editor;

    @Autowired
    private ShowUserLayoutFactory usuario;
    private Button addNewBtn;

    //@Autowired
    //private ShowUser su;

    private Panel changeTab = new Panel();

    //@Autowired --> ¿POR QUÉ ESTO PUEDE ESTAR COMENTADO?
/*    public TodoMgrUI(TaskService taskService, TaskEditor editor, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
        this.editor = editor;
        this.grid = new Grid<>(Task.class);
        //this.grid = new Grid<>(User.class);
        this.addNewBtn = new Button("New Task");
    }*/

    @Override
    protected void init(VaadinRequest request) {


        // esto no funciona y no sé por qué
        //ShowUser us = new ShowUser();
        //su.UnMetodo();
        //this.grid = new Grid<>(Task.class);
        this.grid = new Grid<>(User.class);
        //ShowUserLayoutFactory usuario = new ShowUserLayoutFactory();
        usuario.createComponent();
         //

        //setContent(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
        setContent(grid);
        listTasks();
        //listUsers();
    }

/*
    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout(addNewBtn);

        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
        setContent(mainLayout);



        HorizontalLayout titleBar = new HorizontalLayout();
        titleBar.setWidth("100%");
        actions.addComponent(titleBar);
        Label title = new Label("The Ultimate Cat Finder");
        titleBar.addComponent(title);
        titleBar.setExpandRatio(title, 1.0f);

        grid.setCaption("Tareas");
        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("id", "description");

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editTask(e.getValue());
        });

        addNewBtn.addClickListener(e -> editor.editTask(new Task("")));

        // Initialize listing
        listTasks();
    }/**/

/*
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

        ShowUserLayoutFactory usuario = new ShowUserLayoutFactory();
        uiLayout.addComponent(usuario.createComponent());

        content.setContent(uiLayout);

        root.addComponent(content);

        // Set the VerticalLayout as the content of the UI
        setContent(root);
    }
*/

    private void listTasks() {
        //grid.setItems(taskService.getAll());
        grid.setItems(userService.getAll());
    }
/*
    private void listUsers() {
        //grid.setItems(userService.getAll());
        grid.setItems(userService.getAllUsers());
    }
*/
}