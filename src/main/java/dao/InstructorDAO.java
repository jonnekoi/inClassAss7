package dao;

import model.Instructor;
import jakarta.persistence.EntityManager;

import java.util.List;

public class InstructorDAO extends GenericDAO<Instructor> {
    public InstructorDAO(EntityManager entityManager) {
        super(Instructor.class, entityManager);
    }

    public List<Instructor> getInstructorsBySpecialization(String specialization) {
        List<Instructor> instructors = entityManager.createQuery("SELECT i FROM Instructor i WHERE i.specialization = :specialization", Instructor.class)
                .setParameter("specialization", specialization)
                .getResultList();
        return instructors;
    }

    public void getInstructorsByExperience(int experienceYears) {
        List<Instructor> instructors = entityManager.createQuery("SELECT i FROM Instructor i WHERE i.experienceYears >= :experienceYears", Instructor.class)
                .setParameter("experienceYears", experienceYears)
                .getResultList();
        instructors.forEach(i -> System.out.println(i.getName() + " has at least " + experienceYears + " years of experience"));
    }
}
