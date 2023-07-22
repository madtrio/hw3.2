package ru.hogwarts.school.controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.dto.FacultyDto;
import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.dto.StudentDtoIn;
import ru.hogwarts.school.service.StudentService;

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

    @GetMapping("/filterAge")
    public List<StudentDto> findByAgeBetween(@RequestParam int ageFrom, @RequestParam int ageTo) {
        return studentService.findByAgeBetween(ageFrom, ageFrom);
    }

    @GetMapping("/{id}/faculty")
    public FacultyDto findFaculty(@PathVariable("id") long id) {
        return studentService.findFaculty(id);
    }

    @PatchMapping(value = "/{id}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public StudentDto uploadAvatar(@PathVariable long id, @RequestPart("avatar") MultipartFile multipartFile) {
        return studentService.uploadAvatar(id, multipartFile);
    }
}
