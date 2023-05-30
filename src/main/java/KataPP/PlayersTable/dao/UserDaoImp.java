package KataPP.PlayersTable.dao;


import KataPP.PlayersTable.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public class UserDaoImp implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    @Override
    public User findUserById(long id) {
        return entityManager.find(User.class, id);
    }
    @Override
    public void deleteUser(User user) {
        entityManager.remove(user);
        entityManager.flush();
    }
    @Override
    public void deleteUser(long id) {
        User user = findUserById(id);
        entityManager.remove(user);
        entityManager.flush();
    }

    @Override
    public void modifyUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public List<User> getUsersList() {
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }
}
