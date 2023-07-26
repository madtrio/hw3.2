package ru.hogwarts.school.mapper;

import org.springframework.stereotype.Component;
import ru.hogwarts.school.dto.AvatarDto;
import ru.hogwarts.school.entities.Avatar;

@Component

public class AvatarMapper {
    public AvatarDto toDto(Avatar avatar) {
        AvatarDto avatarDto = new AvatarDto();
        avatarDto.setId(avatarDto.getId());
        avatarDto.setFileSize(avatar.getFileSize());
        avatarDto.setMediaType(avatar.getMediaType());
        avatarDto.setAvatarUrl("http://localhost:8080/avatars/"+ avatar.getId() + "from-db");
        return avatarDto;
    }
}
