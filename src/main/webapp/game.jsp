<%-- 
    Document   : game
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
        <hr>
        <h2> ${joueurs} joueurs connectés </h2>
        <hr>
        <h3> Hello ${playerName}, Devine mon nombre </h3>
        <p> Essai n°<b> ${tries} </b> </p>
        <br>
        <p> ${guess} </p>
        <h2>je pense à un nombre compris entre 0 et 100 </h2>
        <form method="POST">
            <p> Trop ${hauteur} </p>
            <label>
                Ta proposition :
                <input type="number" min="0" max="100" required="" name="nombre">
            </label>
            <input type="hidden" name="action" value="ADD">
            <input name="deviner" value="Deviner" type="SUBMIT">
            <br>
        </form>
        <form method="POST">
            <input type="SUBMIT" name="action" value="Déconnexion">
        </form>
    </body>
</html>