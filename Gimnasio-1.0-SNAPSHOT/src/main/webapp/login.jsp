<%-- 
    Document   : login
    Created on : 2 jun. 2025, 04:05:06
    Author     : andre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Inicio Sesión</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/Login.css"/>
        <%
            //Se usa session para referirse a la session actual del navegador del usuario
            String mensaje = (String) session.getAttribute("Mensaje");
            String error = (String) session.getAttribute("Error");
        %>
        <script>
            <% if (mensaje != null) {%>
            alert("<%= mensaje%>");
            <% } else if (error != null) {%>
            alert("<%= error%>");
            <% } %>
            <%
                //Se limpia el contenido de Session para evitar repeticiones de mensajes viejos
                if (mensaje != null) {
                    request.getSession().removeAttribute("Mensaje");
                }
                if (error != null) {
                    request.getSession().removeAttribute("Error");
                }
            %>
        </script>
    </head>
    <body>
        <div class="form_container">
            <form action="SVlogin" method="POST" class="form_registro">
                <h1>Inicio Sesion</h1>
                <hr>
                <label for="correo_usuario">Usuario</label>
                <input type="email" name="correo_usuario" placeholder="Ingrese su correo" >
                <label for="pass_usuario">Contraseña</label>
                <input type="password" name="pass_usuario" placeholder="Ingrese su contraseña" >
                <input type="submit" value="Ingresar" >
            </form>
        </div>
    </body>
</html>
