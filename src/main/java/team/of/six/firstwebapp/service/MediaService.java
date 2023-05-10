package team.of.six.firstwebapp.service;

import org.springframework.stereotype.Service;
import team.of.six.firstwebapp.dto.TextAddDto;
import team.of.six.firstwebapp.dto.TextDto;
import team.of.six.firstwebapp.mappers.TextMapper;
import team.of.six.firstwebapp.repository.MediaRepository;
import team.of.six.firstwebapp.repository.TextRepository;
import team.of.six.firstwebapp.repository.UserRepository;

import java.util.List;

@Service
public class MediaService
{

  private final MediaRepository mediaRepository;
  private final TextMapper textMapper;
  private final TextRepository textRepository;
  private final UserRepository userRepository;

  public MediaService(MediaRepository mediaRepository, TextMapper textMapper, TextRepository textRepository,
      UserRepository userRepository)
  {
    this.mediaRepository = mediaRepository;
    this.textMapper = textMapper;
    this.textRepository = textRepository;
    this.userRepository = userRepository;
  }

  public void addMedia()
  {

  }

  public Object getImage(Long id)
  {
    return null;
  }

  public void getMediaVideo()
  {

  }

  public List<Object> getAllImages()
  {
    return null;
  }

  public List<TextDto> getAllTexts()
  {
    return textMapper.toDtos(textRepository.findAll());
  }

  public TextDto getText(Long id)
  {
    return textMapper.toDto(textRepository.findById(id).get());
  }

  public Object getVideo(Long id)
  {
    return null;
  }

  public List<Object> getAllVideos()
  {
    return null;
  }

  public TextDto addText(TextAddDto textDto)
  {
    return textMapper.toDto(textRepository.save(textMapper.toEntity(textDto)));
  }

  public void addImage()
  {

  }
}
