package com.ycedres.todomgr.service;

import com.ycedres.todomgr.model.Task;
import java.util.List;

public interface TaskService {

    public void addTask(Task task);
    public void deleteTask(Task task);
    public Task getTask(Integer taskId);
    public List<Task> getAll();

}
