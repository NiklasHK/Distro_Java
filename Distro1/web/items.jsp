<%@page import="db.ItemDB"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Iterator"%>
<%@page import="ui.ItemInfo"%>
<%@page import="bo.ItemHandler"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items</title>
    </head>
    <body>
        Logged in as: <%= session.getAttribute("username") %> 
        <form action="index.jsp" >
            <input type="submit" name="logout" value="Log out" ></input>
        </form>
        <br>
        <h1> Items in stock </h1>
        <table style="align-content: flex-start">
            <tr>
            <% Collection<ItemInfo> items = ItemHandler.getItemsWithGroup("SELECT * FROM fruitstock");
            Iterator<ItemInfo> it = items.iterator();
            for (; it.hasNext();) {
                ItemInfo item = it.next();%>
                <tr> 
                    <%= item.getName() %> :
                    <%= item.getDescription() %> 
                    <form action="items.jsp" >
                        <input type="hidden" id="add" name="add" value="<%= item.getName() %>"</input>
                        <input type="submit" id="add" value="+" ></input>
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
               ItemHandler.addToBasket("UPDATE shoppingcart SET " + request.getParameter("add") + "quantity = " + request.getParameter("add") + "quantity +1 WHERE username='"+ session.getAttribute("username")+"'");
            } 
            %>     
    </body>
    

</html>

       <% //ShoppingCart sc = new ShoppingCart(); %>