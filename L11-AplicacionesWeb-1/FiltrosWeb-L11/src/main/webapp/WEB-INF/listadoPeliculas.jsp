<%-- 
    Document   : listadoPeliculas
    Created on : 05-dic-2020, 0:33:20
    Author     : eli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
   <head>
      <title>Listado resultante</title> 
   </head>

  <body>  
    <h1>Ranking de Películas</h1>
    <p> Las tres películas ${votadas} son:</p>
      <ol>
       <li>${primera}</li>
       <li>${segunda}</li>
       <li>${tercera}</li>
    </ol> 
    <a href="index.html"> Volver a inicio</a>
  </body>
</html>

