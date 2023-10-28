package com.todolist.back.model;

import jakarta.persistence.*;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import com.todolist.back.model.User;
import java.util.Date;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private String description;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name="creation_date", insertable = false, updatable = false)
    @Generated(GenerationTime.INSERT)
    private Date creationDate;

    @Column(name="deadline_date")
    private Date deadlineDate;

    public enum Status {
        Done, Todo, InProgress
    }

    // Constructeur par défaut requis par JPA
    public Task() {}

    // Constructeur avec tous les champs
    public Task(User user, String title, String description, Status status, Date deadlineDate) {
        this.user = user;
        this.title = title;
        this.description = description;
        this.status = status;
        this.deadlineDate = deadlineDate;
        this.creationDate = new Date(); // Vous pouvez initialiser la date de création ici
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getDeadlineDate() {
        return deadlineDate;
    }

    // Setters
    public void setUser(User user) {
        this.user = user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setDeadlineDate(Date deadlineDate) {
        this.deadlineDate = deadlineDate;
    }
}
