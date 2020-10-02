<%-- 
    Document   : login
    Created on : Oct 1, 2020, 3:10:58 PM
    Author     : nikla
--%>

<%@page contentType="text/html;charset=UTF-8" language ='java'%>
<html>
    <head>
        <title>Login Page</title>
    </head>
    <body>
        <%
            String username = request.getParameter("uname");
            String password = request.getParameter("pass");
            if (password != null && username != null){
                session.setAttribute("username", username);
            %>
        Logged in as <%= username %>, Go to shop?
        <form method="post" action="index.jsp">
        <table>
            <tr>
                <td><input type="submit" value ="Go" /></td>
            </tr>
        </table>
         </form>
        <%  } else { %>
        <form method="post" action ="login.jsp">
                <tbody>
                <table>
                    <tr>
                        <td>User Name: <input type="text" name="uname" value ="" /></td>
                    </tr>
                    <tr>
                        <td>Password: <input type="password" name ="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value ="Login" /></td>
                    </tr>
                    </table>
                </tbody>
        </form>
        <% } %>
    </body>
</html>
