package spring.dao;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import spring.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;



    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public User getUserById(Long id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    public List<User> getUserByLoginPassword(String login, String password) {
        return null;
    }


    @SuppressWarnings("unchecked")
    @Override
    public List<User> getAllUser(){
        return sessionFactory.getCurrentSession().createQuery("FROM User").list();
    }


    @Override
    public User updateUser(User user) {
        sessionFactory.getCurrentSession().update(user);
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        User user = sessionFactory.getCurrentSession().load(
                User.class, id);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }

    public void addUser(User user) {
        sessionFactory.getCurrentSession().saveOrUpdate(user);

    }
}
