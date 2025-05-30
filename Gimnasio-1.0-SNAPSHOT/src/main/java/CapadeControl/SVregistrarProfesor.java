package CapadeControl;

import CapadeNegocio.Localidad;
import CapadeNegocio.Profesor;
import Controladoras.ControladoradeUsuarios;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "SVregistrarProfesor", urlPatterns = {"/SVregistrarProfesor"})
public class SVregistrarProfesor extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession misesion = request.getSession(true);
        Profesor pro = new Profesor();
        try {

            //Declaración de las variables
            String nombre = request.getParameter("nombre_profesor");
            String email = request.getParameter("email_profesor");
            String pass = request.getParameter("pass_profesor");
            String localidad = request.getParameter("localidad_profesor");
            String experiencia = request.getParameter("experiencia_profesor");

            //Verificación de inputs
            if (nombre != null && !nombre.trim().isEmpty() && email != null && !email.trim().isEmpty() && pass != null && !pass.trim().isEmpty()) {
                pro.setNombreProfesor(nombre);
                pro.setCorreoProfesor(email);
                pro.setContraseniaProfesor(pass);
                pro.setExperienciaProfesor(experiencia);

            } else { //Respuesta en caso de que la inputs esten vaciós
                misesion.setAttribute("Error", "Los valores ingresados no pueden ser nulos.");
                response.sendRedirect(request.getContextPath() + "/registrarAlumno.jsp");
                return; //Cierra la ejecución y manda la repuesta

            }

            //Verificación de select
            if (!localidad.equals("Seleccione su localidad") && !localidad.trim().isEmpty()) {
                Localidad local = new Localidad();
                local.setIdLocalidad(Integer.parseInt(localidad));
                pro.setLocalidad(local);

            } else { //Respuesta en caso de error en el select con value por defecto
                misesion.setAttribute("Error", "Debe seleccionar valores validos.");
                response.sendRedirect(request.getContextPath() + "/registrarAlumno.jsp");
                return; //Cierra la ejecución y manda la repuesta

            }

            //Persistencia de alumno en la base de datos
            ControladoradeUsuarios.getCP().crearProfesorCP(pro);
            misesion.setAttribute("Mensaje", "Usuario registrado correctamente");
            response.sendRedirect(request.getContextPath() + "/registrarAlumno.jsp");

        } catch (Exception ex) {
            misesion.setAttribute("Error", "Ocurrió un error inesperado");
            response.sendRedirect(request.getContextPath() + "/registrarAlumno.jsp");
            Logger.getLogger(SVregistrarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
