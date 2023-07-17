package ru.hogwarts.school.service;

import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.dto.StudentDtoIn;

import java.util.List;

public interface StudentService {

    StudentDto addStudent (StudentDtoIn studentDtoIn);
    StudentDto findStudent(long id);
    StudentDto editStudent(long id, StudentDtoIn studentDtoIn);
    StudentDto deleteStudent(long id);

    List<StudentDto> findAll(Integer age);
}
