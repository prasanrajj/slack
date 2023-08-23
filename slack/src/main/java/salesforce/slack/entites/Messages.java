package salesforce.slack.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CollectionIdMutability;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int message_id;

    @Column(name = "content")
    private String content;

    @Column(name = "channel_id")
    private int channel_id;

    @Column(name =  "timestamp")
    private LocalDateTime timestamp;

    @Column(name= "channel_access_id")
    private int channel_access_id;

    //channels
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "channel_id", insertable = false, updatable = false)
    private Channels channel;

    //channel_access
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "channel_access_id", insertable = false, updatable = false)
    private Channel_access channel_access;

    //threads
    @OneToMany(mappedBy = "message")
    private List<Threads>threads;

    @OneToMany(mappedBy = "replyMessage")
    private List<Threads>threadss;


    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getChannel_access_id() {
        return channel_access_id;
    }

    public void setChannel_access_id(int channel_access_id) {
        this.channel_access_id = channel_access_id;
    }

    public Channels getChannel() {
        return channel;
    }

    public void setChannel(Channels channel) {
        this.channel = channel;
    }

    public Channel_access getChannel_access() {
        return channel_access;
    }

    public void setChannel_access(Channel_access channel_access) {
        this.channel_access = channel_access;
    }

    public List<Threads> getThreads() {
        return threads;
    }

    public void setThreads(List<Threads> threads) {
        this.threads = threads;
    }

    public List<Threads> getThreadss() {
        return threadss;
    }

    public void setThreadss(List<Threads> threadss) {
        this.threadss = threadss;
    }
}
