/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CapadeControl;

import CapadeDatos.ComprobarUsuario;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andre
 */
@WebServlet(name = "SVlogin", urlPatterns = {"/SVlogin"})
public class SVlogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String correo = request.getParameter("correo_usuario");
        String pass = request.getParameter("pass_usuario");
        HttpSession misesion = request.getSession(true);

        if (correo != null && !correo.trim().isEmpty() && pass != null && !pass.trim().isEmpty()) {
            try {
                int respuesta = ComprobarUsuario.Comprobar(correo, pass);
                if (respuesta > 0 && respuesta == 1) {
                    misesion.setAttribute("Mensaje", "Inicio Sesion Satisfactoria");
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    return; //Cierra la ejecución y manda la repuesta
                } else {
                    misesion.setAttribute("Mensaje", "Usuario o Contraseña no encontrado");
                    response.sendRedirect(request.getContextPath() + "/login.jsp");
                    return; //Cierra la ejecución y manda la repuesta
                }

            } catch (Exception ex) {
                misesion.setAttribute("Error", "Ocurrió un error inesperado");
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                Logger.getLogger(SVregistrarAlumnos.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }

}
