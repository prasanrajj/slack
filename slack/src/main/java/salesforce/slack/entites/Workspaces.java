package salesforce.slack.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "workspaces")
public class Workspaces {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workspace_id")
    private int workspace_id;

    @Column(name = "workspace_name")
    private String workspace_name;

    @Column(name = "workspace_description")
    private String workspace_description;

    @Column(name = "created_by")
    private int created_by;

    //users
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "created_by", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Users user;

    //workspace_accesses
    @OneToMany(mappedBy = "workspaces")
    private List<Workspace_access> workspace_accesses;

    public int getWorkspace_id() {
        return workspace_id;
    }

    public void setWorkspace_id(int workspace_id) {
        this.workspace_id = workspace_id;
    }

    public String getWorkspace_name() {
        return workspace_name;
    }

    public void setWorkspace_name(String workspace_name) {
        this.workspace_name = workspace_name;
    }

    public String getWorkspace_description() {
        return workspace_description;
    }

    public void setWorkspace_description(String workspace_description) {
        this.workspace_description = workspace_description;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
        this.created_by = created_by;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Workspace_access> getWorkspace_accesses() {
        return workspace_accesses;
    }

    public void setWorkspace_accesses(List<Workspace_access> workspace_accesses) {
        this.workspace_accesses = workspace_accesses;
    }
}
