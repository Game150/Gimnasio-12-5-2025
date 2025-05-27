<%-- 
    Document   : registrarProfesor
    Created on : 27 may. 2025, 16:35:17
    Author     : andre
--%>

<%@page import="CapadeNegocio.Localidad"%>
<%@page import="CapadeNegocio.ControladoradeUsuarios"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de profesor</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/Registro-profesor.css"/>
        <%  
            //Se usa session para referirse a la session actual del navegador del usuario
            String mensaje = (String) session.getAttribute("Mensaje");
            String error = (String) session.getAttribute("Error");
        %>
        <script>
            <% if (mensaje != null) { %>
                alert("<%= mensaje %>");
            <% } else if (error != null) { %>
                alert("<%= error %>");
            <% } %>
            <%
                //Se limpia el contenido de Session para evitar repeticiones de mensajes viejos
                if (mensaje != null) {request.getSession().removeAttribute("Mensaje");}
                if (error != null) {request.getSession().removeAttribute("Error");}
            %>
        </script>
    </head>
    <body>
            <div class="form_container">
                <form action="SVregistrarProfesor" method="POST" class="form_registro">
                    <h1>Registro de Profesor</h1>
                    <hr>
                    <label for="nombre_profesor">Nombre</label>
                    <input type="text" placeholder="Ingrese el nombre para su usuario" name="nombre_profesor" required autofocus>
                    <label for="email_profesor">Correo</label>
                    <input type="email" placeholder="ejemplo@ejemplo.com" name="email_profesor" required>
                    <label for="pass_profesor">Contraseña</label>
                    <input type="password" placeholder="Contraseña segura" name="pass_profesor" required>
                    <select for="Localidad" name="localidad_alumno">
                        <option>Seleccione su localidad</option>
                        <%  
                            ArrayList<Localidad> listaLocalidades = (ArrayList<Localidad>) ControladoradeUsuarios.getCP().obtenerLocalidadesCP();
                        %>
                        <%for (Localidad localidad :  listaLocalidades) {%>
                        <option value="<%= localidad.getIdLocalidad() %>"> <%= localidad.getNombreLocalidad() %> </option>
                        <% } %>
                    </select>
                    <div class="textarea_container">
                        <label>Cuantos un poco sobre tu experiencia</label>
                        <textarea name="experiencia_profesor" maxlength="255" placeholder="Profesional de servicio al cliente comprometido...."></textarea>
                    </div>
                    <input type="submit" value="Enviar">
                </form>
            </div>
    </body>
</html>
