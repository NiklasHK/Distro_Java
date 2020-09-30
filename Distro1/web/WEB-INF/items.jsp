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
        <% Collection<ItemInfo> items = ItemHandler.getItemsWithGroup("frukt");
        Iterator<ItemInfo> it = items.iterator();
        for(; it.hasNext();){
            ItemInfo item = it.next();%>
            <%= item.getName()%> :
            <%= item.getDescription()%><br>
        <% }%>
    </body>
</html>
