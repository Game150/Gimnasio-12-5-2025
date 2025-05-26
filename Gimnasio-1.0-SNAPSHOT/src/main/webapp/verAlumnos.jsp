<%-- 
    Document   : verAlumnos
    Created on : 14 may. 2025, 11:50:35 a. m.
    Author     : andre
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Usuarios.Alumno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ver lista de alumnos en memoria</h1>
        <form action="SVregistrarAlumnos" method="GET" target="_self">
            <button type="submit">Actualizar</button>
        </form>
        <%
           Alumno alu = (Alumno) request.getSession().getAttribute("Alumno"); 
           //Usuarios.Alumno usuario = (Alumno) request.getSession().getAttribute("Usuario"); 
           
           if(alu == null){
           %>
               <p>No hay existencias</p> 
           <%
           } else {
            
        %>
        
            <p>Nombre: <%= alu.getNombre()%> </p>
            <p>Correo: <%= alu.getCorreo()%> </p>
            <p>Localidad: <%= alu.getLocalidad()%> </p>
            <p>Altura: <%= alu.getAltura()%> </p>
            <p>Edad: <%= alu.getEdad()%> </p>
            <p>Peso: <%= alu.getPeso()%> </p>
            <hr>
            
        <% } //Fin if %>
    </body>
</html>
