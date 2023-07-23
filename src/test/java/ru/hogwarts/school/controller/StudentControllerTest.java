package ru.hogwarts.school.controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ru.hogwarts.school.dto.StudentDtoIn;
import ru.hogwarts.school.dto.StudentDto;
import ru.hogwarts.school.repository.StudentRepository;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class StudentControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private StudentRepository studentRepository;

    private final Faker faker = new Faker();

    @AfterEach
    public void clean() {
        studentRepository.deleteAll();
    }

    @Test
    public StudentDto addStudent() {
        StudentDtoIn studentDtoIn = generate();

        ResponseEntity<StudentDto> responseEntity = testRestTemplate.postForEntity(
                "http://localhost:" + port + "/students",
                studentDtoIn,
                StudentDto.class
        );
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        StudentDto studentDto = responseEntity.getBody();

        assertThat(studentDto).isNotNull();
        assertThat(studentDto.getId()).isNotEqualTo(0L);
        assertThat(studentDto.getAge()).isEqualTo(studentDtoIn.getAge());
        assertThat(studentDto.getName()).isEqualTo(studentDtoIn.getName());

        return studentDto;
    }

    @Test
    public void editStudent() {
        StudentDto created = addStudent();
        StudentDtoIn studentDtoIn = new StudentDtoIn();
        studentDtoIn.setName(faker.name().fullName());
        studentDtoIn.setAge(created.getAge());

        ResponseEntity<StudentDto> responseEntity = testRestTemplate.exchange(
                "http://localhost:" + port + "/students/" + created.getId(),
                HttpMethod.PUT,
                new HttpEntity<>(studentDtoIn),
                StudentDto.class
        );
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);

        StudentDto studentDto = responseEntity.getBody();

        assertThat(studentDto).isNotNull();
        assertThat(studentDto.getId()).isEqualTo(created.getId());
        assertThat(studentDto.getAge()).isEqualTo(studentDtoIn.getAge());
        assertThat(studentDto.getName()).isEqualTo(studentDtoIn.getName());

        // checking not found
        long incorrectId = created.getId() + 1;

        ResponseEntity<String> stringResponseEntity = testRestTemplate.exchange(
                "http://localhost:" + port + "/students/" + incorrectId,
                HttpMethod.PUT,
                new HttpEntity<>(studentDtoIn),
                String.class
        );
        assertThat(stringResponseEntity.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(stringResponseEntity.getBody())
                .isEqualTo("Студент с id = " + incorrectId + " не найден!");
    }

    public StudentDtoIn generate() {
        StudentDtoIn studentDtoIn = new StudentDtoIn();
        studentDtoIn.setAge(faker.random().nextInt(7, 18));
        studentDtoIn.setName(faker.name().fullName());
        return studentDtoIn;
    }

}
