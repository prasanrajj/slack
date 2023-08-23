package salesforce.slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesforce.slack.entites.Channel_access;

public interface ChannelAccessRepository extends JpaRepository<Channel_access,Integer> {
}
