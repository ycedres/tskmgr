package com.ycedres.todomgr.web.users;

import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.ycedres.todomgr.model.User;
import com.ycedres.todomgr.service.UserService;
import com.ycedres.todomgr.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Component
public class ShowUserLayoutFactory {

    @Autowired
    private UserService userService;


    private class ShowUserLayout extends VerticalLayout {

        public final Logger log = LoggerFactory.getLogger(UserLayoutFactory.class);

        private List<User> userList;
        private Grid<User> userTable = new Grid<>();



        public ShowUserLayout init() {
            setMargin(true);
            //userList = userService.getAll();
            userList = userService.getAllUsers();
            userTable.setItems(userList);
            userTable.addColumn(User::getId).setCaption("Id");
            userTable.addColumn(User::getUsername).setCaption("Name");

            return this;
        }

        public ShowUserLayout load() {
            //UserService userService = new UserServiceImpl();
            if (userService == null) {
                log.info("userService es null");
            }
            userList = userService.getAllUsers();
            return this;
        }

        public ShowUserLayout layout() {
            addComponent(userTable);
            return this;
        }
    }


    public Component createComponent() {
        return new ShowUserLayout().load().init().layout();
    }

}
