package dao;

import jakarta.persistence.OptimisticLockException;
import model.Student;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;

public class StudentDAO extends GenericDAO<Student> {
    public StudentDAO(EntityManager entityManager) {
        super(Student.class, entityManager);
    }

    @Override
    public void save(Student student) {
        try {
            super.save(student);
        } catch (OptimisticLockException e) {
            System.err.println("Concurrent modification detected for student ID: " + student.getId());
        }
    }



    public void getThreeMonthStudents() {
        entityManager.createQuery("SELECT s FROM Student s WHERE s.createdAt <= :threeMonthsAgo", Student.class)
                .setParameter("threeMonthsAgo", LocalDateTime.now().minusMonths(3))
                .getResultList()
                .forEach(s -> System.out.println(s.getName() + " has been a member for at least 3 months"));
    }

    public void joinedLastSixMonths() {
        entityManager.createQuery("SELECT s FROM Student s WHERE s.createdAt >= :sixMonthsAgo", Student.class)
                .setParameter("sixMonthsAgo", LocalDateTime.now().minusMonths(6))
                .getResultList()
                .forEach(s -> System.out.println(s.getName() + " joined in the last 6 months"));
    }
}
