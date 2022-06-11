<%-- 
    Document   : viewnote
    Created on : Jun 10, 2022, 7:56:21 PM
    Author     : Matt
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Note</title>
    </head>
    <body>
        <h1>Title: ${note.title}</h1>
        <p>Content: ${note.content}</p>
        <a href="/Lab4_SimpleNoteKeeper/note">Edit</a>
    </body>
</html>
