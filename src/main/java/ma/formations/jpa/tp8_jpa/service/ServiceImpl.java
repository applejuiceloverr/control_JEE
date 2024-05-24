package ma.formations.jpa.tp8_jpa.service;

import java.util.List;
import ma.formations.jpa.tp8_jpa.dao.DaoImplJPA;
import ma.formations.jpa.tp8_jpa.dao.IDao;
import ma.formations.jpa.tp8_jpa.dao.article.ArticleDaoImplJPA;
import ma.formations.jpa.tp8_jpa.dao.article.IArticleDao;
import ma.formations.jpa.tp8_jpa.service.model.Article;
import ma.formations.jpa.tp8_jpa.service.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class ServiceImpl implements IService {
    private IDao dao = new DaoImplJPA();
    private IArticleDao daoArticle = new ArticleDaoImplJPA();
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Boolean checkAccount(String username, String password) {
        User u = dao.getUserByUsername(username);
        if (u == null)
            return false;
        return passwordEncoder.matches(password, u.getPassword());
    }

    @Override
    public List<Article> getAllArticle() {
        return daoArticle.findAll();
    }

    @Override
    public User createUser(User user) {
        dao.save(user);
        return user;
    }

    @Override
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
    @Override
    public void changePassword(String username, String newPassword) {
        User user = dao.getUserByUsername(username);
        if (user != null) {
            user.setPassword(passwordEncoder.encode(newPassword));
            dao.update(user);
        }
    }
}
