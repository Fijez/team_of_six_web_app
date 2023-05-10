package team.of.six.firstwebapp.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import liquibase.change.core.CreateProcedureChange;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import team.of.six.firstwebapp.dto.CommentDto;
import team.of.six.firstwebapp.service.CommentService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController
{

  private final CommentService commentService;
  @PostMapping("")
  public ResponseEntity<?> postComment(CommentDto comment){

    return ResponseEntity.ok(commentService.add(comment));
  }

  @Parameter(
      name = "pageIndex", description = "Номер страницы. Нумерация начинается с 1. Значение по умолчанию 1",
      in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "1")
  )
  @Parameter(
      name = "pageSize", description = "Количество строк на странице. Значение по умолчанию 10",
      in = ParameterIn.QUERY, schema = @Schema(type = "integer", defaultValue = "10")
  )
  @GetMapping("")
  public ResponseEntity<Page<CommentDto>> getComment(
      @RequestParam(required = false) Long pageSize,
      @RequestParam(required = false) Long pageIndex){

    return ResponseEntity.ok(commentService.getComments(pageSize, pageIndex));
  }
}
