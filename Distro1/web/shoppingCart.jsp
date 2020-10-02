<%-- 
    Document   : shoppingCart
    Created on : 2020-okt-01, 15:26:43
    Author     : Emil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="db.ItemDB"%>
<%@page import="bo.ShoppingCartHandler"%>
<%@page import="java.util.Iterator"%>
<%@page import="bo.ItemHandler"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Collection"%>
<%@page import="ui.ItemInfo"%>
<%@page import="ui.ItemInfo"%>
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
            <%  ArrayList<Integer> quantity = ItemDB.getBasket("SELECT * FROM shoppingcart where username='" + session.getAttribute("username") + "';");
                ArrayList<ItemInfo> items = (ArrayList) ItemHandler.getItemsWithGroup("SELECT * FROM fruitstock");
            for (int i = 0; i<quantity.size();i++) {
                    out.println(quantity.get(i) + items.get(i).getName()); 
                }
            %>
            <%= session.getAttribute("ShoppingCart") %>
        </table>
        
        <form action="items.jsp" >
            <input type="submit" name="bipbop" value="back to shop"></input>
        </form>
    </body>
</html>
