<%@ page import="hx.entity.Users" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示用户信息</title>
</head>
<body>
    <table border="1" align="center">
        <tr>
            <th>userId</th>
            <th>userName</th>
            <th>password</th>
            <th>sex</th>
            <th>email</th>
        </tr>
        <%
            List<Users> usersList = (ArrayList<Users>)request.getAttribute("userlist");
            int size = usersList.size();
            if(size>0){
                for(Users u : usersList){
        %>
            <tr>
                <td><%=u.getUserId()%></td>
                <td><%=u.getUserName()%></td>
                <td><%=u.getPassword()%></td>
                <td><%=u.getSex()%></td>
                <td><%=u.getEmail()%></td>
            </tr>
        <%
                }
            }else{
        %>
            <h1>查询不到您的信息,请检查您的输入信息是否有误</h1>
        <%
            }
        %>
    </table>
</body>
</html>
