package salesforce.slack.entites;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "channels")
public class Channels {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "channel_id")
    private int channel_id;

    @Column(name = "channel_name")
    private String channel_name;

    @Column(name = "description")
    private int description;

    @Column(name = "workspace_access_id")
    private int workspace_access_id;

    //Workspace_access
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "workspace_access_id", insertable = false, updatable = false)
    private Workspace_access workspace_access;

    //channel_access
    @OneToMany(mappedBy = "channel")
    @JsonIgnore
    private List<Channel_access> channel_accesses;

    //messages
    @OneToMany(mappedBy ="channel")
    private List<Messages>messages;


    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public String getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(String channel_name) {
        this.channel_name = channel_name;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getWorkspace_access_id() {
        return workspace_access_id;
    }

    public void setWorkspace_access_id(int workspace_access_id) {
        this.workspace_access_id = workspace_access_id;
    }

    public Workspace_access getWorkspace_access() {
        return workspace_access;
    }

    public void setWorkspace_access(Workspace_access workspace_access) {
        this.workspace_access = workspace_access;
    }

    public List<Channel_access> getChannel_accesses() {
        return channel_accesses;
    }

    public void setChannel_accesses(List<Channel_access> channel_accesses) {
        this.channel_accesses = channel_accesses;
    }

    public List<Messages> getMessages() {
        return messages;
    }

    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }
}
