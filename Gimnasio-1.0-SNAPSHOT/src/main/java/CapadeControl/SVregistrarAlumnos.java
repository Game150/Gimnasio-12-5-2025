package CapadeControl;

import CapadeNegocio.Alumno;
import CapadeNegocio.ControladoradeUsuarios;
import CapadeNegocio.Localidad;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "SVregistrarAlumnos", urlPatterns = "/SVregistrarAlumnos")
public class SVregistrarAlumnos extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession misesion = request.getSession(true);
        Alumno alu = new Alumno();
        try {
            
            //Declaración de las variables
            String nombre = request.getParameter("nombre_alumno");
            String email = request.getParameter("email_alumno");
            String pass = request.getParameter("pass_alumno");
            String edad = request.getParameter("edad_alumno");
            String peso = request.getParameter("peso_alumno");
            String altura = request.getParameter("altura_alumno");
            String localidad = request.getParameter("localidad_alumno");
            
            //Verificación de inputs
            if (nombre != null && !nombre.trim().isEmpty() && email != null && !email.trim().isEmpty() && pass != null &&!pass.trim().isEmpty() ) {
                alu.setNombreAlumno(nombre);
                alu.setCorreoAlumno(email);
                alu.setContraseniaAlumno(pass);
                
            } else { //Respuesta en caso de que la inputs esten vaciós
                misesion.setAttribute("Error", "Los valores ingresados no pueden ser nulos.");
                response.sendRedirect(request.getContextPath() + "/registrarAlumno.jsp");
                return; //Cierra la ejecución y manda la repuesta
                
            }
            
            //Verificación de selects
            if ( !edad.equals("Seleccione su edad") && !edad.trim().isEmpty() && !peso.equals("Seleccione su peso") && !peso.trim().isEmpty() && !altura.equals("Seleccione su altura") && !altura.trim().isEmpty() && !localidad.equals("Seleccione su localidad") && !localidad.trim().isEmpty() ) {
                alu.setAlturaAlumno(Integer.parseInt(altura));
                alu.setPesoAlumno(Integer.parseInt(peso));
                alu.setEdadAlumno(Integer.parseInt(edad));
                Localidad local = new Localidad();
                local.setIdLocalidad(Integer.parseInt(localidad));
                alu.setLocalidad(local);
                
            } else { //Respuesta en caso de error en los selects con value por defecto
                misesion.setAttribute("Error", "Debe seleccionar valores validos.");
                response.sendRedirect(request.getContextPath() + "/registrarAlumno.jsp");
                return; //Cierra la ejecución y manda la repuesta
                
            }
            
            //Persistencia de alumno en la base de datos
            ControladoradeUsuarios.getCP().crearAlumnoCP(alu);
            misesion.setAttribute("Mensaje", "Usuario registrado correctamente");
            response.sendRedirect(request.getContextPath() + "/registrarAlumno.jsp");

            
        } catch (Exception ex) {
            misesion.setAttribute("Error", "Ocurrió un error inesperado");
            response.sendRedirect(request.getContextPath() + "/registrarAlumno.jsp");
            Logger.getLogger(SVregistrarAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            
        } 
    }
}
