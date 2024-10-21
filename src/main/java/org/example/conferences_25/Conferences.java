package org.example.conferences_25;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Entity
public class Conferences {
    private Long id;
    @Getter
    private String name;
    @Getter
    private Date date;
    @Getter
    private String moderatorFullName;
    @Getter
    private String speakerFullName;

    protected Conferences() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "conference [id=" + id + ", name of the conference=" + name + ", conference date=" + date +
                ", moderator's full name=" + moderatorFullName + ", speaker's full name=" + speakerFullName +"]";
    }
}
