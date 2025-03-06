package model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "training_sessions")
public class TrainingSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String location;
    private int duration;

    @ManyToOne
    @JoinColumn(name = "instructor_id", nullable = false)
    private Instructor instructor;

    @ManyToMany(mappedBy = "trainingSessions")  // This refers to the "trainingSessions" property in Student
    private List<Student> students;

    public TrainingSession() {

    }

    public TrainingSession(LocalDate date, String location, int duration) {
        this.date = date;
        this.location = location;
        this.duration = duration;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "TrainingSession{" +
                "id=" + id +
                ", date=" + date +
                ", location='" + location + '\'' +
                ", duration=" + duration +
                ", instructor=" + instructor +
                ", students=" + students +
                '}';
    }
}
