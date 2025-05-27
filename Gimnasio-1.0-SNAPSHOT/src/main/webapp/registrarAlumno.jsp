<%@page import="java.util.ArrayList"%>
<%@page import="CapadeNegocio.Localidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="CapadeNegocio.ControladoradeUsuarios"  %>
<!DOCTYPE html>
<html>
    <head>
        <title>Registro de alumno</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="CSS/Registro-alumno.css"/>
        <script src="JS/registrarAlumno.js"></script>
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
            <form action="SVregistrarAlumnos" method="POST" class="form_registro">
                <h1>Registro de Alumno</h1>
                <hr>
                <label for="nombre_alumno">Nombre</label>
                <input type="text" placeholder="Ingrese el nombre para su usuario" name="nombre_alumno" required autofocus>
                <label for="email_alumno">Correo</label>
                <input type="email" placeholder="Ingrese su correo para vincular a su cuenta" name="email_alumno" required>
                <label for="pass_alumno">Contraseña</label>
                <input type="password" placeholder="Ingrese la contraseña" name="pass_alumno" required>
                <div>
                    <select for="Localidad" name="localidad_alumno">
                        <option>Seleccione su localidad</option>
                        <%  
                            ArrayList<Localidad> listaLocalidades = (ArrayList<Localidad>) ControladoradeUsuarios.getCP().obtenerLocalidadesCP();
                        %>
                        <%for (Localidad localidad :  listaLocalidades) {%>
                        <option value="<%= localidad.getIdLocalidad() %>"> <%= localidad.getNombreLocalidad() %> </option>
                        <% } %>
                    </select>
                    <select name="edad_alumno">
                        <option>Seleccione su edad</option>
                        <%for (int i = 18; i >= 18 && i <= 100; i++) {%>
                        <option><%=i%></option>
                        <% } %>
                    </select>
                    <select name="altura_alumno">
                        <option>Seleccione su altura</option>
                        <%for (int i = 140; i >= 140 && i <= 210; i++) {%>
                        <option><%=i%></option>
                        <% } %>
                    </select>
                    <select name="peso_alumno">
                        <option>Seleccione su peso</option>
                        <%for (int i = 30; i >= 30 && i <= 400; i++) {%>
                        <option><%=i%></option>
                        <% }%>
                    </select>
                </div>
                <input type="submit" value="Enviar">
            </form>
        </div>
    </body>
</html>
