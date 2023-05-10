package team.of.six.firstwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.of.six.firstwebapp.entity.Media;
import team.of.six.firstwebapp.entity.Text;

import java.util.List;

public interface TextRepository extends JpaRepository<Text, Long>
{

  Text findByName(String name);
}