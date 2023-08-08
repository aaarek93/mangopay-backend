package org.example.db.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@Entity(name = "ideas")
@Table(name = "ideas")
public class IdeaEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -1415338912521998095L;

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false)
    private String ideaId;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String shortDescription;

    @Column(nullable = false)
    private String details;

}
