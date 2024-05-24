<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Article</title>
    <link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
    <script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@include file="common/header.jsp"%>

<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <form action="articles.do?action=addArticle" method="post">
                <div class="form-group">
                    <label for="description">Description:</label>
                    <input type="text" class="form-control" id="description" name="description" required>
                </div>
                <div class="form-group">
                    <label for="price">Price:</label>
                    <input type="number" step="0.01" class="form-control" id="price" name="price" required>
                </div>
                <div class="form-group">
                    <label for="quantite">Quantite:</label>
                    <input type="number" class="form-control" id="quantite" name="quantite" required>
                </div>
                <button type="submit" class="btn btn-primary">Add Article</button>
            </form>
        </div>
    </div>
</div>

<%@include file="common/footer.jsp"%>

</body>
</html>
