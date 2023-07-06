package service;

import database.HibernateUtil;
import entity.Client;
import entity.Planet;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetCrudService {
    @Getter
    private final SessionFactory sessions = HibernateUtil.getInstance().getSessionFactory();

    public void create(String id, String name) {
        Session session = sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Planet newPlanet = new Planet();
            newPlanet.setId(id);
            newPlanet.setName(name);
            session.persist(newPlanet);

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public Planet getById(String id){
        Session session = sessions.openSession();
            Planet planet = session.get(Planet.class, id);
        session.close();
        return planet;
    }

    public void delete(String id){
        Session session = sessions.openSession();
        Transaction transaction = session.beginTransaction();
            try {
                Planet removedPlanet = session.get(Planet.class, id);
                session.remove(removedPlanet);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
                e.printStackTrace();
            } finally {
            session.close();
        }
    }

    public void update(String id, String name){
        Session session = sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Planet renewPlanet = session.get(Planet.class, id);
            renewPlanet.setName(name);
            renewPlanet.setId(id);
            session.persist(renewPlanet);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Planet> getAllPlanets() {
        Session session = sessions.openSession();
            List<Planet> planetList = session.createQuery("from entity.Planet", Planet.class).list();
        session.close();
        return planetList;
    }
}
