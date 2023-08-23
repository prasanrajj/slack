package salesforce.slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesforce.slack.entites.Threads;

public interface ThreadsRepository extends JpaRepository<Threads,Integer> {

}
