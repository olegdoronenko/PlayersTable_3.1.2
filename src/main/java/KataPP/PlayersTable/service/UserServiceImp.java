package KataPP.PlayersTable.service;


import KataPP.PlayersTable.dao.UserDao;
import KataPP.PlayersTable.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@Transactional
public class UserServiceImp implements UserService{

    @Autowired
    private UserDao userDao;

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }


    @Override
    public void modifyUser(User user) {
        userDao.modifyUser(user);
    }

    @Override
    public User findUserById(long id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> getUsersList() {
        return userDao.getUsersList();
    }
}
