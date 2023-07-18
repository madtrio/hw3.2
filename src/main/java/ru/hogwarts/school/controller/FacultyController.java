package ru.hogwarts.school.controller;


import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.hogwarts.school.dto.FacultyDto;
import ru.hogwarts.school.dto.FacultyDtoIn;
import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.entities.Faculty;
import ru.hogwarts.school.service.FacultyService;


@RestController
@RequestMapping("faculty")
public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public FacultyDto create(@RequestBody FacultyDtoIn facultyDtoIn) {
        return (FacultyDto) facultyService.addFaculty(facultyDtoIn);
    }

    @PutMapping("/{id}")
    public FacultyDto update(@PathVariable("id") long id, @RequestBody FacultyDtoIn facultyDtoIn) {
        return (FacultyDto) (FacultyDto) facultyService.editFaculty(id, facultyDtoIn);
    }

    @GetMapping("/{id}")
    public Faculty get(@PathVariable("id") long id) {
        return facultyService.findFaculty(id);
    }

    @DeleteMapping("/{id}")
    public FacultyDto delete(@PathVariable("id") long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping
    public List<FacultyDto> findAll(@RequestParam(required = false) String color) {
        return facultyService.findAll(color);
    }

    @GetMapping("/filterFacult")
    public List<FacultyDto> findByColorOrName(@RequestParam String colorOrName) {
        return facultyService.findByColorOrName(colorOrName);
    }
    @GetMapping("/{id}/students")
    public List<StudentDto> findStudents(@PathVariable("id") long id) {
        return facultyService.findStudents(id);
    }

}
