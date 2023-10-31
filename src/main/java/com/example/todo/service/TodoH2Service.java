package com.example.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.todo.model.Todo;
import com.example.todo.model.TodoRowMapper;
import com.example.todo.repository.TodoRepository;

@Service
public class TodoH2Service implements TodoRepository {

    @Autowired
    private JdbcTemplate db;

    @Override
    public ArrayList<Todo> getTodos() {
        Collection<Todo> getTasks = db.query("select * from todolist", new TodoRowMapper());
        ArrayList<Todo> tasks = new ArrayList<>(getTasks);
        return tasks;
    }

    @Override
    public Todo getTodoById(int id) {
        try {
            Todo task = db.queryForObject("select * from todolist where id=?", new TodoRowMapper(), id);
            return task;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Todo updateTodo(int id, Todo todo) {
        if (todo.getTodo() != null) {
            db.update("update todolist SET todo=? where id=?", todo.getTodo(), id);
        }
        if (todo.getPriority() != null) {
            db.update("update todolist SET priority=? where id=?", todo.getPriority(), id);
        }
        if (todo.getStatus() != null) {
            db.update("update todolist SET status=? where id=?", todo.getStatus(), id);
        }
        return getTodoById(id);

    }

    @Override
    public Todo addTodo(Todo todo) {
        db.update("INSERT INTO todolist(id, todo, priority, status)VALUES(?,?,?,?)", todo.getId(), todo.getTodo(),
                todo.getPriority(), todo.getStatus());
        Todo task = db.queryForObject("select * from todolist where todo=? and priority=? and status=?",
                new TodoRowMapper(), todo.getTodo(), todo.getPriority(), todo.getStatus());
        return task;
    }

    @Override
    public void deleteTodo(int id) {
        db.update("delete from todolist where id=?", id);
    }

}

// Write your code here
