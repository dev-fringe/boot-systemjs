package dev.fringe.domain;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by v.hdlee on 2016-08-16.
 */
@Entity
public class Message {
    @Id
    private long id = System.currentTimeMillis();

    @Basic
    private String message;

    public Message(String message) {
        this.message = message;
    }

    @Basic
    private Date created = new Date();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Message() {
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", created=" + created +
                '}';
    }
}
