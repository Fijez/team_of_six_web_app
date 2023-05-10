package team.of.six.firstwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import team.of.six.firstwebapp.entity.Users;

public interface UserRepository extends JpaRepository<Users, Long>
{

  boolean existsByEmail(String email);

  boolean existsByName(String name);

  Users findByEmail(String email);
}