package com.example.todo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

import java.util.*;
import com.example.todo.model.Todo;
import java.sql.ResultSet;
import org.springframework.jdbc.core.RowMapper;

public class TodoRowMapper implements RowMapper<Todo> {
  @Override
  public Todo mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new Todo(
        rs.getInt("id"),
        rs.getString("todo"),
        rs.getString("priority"),
        rs.getString("status"));

  }
}

// Write your code here
