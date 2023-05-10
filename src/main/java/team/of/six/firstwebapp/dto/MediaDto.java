package team.of.six.firstwebapp.dto;

import io.swagger.v3.oas.annotations.media.Content;
import lombok.Data;

import java.sql.Blob;

@Data
public class MediaDto
{
  private Long id;
  private String name;
  private Blob value;
}
