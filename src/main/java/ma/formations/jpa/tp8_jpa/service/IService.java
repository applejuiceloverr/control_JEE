package ma.formations.jpa.tp8_jpa.service;

import java.util.List;
import ma.formations.jpa.tp8_jpa.service.model.Article;
import ma.formations.jpa.tp8_jpa.service.model.User;
public interface IService {
    Boolean checkAccount(String username,String password);
    List<Article> getAllArticle();
    User createUser(User user);
    String encodePassword(String password);
    void changePassword(String username, String newPassword);
}