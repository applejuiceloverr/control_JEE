<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Article</title>
    <link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="common/header.jsp"%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="articles.do?action=updateArticle" method="post">
                <input type="hidden" name="id" value="${article.id}">
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" class="form-control" id="description" name="description" value="${article.description}" required>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" step="0.01" class="form-control" id="price" name="price" value="${article.price}" required>
                </div>
                <div class="form-group">
                    <label for="quantite">Quantite:</label>
                    <input type="number" class="form-control" id="quantite" name="quantite" value="${article.quantite}" required>
                </div>
                <button type="submit" class="btn btn-primary btn-block">Update Article</button>
            </form>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp"%>

</body>
</html>
