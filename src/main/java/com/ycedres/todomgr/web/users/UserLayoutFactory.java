package com.ycedres.todomgr.web.users;

import com.vaadin.data.Binder;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.ycedres.todomgr.model.User;
import com.ycedres.todomgr.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserLayoutFactory extends VerticalLayout {



    private List<User> userList;
    private Binder<User> binder;
    //private BeanItemContainer<User> container;

    @Autowired
    private UserService userService;

    private class ShowUserLayout extends VerticalLayout {

        private Grid<User> userTable;

        public ShowUserLayout init() {
            setMargin(true);
            //userTable.addColumn(User::getUsername).setCaption("Name");
            return this;
        }

        public ShowUserLayout layout() {
            addComponent(userTable);
            return this;
        }

        public ShowUserLayout load() {
            userList = userService.getAll();
            return this;
        }

    }


}
