package com.ycedres.todomgr.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

    @Query("select t from Task t order by t.id")
    List<Task> getAllTasks();
}
