package team.of.six.firstwebapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import team.of.six.firstwebapp.dto.UserDto;
import team.of.six.firstwebapp.service.UserService;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController
{

  private final UserService userService;

  @GetMapping("")
  public ResponseEntity<?> getUser(@RequestBody String email)
  {
    return ResponseEntity.ok(userService.getUser(email));
  }

  @GetMapping("/all")
  public ResponseEntity<?> getUser()
  {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @PostMapping("")
  public ResponseEntity<?> addUser(@RequestBody UserDto user)
  {
    return ResponseEntity.ok(userService.addUser(user));
  }

}
