package salesforce.slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesforce.slack.entites.Channels;

public interface ChannelsRepository  extends JpaRepository<Channels,Integer> {

}
