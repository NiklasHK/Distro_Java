
<%@page import="bo.userHandler"%>
<%@page import="db.userDB"%>
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
        <h1> Login </h1>
        <%
            String username = request.getParameter("uname");
            String password = request.getParameter("pass");
            if (password != null && username != null) {
                if(userHandler.checkUser("Select * from users where username='" + request.getParameter("uname") + "';")){
                    if(userHandler.checkUser("Select * from users where username='" + request.getParameter("uname") + "' and password='" + request.getParameter("pass") +"';")){
                        session.setAttribute("username", username); 
                        response.sendRedirect(request.getContextPath()+"/items.jsp");
                    } else {
                    %>
                        <form method="post" action ="index.jsp">
                            <tbody>
                            <table>
                                <tr>
                                    <td>User Name: <input type="text" name="uname" value ="" /></td>
                                </tr>
                                <tr>
                                    <td>Password: <input type="password" name ="pass" value="" />  </td>
                                </tr>
                                <tr>
                                    <td><input type="submit" name="Login" value ="Login" /></td>
                                </tr>
                                </table>
                            </tbody>
                        </form>
            <%      out.print("Wrong pass jao");
                    }
                }    
            %>
        
        <% } else { %>
        <form method="post" action ="index.jsp">
                <tbody>
                <table>
                    <tr>
                        <td>User Name: <input type="text" name="uname" value ="" /></td>
                    </tr>
                    <tr>
                        <td>Password: <input type="password" name ="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" name="Login" value ="Login" /></td>
                    </tr>
                    </table>
                </tbody>
        </form>
        <% 
            }
        %>
        
        <%
            if(request.getParameter("Login") != null && !userDB.checkUser("Select * from users where username='" + request.getParameter("uname") +"';"))
            {
                userHandler.createNewUser(("Insert into users (username, password) values('" + request.getParameter("uname") + "', '" + request.getParameter("pass") + "')"), request.getParameter("uname"));
                session.setAttribute("username", username);
                response.sendRedirect(request.getContextPath()+"/items.jsp");
            }
            %>

    </body>
</html>