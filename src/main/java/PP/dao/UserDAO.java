package PP.dao;

import PP.Model.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    void deleteUser(int id);
}
