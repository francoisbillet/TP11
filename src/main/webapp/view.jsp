<%-- 
    Document   : view
    Created on : 14 nov. 2018, 13:32:02
    Author     : pedago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenue dans notre jeu !</h1>
        <hr>
        <h2> ${joueurs} joueurs connectés </h2>
        <hr>
        <form>
            <label> Ton prénom :
                <input name="playerName">
            </label>
            <input name="action" value="Connexion" type="SUBMIT">
        </form>
    </body>
</html>