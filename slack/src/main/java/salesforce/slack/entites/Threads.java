package salesforce.slack.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "threads")
public class Threads {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="thread_id")
    private int thread_id;

    @Column(name = "message_id")
    private int message_id;

    @Column(name= "reply_id")
    private int reply_id;

    //messages
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "message_id", insertable = false, updatable = false)
    private Messages message;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "reply_id", referencedColumnName = "message_id",insertable = false, updatable = false)
    private Messages replyMessage;

    public int getThread_id() {
        return thread_id;
    }

    public void setThread_id(int thread_id) {
        this.thread_id = thread_id;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public int getReply_id() {
        return reply_id;
    }

    public void setReply_id(int reply_id) {
        this.reply_id = reply_id;
    }

    public Messages getMessage() {
        return message;
    }

    public void setMessage(Messages message) {
        this.message = message;
    }

    public Messages getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(Messages replyMessage) {
        this.replyMessage = replyMessage;
    }
}
