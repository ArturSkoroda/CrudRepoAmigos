package com.example.CRUD.Amigoscoode.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")

public class StudentController {

    private final StudentSevice studentSevice;

    @Autowired
    public StudentController(StudentSevice studentSevice) {
        this.studentSevice = studentSevice;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentSevice.getStudents() ;
    }
    @PostMapping
    public void registerNewStudent(@RequestBody Student student){
        studentSevice.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentSevice.deleteStudent(studentId);
    }

    @PutMapping(path ="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentSevice.updateStudent(studentId, name, email);
    }


}
