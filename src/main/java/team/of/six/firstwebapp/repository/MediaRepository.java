package team.of.six.firstwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.of.six.firstwebapp.entity.Media;

public interface MediaRepository extends JpaRepository<Media, Long>
{

}