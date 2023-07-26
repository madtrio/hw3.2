package ru.hogwarts.school.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.hogwarts.school.dto.StudentDtoOut;
import ru.hogwarts.school.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findAllByAge(int age);

    List<Student> findAllByAgeBetween(int ageFrom, int ageTo);

    List<Student> findAllByFaculty_Id(long facultyId);

    @Query("SELECT count (s) FROM Student s")
    int getCountOfStudents();

    @Query("SELECT avg (s.age) FROM Student s")
    double getAverageAge();

@Query ("SELECT s FROM Students s ORDER BY s.id DESC")
    List<StudentDtoOut> getLastStudents(Pageable pageable);
}
