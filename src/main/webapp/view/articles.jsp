<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="container">
    <table class="table">
        <thead class="thead-dark">
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Description</th>
            <th scope="col">Quantité</th>
            <th scope="col">Prix</th>
            <th scope="col">Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${articles}" var="article">
            <tr>
                <th scope="row">${article.id}</th>
                <td>${article.description}</td>
                <td>${article.quantite}</td>
                <td>${article.price}</td>
                <td>
                    <form action="articles.do?action=deleteArticle" method="post" style="display: inline;">
                        <input type="hidden" name="id" value="${article.id}">
                        <button type="submit" class="btn btn-danger">X</button>
                    </form>
                    <a href="articles.do?action=updateArticle&id=${article.id}">
                        <button class="btn btn-success">Modify</button>
                    </a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="articles.do?action=addArticle" class="btn btn-primary" style="margin-top: 20px;">Create Article</a>
</div>