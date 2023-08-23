package salesforce.slack.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;

    @Column(name = "user_name")
    private String user_name;

    @Column(name = "password")
    private int password;

    //Workspaces
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Workspaces> workspaces;

    //Workspace_access
    @ManyToMany
    @JoinTable(
            name = "workspace_access",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "workspace_id"))
    private List<Workspace_access> workspace_accesses;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    public List<Workspaces> getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(List<Workspaces> workspaces) {
        this.workspaces = workspaces;
    }

    public List<Workspace_access> getWorkspace_accesses() {
        return workspace_accesses;
    }

    public void setWorkspace_accesses(List<Workspace_access> workspace_accesses) {
        this.workspace_accesses = workspace_accesses;
    }
}
