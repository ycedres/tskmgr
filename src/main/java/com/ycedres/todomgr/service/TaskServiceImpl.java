package com.ycedres.todomgr.service;

import com.ycedres.todomgr.model.Task;
import com.ycedres.todomgr.model.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void addTask(Task taskDAO) {
        Task t = new Task();
        t.setDescription(taskDAO.getDescription());

        taskRepository.save(t);
    }

    @Override
    public List<Task> getAll() {
        return this.taskRepository.getAllTasks();
    }

}
