<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="login-box" class="container">
                <div class="panel-heading">
                    <h3 class="panel-title">Entrance</h3>
                </div>
                <div class="panel-body">
                    <form accept-charset="UTF-8" role="form" id='loginForm' name='loginForm'
                          action="<c:url value='/j_spring_security_check' />" method='POST'>
                        <fieldset>
                            <div class="form-group <c:if test="${not empty error}">has-error</c:if>">
                                <input class="form-control" placeholder="Login" name="username" type="text"
                                       required="" autofocus="">
                            </div>
                            <div class="form-group <c:if test="${not empty error}">has-error</c:if>">
                                <input class="form-control" placeholder="Password" name="password" type="password"
                                       value="" required="">
                            </div>
                            <button type="submit" class="btn btn-success btn-block">Enter</button>
                            <button type="reset" class="btn btn-default btn-block">Clean</button>
                        </fieldset>
                    </form>
                </div>
</div>
</body>
</html>
