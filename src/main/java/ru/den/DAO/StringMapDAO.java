package ru.den.DAO;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.den.model.StringMap;
import ru.den.util.HibernateSession;

@Service
public class StringMapDAO {


    static final Session session = HibernateSession.getSessionFactory().openSession();

    public void save(StringMap stringMap){
        session.beginTransaction();
        session.save(stringMap);
        session.getTransaction().commit();
        System.out.println("Record saved StringMap");
    }
}
