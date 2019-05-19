<%-- 
    Document   : index
    Created on : Mar 23, 2019, 12:24:27 PM
    Author     : esra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <style>
.content {
  max-width: 500px;
  margin: auto;
}
</style>
    </head>
    <body >
        <div class="content">
        <h1 center="true">Library</h1>
             <p>search for any book now</p>
            <form action="Search" method="get">           
            <input type="text" name="name" placeholder="enert book name ..">
            <input type="submit" value="Search">
        </form>
             <br>
             <a href="DisplayBooksServlet">Display All Books</a>
        </div>    
    </body>
</html>
