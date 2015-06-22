<%-- 
    Document   : welcome
    Created on : Jun 17, 2015, 8:08:43 PM
    Author     : mormon
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome!!!!</title>
        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <style> 
            h2 { 
                color: white; 
            } 
            .well {
                width: 700px;
            }
            .lButton {
                padding-top: 13px;
                padding-right: 20px;
            }
        </style>
    </head>
    <body>
        <form action="Logout">
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <h2>Welcome ${sessionScope.name}</h2>
                </div>
                <div class="lButton">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <button type="submit" class="btn btn-primary">Logout</button>
                    </li>
                </ul>
                </div>
            </div>
        </nav>
        </form>
        <br>
        <!-- Add the posts here before the add comment tag -->
        <div class="container">    
        <h1>Welcome to the Thread Post</h1>
        <br>
        <div class="media">
            <div class="media-body">
                <c:forEach var="post" items="${posts}">
                <h4 class="media-heading">${post.user}
                    <small>${post.post}</small>
                </h4>
                ${post.date}
                <br>
                <br>
                </c:forEach>
            </div>
        </div>
        <hr>
        <div class="well">
            <h4>Add a post:</h4>
            <form role="form" action="writePosts">
                <div class="form-group">
                    <textarea class="form-control" rows="3" name="post"></textarea>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
        </div>
        </div>
    </body>
</html>