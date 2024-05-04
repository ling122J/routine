<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
    <title>注册您的信息</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user/login" method="get">
    <table align="center" border="2">
        <tr>
            <td>用户姓名</td>
            <td>
                <input type="text" name="username">
            </td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td>
                <input type="text" name="password">
            </td>
        </tr>
        <tr>
            <td>用户性别</td>
            <td>
                <input type="radio" name="sex" value="男">男
                <input type="radio" name="sex" value="女">女
            </td>
        </tr>
        <tr>
            <td>用户邮箱</td>
            <td>
                <input type="text" name="email">
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="用户注册"></td>
            <td><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
