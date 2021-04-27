<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<html>
<head>
    <title>員工管理系統</title>
</head>
<body>
<h1 align="center">員工管理系統</h1>
<div style="margin: 25px;">
    <h3>歡迎來到員工管理系統~~請輸入帳號密碼登入系統~~</h3>
    <form action="${pageContext.request.contextPath}/Sean/signIn" method="post">
        帳號：<input type="text" name="ACCOUNT_NO"><br>
        密碼：<input type="password" name="PASSWORD"><br>
        <p><input type="submit" name="submit" value="登入"> <input type="reset" name="reset" value="重填"></p>
    </form>
</div>
</body>
</html>
