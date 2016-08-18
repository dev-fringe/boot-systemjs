package dev.fringe.domain;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;
import java.util.UUID;

/**
 * Created by v.hdlee on 2016-08-16.
 */
@Entity
@Data
public class Message {
    @Id
    private long id = System.currentTimeMillis();
    private String uuid;
    private String message;
    private String author;
    private String target;
    private Date created = new Date();

    public Message() {
        super();
    }

    public Message(String message) {
        this();
        this.message = message;
        this.uuid = UUID.randomUUID().toString();
        this.author = "anonymous";
        this.target = "blank";
    }
}
