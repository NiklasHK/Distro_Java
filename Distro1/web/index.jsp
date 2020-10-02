<%-- 
    Document   : index
    Created on : 2020-sep-30, 15:24:17
    Author     : Emil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1> user:  <%= session.getAttribute("username") %>
        </h1> 
        <% ShoppingCart sc = new ShoppingCart(); sc.remove(); %>
         <form action="items.jsp">
            <button name="action" value="items">press me you fruit!</button>
        </form>
    </body>
</html>
