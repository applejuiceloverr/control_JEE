<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link href="static/css/login.css" rel="stylesheet">
    <link href="webjars/bootstrap/4.6.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="webjars/bootstrap/4.6.1/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="wrapper fadeInDown">
        <div id="formContent">
            <div class="fadeIn first">
                <img src="static/images/login.jpg" id="icon" alt="User Icon" />
            </div>
            <!-- Registration Form -->
            <form action="${pageContext.request.contextPath}/register.do" method="post">
                <input type="text" id="username" class="fadeIn second" name="username" placeholder="Username" required>
                <input type="password" id="password" class="fadeIn third" name="password" placeholder="Password" required>
                <input type="submit" class="fadeIn fourth" value="Register">
            </form>
        </div>
    </div>
</div>
</body>
</html>