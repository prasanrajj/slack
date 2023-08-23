package salesforce.slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesforce.slack.entites.Workspaces;

public interface WorkspacesRepository extends JpaRepository<Workspaces,Integer> {
}
