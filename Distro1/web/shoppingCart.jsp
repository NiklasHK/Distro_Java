<%-- 
    Document   : shoppingCart
    Created on : 2020-okt-01, 15:26:43
    Author     : Emil
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="db.ItemDB"%>
<%@page import="java.util.Iterator"%>
<%@page import="bo.ItemHandler"%>
<%@page import="java.util.Collection"%>
<%@page import="ui.ItemInfo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ShoppingCart</title>
    </head>
    <body>
        Logged in as: <%= session.getAttribute("username") %> 
        <form action="index.jsp" >
            <input type="submit" name="logout" value="Log out" ></input>
        </form>
        <h1>Shopping cart</h1>
        <table>
            <tr>
                <%  ArrayList<Integer> quantity = ItemHandler.getBasket(String.valueOf(session.getAttribute("username")));
                    ArrayList<ItemInfo> items = (ArrayList) ItemHandler.getItemsWithGroup();
                    for (int i = 0; i<quantity.size();i++) { %>
                    <tr>
                        <%if(quantity.get(i)>0){ %>
                        <%= items.get(i).getName() + " x" + quantity.get(i) %>
                        <form action="shoppingCart.jsp" >
                            <input type="hidden" id="remove" name="remove" value="<%= items.get(i).getName() %>"</input>
                            <input type="submit" id="remove" value="-" ></input>
                        </form>
                    </tr> 
                    <br>
                <% }} %>
            </tr>
        </table>
        
        <form action="items.jsp" >
            <input type="submit" name="bipbop" value="back to shop"></input>
        </form>
            
            
         <% if(request.getParameter("remove") != null ){
               ItemHandler.removeFromBasket(request.getParameter("remove"), String.valueOf(session.getAttribute("username")));
               response.sendRedirect(request.getContextPath()+"/shoppingCart.jsp");
            } 
        %>   
            
    </body>
</html>
