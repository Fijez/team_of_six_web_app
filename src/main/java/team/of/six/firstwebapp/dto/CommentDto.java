package team.of.six.firstwebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto
{
  private String userName;
  private String userMail;
  private String comment;
}
