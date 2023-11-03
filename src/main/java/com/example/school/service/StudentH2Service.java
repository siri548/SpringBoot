package com.example.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.school.model.Student;
import com.example.school.model.StudentRowMapper;
import com.example.school.repository.StudentRepository;

@Service
public class StudentH2Service implements StudentRepository {
    @Autowired
    public JdbcTemplate db;

    @Override
    public ArrayList<Student> getStudents() {
        Collection<Student> students = db.query("select * from STUDENT", new StudentRowMapper());
        ArrayList<Student> allStudents = new ArrayList<>(students);
        return allStudents;
    }

    @Override
    public Student getStudentById(int studentId) {
        try {
            Student stude = db.queryForObject("select * from STUDENT where studentId=?", new StudentRowMapper(),
                    studentId);
            return stude;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Student updateStudent(int studentId, Student stude) {
        if (stude.getStudentName() != null) {
            db.update("update STUDENT SET studentName=? where studentId=?", stude.getStudentName(), studentId);
        }
        if (stude.getGender() != null) {
            db.update("update STUDENT SET gender=? where studentId=?", stude.getGender(), studentId);

        }
        if (stude.getStandard() != 0) {
            db.update("update STUDENT SET standard=? where studentId=?", stude.getStandard(), studentId);
        }
        return getStudentById(studentId);
    }

    @Override
    public Student addStudent(Student stude) {
        db.update("INSERT INTO STUDENT(studentName, gender, standard) VALUES(?,?,?)",
                stude.getStudentName(), stude.getGender(), stude.getStandard());
        Student addedstudent = db.queryForObject("select * from STUDENT where studentName=? and gender=? and standard=?",
                new StudentRowMapper(), stude.getStudentName(), stude.getGender(), stude.getStandard());
        return addedstudent;
    }

    @Override
    public void deleteStudent(int studentId) {
        db.update("delete from STUDENT where studentId=?", studentId);
    }

    @Override
    public String addStudents(ArrayList<Student> students) {
        int count = 0;
        for (Student stude : students) {
            db.update("INSERT INTO STUDENT(studentName, gender, standard) VALUES(?,?,?)",
                    
                    stude.getStudentName(), stude.getGender(), stude.getStandard());
            count += 1;

        }
        String msg = String.format("Successfully added %d students", count);
        return msg;
    }

}
// Write your code here