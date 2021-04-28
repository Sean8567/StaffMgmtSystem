<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>員工管理系統</title>

</head>
<body>
<h1 align="center">員工管理系統</h1>
<div style="margin: 25px;">
    <h2>刪除結果</h2>
    <p>
        <input type="button" onclick="JavaScript :history.back(1);" value="返回刪除資料">
    <form action="${pageContext.request.contextPath}/Sean/goToQuery" method="post">
        <input type="submit" name="submit" value="前往查詢資料"></form>
    </p>


    <h3>刪除資料成功!!!</h3>
    <br>

</div>
</body>
</html>
