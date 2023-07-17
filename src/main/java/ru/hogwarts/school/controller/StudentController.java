package ru.hogwarts.school.controller;


import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.dto.StudentDtoIn;
import ru.hogwarts.school.service.StudentService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public StudentDto create(@RequestBody StudentDtoIn studentDtoIn) {
        return studentService.addStudent(studentDtoIn);
    }

    @PutMapping("/{id}")
    public StudentDto update(@PathVariable("id") long id, @RequestBody StudentDtoIn studentDtoIn) {
        return studentService.editStudent(id, studentDtoIn);
    }

    @GetMapping("/{id}")
    public StudentDto get(@PathVariable("id") long id) {
        return studentService.findStudent(id);
    }

    @DeleteMapping("/{id}")
    public StudentDto delete(@PathVariable("id") long id) {
        return studentService.deleteStudent(id);
    }

    @GetMapping
    public List<StudentDto> findAll(@RequestParam(required = false) Integer age) {
        return studentService.findAll(age);
    }

}
