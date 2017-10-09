package com.ycedres.todomgr.web;


import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.ycedres.todomgr.model.TaskRepository;
import com.ycedres.todomgr.model.Task;
import org.springframework.beans.factory.annotation.Autowired;




@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    private final TaskRepository repo;
    private final TaskEditor editor;
    final Grid<Task> grid;
    private final Button addNewBtn;

    @Autowired
    public VaadinUI(TaskRepository repo,TaskEditor editor) {
        this.repo = repo;
        this.editor = editor;
        this.grid = new Grid<>(Task.class);
        this.addNewBtn = new Button("New Task");
    }

    /*@Override
    protected void init(VaadinRequest request) {
        //setContent(new Button("Click me", e -> Notification.show("Hello Spring+Vaadin user!")));
        setContent(grid);
        listTasks();
    }*/

    @Override
    protected void init(VaadinRequest request) {
        // build layout
        HorizontalLayout actions = new HorizontalLayout(addNewBtn);
        VerticalLayout mainLayout = new VerticalLayout(actions, grid, editor);
        setContent(mainLayout);

        grid.setHeight(300, Unit.PIXELS);
        grid.setColumns("id", "description");

        grid.asSingleSelect().addValueChangeListener(e -> {
            editor.editTask(e.getValue());
        });

        addNewBtn.addClickListener(e -> editor.editTask(new Task("")));

        // Initialize listing
        listTasks();
    }

    private void listTasks() {
        grid.setItems(repo.findAll());
    }

}