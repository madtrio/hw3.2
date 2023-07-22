package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.entities.Avatar;
import ru.hogwarts.school.entities.Student;
import ru.hogwarts.school.repository.AvatarRepository;

import java.nio.file.Path;

public interface AvatarService {

    void AvatarServiceImpl(AvatarRepository avatarRepository, String pathToAvatarDir);

    Avatar create(Student student, MultipartFile multipartFile);
    void writeToFile(Path path, byte[] data);
    byte[] read(Path path);
}
