package team.of.six.firstwebapp.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;
import team.of.six.firstwebapp.dto.TextAddDto;
import team.of.six.firstwebapp.dto.TextDto;
import team.of.six.firstwebapp.entity.Text;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TextMapper
{
  TextDto toDto(Text text);
  Text toEntity(TextDto text);
  List<TextDto> toDtos(List<Text> textList);

  @Mapping(target = "id", ignore = true)
  Text toEntity(TextAddDto textDto);
}
