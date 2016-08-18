package dev.fringe.domain;

import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    public Customer() {super();}

    public Customer(String firstName, String lastName) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
