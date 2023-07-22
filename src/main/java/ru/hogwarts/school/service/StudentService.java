package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.dto.FacultyDto;
import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.dto.StudentDtoIn;

import java.util.List;

public interface StudentService {

    StudentDto addStudent (StudentDtoIn studentDtoIn);
    StudentDto findStudent(long id);
    StudentDto editStudent(long id, StudentDtoIn studentDtoIn);
    StudentDto deleteStudent(long id);

    List<StudentDto> findAll(Integer age);

    List<StudentDto> findByAgeBetween(int ageFrom, int ageTo);

    FacultyDto findFaculty(long id);

    StudentDto uploadAvatar(long id, MultipartFile multipartFile);
}
