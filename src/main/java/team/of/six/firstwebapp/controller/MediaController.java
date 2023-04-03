package team.of.six.firstwebapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/media")
public class MediaController
{
  @GetMapping("/image/{id}")
  public ResponseEntity<?> image(@PathVariable String id){
    return null;
  }

  @GetMapping("/image/all")
  public ResponseEntity<?> allImagesId(){
    return null;
  }

}
