<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>

<html>
<head>

    <title>員工管理系統</title>
</head>
<body>

<h1 align="center">員工管理系統</h1>
<div style="margin: 25px;">
    <h3>${Emp.EMP_NAME}${Emp.JOB}您好~</h3>
    <h2>查詢資料</h2>
    <table>
        <tr>
            <td>
                <form action="${pageContext.request.contextPath}/Sean/addData" method="post">
                    <input type="submit" name="submit" value="前往新增資料"></form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/Sean/editData" method="post">
                    <input type="submit" name="submit" value="前往修改資料"></form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/Sean/deleteData" method="post">
                    <input type="submit" name="submit" value="前往刪除資料"></form>
            </td>
        </tr>
    </table>
    <br>
    <form action="${pageContext.request.contextPath}/Sean/manageInquiry" method="post">
        <table style="border: 2px black solid">
            <tr>
                <td>員工編號：</td>
                <td><input type="text" name="EMP_NO" size="10" maxlength="10"></td>
                <td>員工姓名：</td>
                <td><input type="text" name="EMP_NAME" size="10" maxlength="10" ></td>
                <td>職務：</td>
                <td><input type="text" name="JOB" size="10" maxlength="10"></td>
                <td>性別：</td>
                <td><input type="radio" name="SEX" value="男"> 男生
                    <input type="radio" name="SEX" value="女"> 女生
                </td>
            </tr>
            <tr>
                <td>身分證字號：</td>
                <td><input type="text" name="ID_NUMBER" size="10" maxlength="10"></td>
                <td>聯絡電話：</td>
                <td><input type="text" name="PHONE" size="10" maxlength="10"></td>
                <td>出生日期：</td>
                <td><input type="text" name="BIRTH_DATE" size="10" maxlength="10"> (ex.2018/06/04)</td>
                <td>入職日期：</td>
                <td><input type="text" name="ENTRY_DATE" size="10" maxlength="10"> (ex.2018/06/04)</td>
            </tr>
            <tr>
                <td>部門編號：</td>
                <td><input type="text" name="DEPT_NO" size="10" maxlength="10"></td>
                <td>部門名稱：</td>
                <td><input type="text" name="DEPT_NAME" size="10" maxlength="10"></td>
                <td>部門電話：</td>
                <td><input type="text" name="DEPT_PHONE" size="10" maxlength="10"></td>
            </tr>
            <tr>
                <td><input type="submit" name="submit" value="查詢"></td>
                <td><input type="reset" name="reset" value="重填"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
