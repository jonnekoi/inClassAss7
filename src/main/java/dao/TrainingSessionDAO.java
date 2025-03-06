package dao;



import model.TrainingSession;
import jakarta.persistence.EntityManager;

import java.util.List;

public class TrainingSessionDAO extends GenericDAO<TrainingSession> {
    public TrainingSessionDAO(EntityManager entityManager) {
        super(TrainingSession.class, entityManager);
    }

    public void saveTrainingSession(TrainingSession session) {
        super.save(session);
    }

    public void getTrainingSessionsByLocation(String location) {
        List<TrainingSession> sessions = entityManager.createQuery("SELECT ts FROM TrainingSession ts WHERE ts.location = :location", TrainingSession.class)
                .setParameter("location", location)
                .getResultList();
        sessions.forEach(s -> System.out.println("Location: " + s.getLocation() + " Session ID: " + s.getId() + " Session Date: " + s.getDate() + " Session Duration: " + s.getDuration()));
    }


    public void getSessionById (Long id) {
        TrainingSession session = entityManager.find(TrainingSession.class, id);
        System.out.println("Session ID: " + session.getId());
        System.out.println("Session Date: " + session.getDate());
        System.out.println("Session Location: " + session.getLocation());
        System.out.println("Session Duration: " + session.getDuration());
    }
}
