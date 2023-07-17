package ru.hogwarts.school.mapper;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.FacultyDtoIn;
import ru.hogwarts.school.dto.FacultyDto;
import ru.hogwarts.school.entities.Faculty;

@Component
public class FacultyMapper {

    public FacultyDto toDto(Faculty faculty) {
        FacultyDto facultyDto = new FacultyDto();
        facultyDto.setId(faculty.getId());
        facultyDto.setName(faculty.getName());
        facultyDto.setColor(faculty.getColor());
        return facultyDto;
    }

    public Faculty toEntity(FacultyDtoIn facultyDtoIn) {
        Faculty faculty = new Faculty();
        faculty.setColor(facultyDtoIn.getColor());
        faculty.setName(facultyDtoIn.getName());
        return faculty;
    }

}
