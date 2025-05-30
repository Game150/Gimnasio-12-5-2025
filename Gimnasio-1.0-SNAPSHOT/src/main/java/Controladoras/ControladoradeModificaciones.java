/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

/**
 *
 * @author andre
 */
import CapadeDatos.AlumnoJpaController;
import CapadeDatos.ProfesorJpaController;
import CapadeDatos.Red_SocialJpaController;
import CapadeNegocio.Alumno;
import CapadeNegocio.Profesor;
import CapadeNegocio.Red_Social;

public class ControladoradeModificaciones {

    AlumnoJpaController aluJpa = new AlumnoJpaController();
    ProfesorJpaController proJpa = new ProfesorJpaController();
    Red_SocialJpaController rsJpa = new Red_SocialJpaController();
    
    public void modificarAlumno(Alumno alu){
        aluJpa.updateEntity(alu);
    }
    
    public void modificarProfesor(Profesor pro){
        proJpa.updateEntity(pro);
    }
    
    public void modificarRed_Social(Red_Social red){
        rsJpa.updateEntity(red);
    }
    

}
