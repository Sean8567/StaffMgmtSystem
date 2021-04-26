<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>員工管理系統</title>
</head>
<body>
<h1 align="center" >員工管理系統</h1>
<div style="margin: 25px;">
    <h3>登入失敗!查無此帳號，請返回重新登入!</h3>
    <form action="${pageContext.request.contextPath}/" method="post">
        <p><input type="submit" name="submit" value="返回登入"></p>
    </form>
</div>
</body>
</html>
