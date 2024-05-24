package ma.formations.jpa.tp8_jpa.presentation.controller;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ma.formations.jpa.tp8_jpa.service.IService;
import ma.formations.jpa.tp8_jpa.service.ServiceImpl;
import ma.formations.jpa.tp8_jpa.service.model.Article;
import ma.formations.jpa.tp8_jpa.dao.article.IArticleDao;
import ma.formations.jpa.tp8_jpa.dao.article.ArticleDaoImplJPA;

@WebServlet("/articles.do")
public class ArticleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private IArticleDao articleDao;

    @Override
    public void init() throws ServletException {
        articleDao = new ArticleDaoImplJPA();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "deleteArticle":
                deleteArticle(request, response);
                break;
            case "updateArticle":
                updateArticle(request, response);
                break;
            case "addArticle":
                addArticleForm(request, response);
                break;
            default:
                listArticles(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "default";
        }

        switch (action) {
            case "updateArticle":
                saveUpdatedArticle(request, response);
                break;
            case "addArticle":
                saveNewArticle(request, response);
                break;
            case "deleteArticle":
                deleteArticle(request, response);
                break;
            default:
                listArticles(request, response);
                break;
        }
    }
    private IService service = new ServiceImpl();
    private void listArticles(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Article> articles = service.getAllArticle();
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/view/welcome.jsp").forward(request, response);
    }

    private void deleteArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        articleDao.delete(id);
        listArticles(request, response);
    }

    private void updateArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        Article article = articleDao.findById(id);
        request.setAttribute("article", article);
        request.getRequestDispatcher("/view/updateArticle.jsp").forward(request, response);
    }

    private void addArticleForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/addArticle.jsp").forward(request, response);
    }

    private void saveUpdatedArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.valueOf(request.getParameter("id"));
        String description = request.getParameter("description");
        Double price = Double.valueOf(request.getParameter("price"));
        Double quantite = Double.valueOf(request.getParameter("quantite"));

        Article article = new Article();
        article.setId(id);
        article.setDescription(description);
        article.setPrice(price);
        article.setQuantite(quantite);

        articleDao.save(article);

        response.sendRedirect("articles.do");
    }

    private void saveNewArticle(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String description = request.getParameter("description");
        Double price = Double.valueOf(request.getParameter("price"));
        Double quantite = Double.valueOf(request.getParameter("quantite"));

        Article article = new Article();
        article.setDescription(description);
        article.setPrice(price);
        article.setQuantite(quantite);

        articleDao.save(article);

        response.sendRedirect("articles.do");
    }
}
