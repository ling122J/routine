<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user/find" method="get">
    <center>
        <table border="2">
            请输入您的邮箱:<input type="text" name="email">
            <input type="submit" value="提交信息">
        </table>
    </center>

</form>
</body>
</html>
