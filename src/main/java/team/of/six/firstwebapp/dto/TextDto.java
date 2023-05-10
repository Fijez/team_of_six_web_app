package team.of.six.firstwebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Blob;

@Data
@AllArgsConstructor
public class TextDto
{
  private Long id;
  private String name;
  private String value;
}
