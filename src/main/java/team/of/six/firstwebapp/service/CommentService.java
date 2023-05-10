package team.of.six.firstwebapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import team.of.six.firstwebapp.dto.CommentDto;
import team.of.six.firstwebapp.entity.Comment;
import team.of.six.firstwebapp.entity.Users;
import team.of.six.firstwebapp.mappers.CommentMapper;
import team.of.six.firstwebapp.repository.CommentRepository;
import team.of.six.firstwebapp.repository.UserRepository;
import team.of.six.firstwebapp.utils.PageableUtils;

@Component
@RequiredArgsConstructor
public class CommentService implements PageableUtils
{

  private final CommentRepository commentRepository;
  private final CommentMapper commentMapper;
  private final UserRepository userRepository;

  public Page<CommentDto> getComments(Long pageSize, Long pageIndex)
  {
    Pageable pageableWithSortById = this.getPageableWithSortById(pageSize, pageIndex);
    return commentRepository.findAll(pageableWithSortById).map(commentMapper::toDto);
  }

  public CommentDto add(CommentDto comment)
  {
    Comment comment1 = commentMapper.toEntity(comment);
    Users byEmail = userRepository.findByEmail(comment.getUserName());
    if (byEmail == null){
      byEmail = userRepository.save(Users.builder()
              .name(comment.getUserName())
              .email(comment.getUserMail())
          .build());
    }
    comment1.setUsers(byEmail);
    return commentMapper.toDto(commentRepository.save(comment1));
  }
}
