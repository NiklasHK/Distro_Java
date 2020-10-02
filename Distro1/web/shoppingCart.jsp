<%-- 
    Document   : shoppingCart
    Created on : 2020-okt-01, 15:26:43
    Author     : Emil
--%>

<%@page import="bo.ShoppingCart"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping cart</h1>
        <table>
            <%= session.getAttribute("ShoppingCart") %>
        </table>

    </body>
</html>
