package team.of.six.firstwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.of.six.firstwebapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long>
{

}