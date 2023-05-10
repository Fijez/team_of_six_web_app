package team.of.six.firstwebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import team.of.six.firstwebapp.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>
{

}