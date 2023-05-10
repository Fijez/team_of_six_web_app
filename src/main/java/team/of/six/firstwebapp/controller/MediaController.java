package team.of.six.firstwebapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.of.six.firstwebapp.dto.MediaDto;
import team.of.six.firstwebapp.dto.TextAddDto;
import team.of.six.firstwebapp.dto.TextDto;
import team.of.six.firstwebapp.entity.Text;
import team.of.six.firstwebapp.service.MediaService;

import java.util.List;

@RestController
@RequestMapping("/media")
@RequiredArgsConstructor
public class MediaController
{

  private final MediaService mediaService;

  @GetMapping("/image/{id}")
  public ResponseEntity<?> image(@PathVariable Long id)
  {
    return ResponseEntity.ok(mediaService.getImage(id));
  }

  @GetMapping("/text/{id}")
  public ResponseEntity<TextDto> text(@PathVariable Long id)
  {
    return ResponseEntity.ok(mediaService.getText(id));
  }

  @GetMapping("/video/{id}")
  public ResponseEntity<?> video(@PathVariable Long id)
  {
    return ResponseEntity.ok(mediaService.getVideo(id));
  }

  @GetMapping("/image/all")
  public ResponseEntity<?> allImages()
  {
    return ResponseEntity.ok(mediaService.getAllImages());
  }

  @GetMapping("/text/all")
  public ResponseEntity<List<TextDto>> allTexts()
  {
    return ResponseEntity.ok(mediaService.getAllTexts());
  }

  @GetMapping("/video/all")
  public ResponseEntity<?> allVideos()
  {
    return ResponseEntity.ok(mediaService.getAllVideos());
  }

  @PostMapping("/text/add")
  public ResponseEntity<TextDto> addText(@RequestBody TextAddDto mediaDto)
  {
    return ResponseEntity.ok(mediaService.addText(mediaDto));
  }

  @PostMapping("/image/add")
  public ResponseEntity<?> addImage()
  {
    mediaService.addImage();
    return ResponseEntity.ok().build();
  }

}
