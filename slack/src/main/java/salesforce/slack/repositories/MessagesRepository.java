package salesforce.slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesforce.slack.entites.Messages;

public interface MessagesRepository  extends JpaRepository<Messages,Integer> {
}
