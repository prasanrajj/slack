package salesforce.slack.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "workspace_access")
public class Workspace_access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workspace_access_id")
    private int workspace_access_id;

    @Column(name =  "workspace_id")
    private int workspace_id;

    @Column(name = "workspace_user_id")
    private int workspace_user_id;


    //users
    @ManyToMany(mappedBy = "workspace_accesses")
    private List<Users> workspace_access_users;

    //workspaces
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "workspace_id", insertable = false, updatable = false)
    private Workspaces workspaces;

    //channels
    @OneToMany(mappedBy = "workspace_access")
    @JsonIgnore
    private List<Channels> channels;


    //Channel_access
    @OneToMany(mappedBy = "workspaceAccess")
    private List<Channel_access>channel_accesss;

    public int getWorkspace_access_id() {
        return workspace_access_id;
    }

    public void setWorkspace_access_id(int workspace_access_id) {
        this.workspace_access_id = workspace_access_id;
    }

    public int getWorkspace_id() {
        return workspace_id;
    }

    public void setWorkspace_id(int workspace_id) {
        this.workspace_id = workspace_id;
    }

    public int getWorkspace_user_id() {
        return workspace_user_id;
    }

    public void setWorkspace_user_id(int workspace_user_id) {
        this.workspace_user_id = workspace_user_id;
    }

    public List<Users> getWorkspace_access_users() {
        return workspace_access_users;
    }

    public void setWorkspace_access_users(List<Users> workspace_access_users) {
        this.workspace_access_users = workspace_access_users;
    }

    public Workspaces getWorkspaces() {
        return workspaces;
    }

    public void setWorkspaces(Workspaces workspaces) {
        this.workspaces = workspaces;
    }

    public List<Channels> getChannels() {
        return channels;
    }

    public void setChannels(List<Channels> channels) {
        this.channels = channels;
    }

    public List<Channel_access> getChannel_accesss() {
        return channel_accesss;
    }

    public void setChannel_accesss(List<Channel_access> channel_accesss) {
        this.channel_accesss = channel_accesss;
    }
}
