<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>員工管理系統</title>
</head>
<body>
<h1 align="center">員工管理系統</h1>
<div style="margin: 25px;">
    <h2>刪除資料</h2>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/Sean/goToQuery" method="post">
                    <input type="submit" name="submit" value="前往查詢資料"></form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/Sean/goToAdd" method="post">
                    <input type="submit" name="submit" value="前往新增資料"></form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/Sean/goToEdit" method="post">
                    <input type="submit" name="submit" value="前往修改資料"></form>
            </td>
        </tr>
    </table>
    <br>
    <table>
    <form action="${pageContext.request.contextPath}/Sean/deleteData" method="post" >
        <tr>
            <td>員工編號：<label style="color: red">*</label></td>
            <td><input type="text" name="EMP_NO" size="10" maxlength="10"></td>
            <td>請輸入員工編號，刪除該員工資料</td>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="刪除"></td>
            <td><input type="reset" name="reset" value="重填"></td>
        </tr>
    </form>
    </table>
</div>
</body>
</html>
