package KataPP.PlayersTable.dao;


import KataPP.PlayersTable.model.User;
import java.util.List;


public interface UserDao {

    void addUser(User user);
    void deleteUser(User user);
    void deleteUser(long id);
    void modifyUser(User user);
    User findUserById(long id);
    List<User> getUsersList();
}
