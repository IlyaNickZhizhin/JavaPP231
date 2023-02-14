package PP.dao;

import PP.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO{

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public List<User> getAllUsers() {
        return factory.createEntityManager().createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        factory.createEntityManager().merge(user);
    }

    @Override
    public User getUser(int id) {
        return factory.createEntityManager().find(User.class, id);
    }

    @Override
    public void deleteUser(int id) {
        Query query = factory.createEntityManager().createQuery("delete from User where id = :userId");
        query.setParameter("userId", id);
        query.executeUpdate();
    }
}
