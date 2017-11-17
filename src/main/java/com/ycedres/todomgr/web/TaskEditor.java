package com.ycedres.todomgr.web;

import com.vaadin.data.Binder;
import com.vaadin.event.ShortcutAction;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;
import com.ycedres.todomgr.service.TaskService;
import com.ycedres.todomgr.model.Task;
import org.springframework.beans.factory.annotation.Autowired;

@SpringComponent
@UIScope
public class TaskEditor extends VerticalLayout{

    private final TaskService taskService;

    private Task task;

    TextField description = new TextField("Descripcion:");

    Button save = new Button("Save");
    Button cancel = new Button("Cancel");
    Button delete = new Button("Delete");
    CssLayout actions = new CssLayout(save, cancel, delete);

    Binder<Task> binder = new Binder<>(Task.class);

    @Autowired
    public TaskEditor(TaskService taskService) {
        this.taskService = taskService;

        addComponents(description,actions);

        binder.bindInstanceFields(this);

        setSpacing(true);
        actions.setStyleName(ValoTheme.LAYOUT_COMPONENT_GROUP);
        save.setStyleName(ValoTheme.BUTTON_PRIMARY);
        save.setClickShortcut(ShortcutAction.KeyCode.ENTER);

        save.addClickListener(e -> taskService.addTask(task));
        delete.addClickListener(e -> taskService.deleteTask(task));
        cancel.addClickListener(e -> editTask(task));
        setVisible(false);

    }

    public interface ChangeHandler {

        void onChange();
    }

    public final void editTask(Task t){
        if (t == null) {
            setVisible(false);
            return;
        }
        final boolean persisted = t.getId() != null;

        if (persisted) {
            task = taskService.getTask(t.getId());
        }
        else {
            task = t;
        }
        cancel.setVisible(persisted);

        binder.setBean(task);
        setVisible(true);

        save.focus();
        description.selectAll();
    }

    public void setChangeHandler(ChangeHandler h) {
        // ChangeHandler is notified when either save or delete
        // is clicked
        save.addClickListener(e -> h.onChange());

        delete.addClickListener(e -> h.onChange());
    }

}
