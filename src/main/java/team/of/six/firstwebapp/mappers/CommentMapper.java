package team.of.six.firstwebapp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import team.of.six.firstwebapp.dto.CommentDto;
import team.of.six.firstwebapp.entity.Comment;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper
{

  @Mapping(target = "userName", source = "comment.users.name")
  @Mapping(target = "userMail", source = "comment.users.email")
  CommentDto toDto(Comment comment);

  @Mapping(target = "users", ignore = true)
  @Mapping(target = "id", ignore = true)
  Comment toEntity(CommentDto comment);
}
