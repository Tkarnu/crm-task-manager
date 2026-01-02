package io.github.serhiikravets.crm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Task {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String status;

    @ManyToOne
    private User user;

    @ManyToOne
    private Project project;
}
