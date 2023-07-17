package ru.hogwarts.school.service;

import ru.hogwarts.school.dto.FacultyDto;
import ru.hogwarts.school.dto.FacultyDtoIn;
import ru.hogwarts.school.entities.Faculty;

import java.util.List;

public interface FacultyService {

    Faculty addFaculty (FacultyDtoIn facultyDtoIn);
    Faculty findFaculty (long id);
    Faculty editFaculty (long id, FacultyDtoIn facultyDtoIn);
    FacultyDto deleteFaculty(long id);


    List<FacultyDto> findAll(String color);
}
