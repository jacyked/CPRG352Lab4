<%-- 
    Document   : editnote
    Created on : Jun 10, 2022, 7:56:42 PM
    Author     : Matt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Edit Note</h1>
        <form method="POST" action="note" id="noteform">
            <label>Title:</label>
            <input type="text" value="${title}">
            <br>
            <label>Content:</label>
            <textarea form ="noteform" value="${content}"></textarea>
            <br>
            <br>
            <input type="submit" value="Save">
        </form
        <c:if test="${error == true}">
        <p>Please enter both a title and some content.</p>
        </c:if>
    </body>
</html>
