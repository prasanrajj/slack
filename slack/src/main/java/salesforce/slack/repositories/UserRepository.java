package salesforce.slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesforce.slack.entites.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}
