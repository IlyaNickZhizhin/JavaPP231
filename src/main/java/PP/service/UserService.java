package PP.service;

import PP.Model.User;

import java.util.List;


public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUSer(int id);

    public void deleteUser(int id);

}
