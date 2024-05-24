package ma.formations.jpa.tp8_jpa.dao;

import java.util.List;
import ma.formations.jpa.tp8_jpa.service.model.User;
public interface IDao {
    User findById(Long id);
    void delete(Long id);
    List<User> findAllUsers();
    User getUserByUsername(String username);
    void save(User user);
    void deleteAll();
    void update(User user);
}