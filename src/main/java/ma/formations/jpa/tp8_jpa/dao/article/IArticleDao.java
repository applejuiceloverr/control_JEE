package ma.formations.jpa.tp8_jpa.dao.article;
import java.util.List;
import ma.formations.jpa.tp8_jpa.service.model.Article;
public interface IArticleDao {
    Article findById(Long id);
    void delete(Long id);
    List<Article> findAll();
    void save(Article article);
    void deleteAll();
}
