package service;

import database.HibernateUtil;
import entity.Client;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ClientCrudService {
    @Getter
    private final SessionFactory sessions = HibernateUtil.getInstance().getSessionFactory();

    public void create (String name) {
        Session session = sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Client newClient = new Client();
            newClient.setName(name);
            session.persist(newClient);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public Client getById(long id){
        Session session = sessions.openSession();
            Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    public void delete(long id){
        Session session = sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Client removedClient = session.get(Client.class, id);
            session.remove(removedClient);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void update(long id, String name){
        Session session = sessions.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            Client renewClient = session.get(Client.class, id);
            renewClient.setName(name);
            session.persist(renewClient);
            transaction.commit();
        }catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public List<Client> getAllClients() {
        Session session = sessions.openSession();
            List<Client> clientList = session.createQuery("from entity.Client", Client.class).list();
        session.close();
        return clientList;
    }
}
