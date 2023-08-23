package salesforce.slack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import salesforce.slack.entites.Workspace_access;

public interface WorkspaceAccessRepository extends JpaRepository<Workspace_access,Integer> {

}
