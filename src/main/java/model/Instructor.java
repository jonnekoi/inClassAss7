package model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "instructors")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialization;
    private int experienceYears;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.ALL)
    private List<TrainingSession> trainingSessions;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Instructor() {}

    public Instructor(String name, String specialization, int experienceYears) {
        this.name = name;
        this.specialization = specialization;
        this.experienceYears = experienceYears;
    }


    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = createdAt;
    }


    public String getName() {
        return name;
    }

    public Object getSpecialization() {
        return specialization;
    }

    // Getters and Setters
}
