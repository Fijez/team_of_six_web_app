package team.of.six.firstwebapp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import team.of.six.firstwebapp.dto.UserDto;
import team.of.six.firstwebapp.entity.Users;

import java.util.List;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper
{
  UserDto toDto(Users users);
  List<UserDto> toDtos(List<Users> users);

  @Mapping(target = "id", ignore = true)
  Users toEntity(UserDto user);
}
