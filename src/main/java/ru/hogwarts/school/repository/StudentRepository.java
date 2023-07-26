package ru.hogwarts.school.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByAge(int age);

    List<Student> findAllByAgeBetween(int ageFrom, int ageTo);

    List<Student> findAllByFaculty_Id(long facultyId);

}
