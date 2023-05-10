package team.of.six.firstwebapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import team.of.six.firstwebapp.dto.UserDto;
import team.of.six.firstwebapp.entity.Users;
import team.of.six.firstwebapp.mappers.UserMapper;
import team.of.six.firstwebapp.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService
{
  private final UserRepository userRepository;
  private final UserMapper userMapper;

  public Users addUser(UserDto user){
    return userRepository.save(userMapper.toEntity(user));
  }

  public UserDto getUser(String email)
  {
    return userMapper.toDto(userRepository.findByEmail(email));
  }

  public List<UserDto> getAllUsers()
  {
    return userMapper.toDtos(userRepository.findAll());
  }
}
