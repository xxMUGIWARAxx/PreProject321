package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import java.util.List;
@Repository
public class UserDaoHibernateImpl implements UserDao {
    private SessionFactory sessionFactory;

    @Autowired
    public UserDaoHibernateImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> index() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, id);
    }

    @Override
    public void save(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.remove(session.get(User.class, id));
    }
}
