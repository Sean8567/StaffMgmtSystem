<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>員工管理系統</title>
    <style>
        th, tr, td, table {
            border: 1px solid black;
        }
    </style>
</head>
<body>
<h1 align="center">員工管理系統</h1>
<div style="margin: 25px;">
    <h2>查詢結果</h2>
    <br>
    <div><input type="button" onclick="JavaScript :history.back(1);" value="返回查詢"></div>
    <br>
    <table>
        <tr>
            <td>EMP_NO</td>
            <td>EMP_NAME</td>
            <td>ID_NUMBER</td>
            <td>SEX</td>
            <td>PHONE</td>
            <td>JOB</td>
            <td>BIRTH_DATE</td>
            <td>ENTRY_DATE</td>
            <td>DEPT_NO</td>
            <td>DEPT_NAME</td>
            <td>DEPT_PHONE</td>
        </tr>
        <c:forEach items="${resultList}" var="map">
            <tr>
                <c:forEach items="${map}" var="data">
                    <td>${data.value}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
