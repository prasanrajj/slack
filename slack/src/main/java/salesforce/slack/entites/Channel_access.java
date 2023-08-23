package salesforce.slack.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "channel_access")
public class Channel_access {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_access_id")
    private int channel_access_id;

    @Column(name= "channel_id")
    private int channel_id;

    @Column(name = "user_id")
    private int user_id;

    //workspace_access
    @ManyToOne
    @JoinColumn(name= "user_id",referencedColumnName = "workspace_access_id",insertable = false,updatable = false)
    private Workspace_access workspaceAccess;

    //channels
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "channel_id", insertable = false, updatable = false)
    private Channels channel;

    //users
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    private Users user;

    //messages
    @OneToMany(mappedBy = "channel_access")
    private List<Messages>messages;

    public int getChannel_access_id() {
        return channel_access_id;
    }

    public void setChannel_access_id(int channel_access_id) {
        this.channel_access_id = channel_access_id;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public Workspace_access getWorkspaceAccess() {
        return workspaceAccess;
    }

    public void setWorkspaceAccess(Workspace_access workspaceAccess) {
        this.workspaceAccess = workspaceAccess;
    }

    public Channels getChannel() {
        return channel;
    }

    public void setChannel(Channels channel) {
        this.channel = channel;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
}
