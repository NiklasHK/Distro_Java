<%@page import="bo.ShoppingCartHandler"%>
<%@page import="bo.ShoppingCart"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="ui.ItemInfo"%>
<%@page import="bo.ItemHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Title</title>
    </head>
    <body>
       <% ShoppingCart sc = new ShoppingCart(); %>
        <table style="align-content: flex-start">
            <tr>
            <% Collection<ItemInfo> items = ItemHandler.getItemsWithGroup("SELECT * FROM fruitstock");
            Iterator<ItemInfo> it = items.iterator();
            for (; it.hasNext();) {
                ItemInfo item = it.next();%>
                <tr> 
                    <%= item.getName()%> :
                    <%= item.getDescription()%> 
                    <% out.print(item.getName());
                        %>
                    <form action="items.jsp" >
                        <input type="submit" name="add" value="<%= item.getName()%>" ></input>
                    </form>
                </tr>
            <br>
            <% }%>
            </tr>
            <form action="shoppingCart.jsp" >
                <input type="submit" name="bipbop" value="Show Cart"></input>
            </form>
        </table>

            <% if(request.getParameter("add") != null ){
               out.println(request.getParameter("add"));
               sc = ShoppingCartHandler.addItemToShoppingCart("Select * from fruitstock where name='"+request.getParameter("add")+"';");
               ShoppingCartHandler.updateDBShoppingCart("UPDATE shoppingcart SET " + request.getParameter("add") + "quantity = " + request.getParameter("add") + "quantity +1 WHERE username='"+ session.getAttribute("username")+"'");
               out.println("Cart: " + "UPDATE shoppingcart SET " + request.getParameter("add") + "quantity = " + request.getParameter("add") + "quantity +1 WHERE username='"+ session.getAttribute("username")+"'");
               session.setAttribute("ShoppingCart", sc);
               session.getAttribute("ShoppingCart");
            } 
            %>     
    </body>
    

</html>

