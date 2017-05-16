package my.autosale.dao;

import my.autosale.model.*;
import my.autosale.model.characteristics.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nikol on 2/5/2017.
 */
@Repository
public class DatabaseManagerHibernate implements DatabaseManager {
    private SessionFactory sessionFactory;

    {
        sessionFactory = HibernateUtil.getSessionFactory();
    }


    @Override
    public void addNewUser(User user) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    @Override
    public User loadUser(String name) {
        return (User) getUniqueValue(String.format("from User where name='%s'", name));
    }

    @Override
    public boolean isExistUser(String name, String password) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from User where name =:name and password =:password ");
        query.setParameter("name", name);
        query.setParameter("password", password);
        User user = (User) query.uniqueResult();
        if (user != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List loadAutoMakers() {
        return getList("from Maker");
    }

    @Override
    public List loadAutoModels() {
        return getList("from Model");
    }

    @Override
    public List loadCarBodies() {
        return getList("from CarBody");
    }

    @Override
    public List loadTransmissions() {
        return getList("from Transmission");
    }

    @Override
    public List loadConditions() {
        return getList("from Condition");
    }

    @Override
    public List loadFuelType() {
        return getList("from FuelType");
    }

    @Override
    public List loadAdverts(){
        return  getList("from Advert");
    }

    @Override
    public void saveAdvert(Advert advert) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(advert);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public long receiveAdvertsCount(){
         return (Long) getUniqueValue("select count(*) from Advert");
    }

    @Override
    public List loadAdvertsByPage(int first, int last){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("From Advert");
        query.setFirstResult(first);
        query.setMaxResults(last);
        List list = query.list();
        return query.list();
    }

    @Override
    public Maker loadMaker(String maker) {
        return (Maker) getUniqueValue(String.format("from Maker where maker='%s'", maker));
    }

    @Override
    public Model loadModel(String model) {
        return (Model) getUniqueValue(String.format("from Model where model='%s'", model));
    }

    @Override
    public CarBody loadCarBody(String body) {
        return (CarBody) getUniqueValue(String.format("from CarBody where car_body='%s'", body));
    }

    @Override
    public Transmission loadTransmission(String transmission) {
        return (Transmission) getUniqueValue(String.format("from Transmission where transmission='%s'", transmission));
    }

    @Override
    public FuelType loadFuelType(String fuelType) {
        return (FuelType) getUniqueValue(String.format("from FuelType where fuel_type='%s'", fuelType));
    }

    @Override
    public Condition loadCondition(String condition) {
        return (Condition) getUniqueValue(String.format("from Condition where condition='%s'", condition));
    }

    @Override
    public Status loadStatus(String status) {
        return (Status) getUniqueValue(String.format("from Status where status='%s'", status));
    }

    @Override
    public List<Advert> loadAdvertsByPageForUser(int first, int amount, User user) {
            Session session = sessionFactory.openSession();
            Query query = session.createQuery(String.format("from Advert where users_id=%d", user.getId()));
            query.setFirstResult(first);
            query.setMaxResults(amount);
            return query.list();
    }

    @Override
    public long receiveUserAdvertCount(User user) {
        return (Long) getUniqueValue(String.format("select count(*) from Advert where users_id = %d", user.getId()));
    }

    private Object getUniqueValue(String hql) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        Object object = query.uniqueResult();
        session.close();
        return object;
    }

    private List getList(String hql) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery(hql);
        List result = query.list();
        session.close();
        return result;
    }
}
