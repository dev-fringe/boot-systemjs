package dev.fringe.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

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
    private String service;
    private Date created = new Date();

    public Message() {super();}
    public Message(String message) {
        this();
        this.message = message;
    }
}
