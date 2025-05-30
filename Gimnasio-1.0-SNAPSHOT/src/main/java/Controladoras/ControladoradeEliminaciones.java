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

public class ControladoradeEliminaciones {

    AlumnoJpaController aluJpa = new AlumnoJpaController();
    ProfesorJpaController proJpa = new ProfesorJpaController();
    Red_SocialJpaController rsJpa = new Red_SocialJpaController();

    public void eliminarAlumno(int id) {
        aluJpa.deleteEntity(id);
    }
    
    public void eliminarProfesor(int id) {
        proJpa.deleteEntity(id);
    }
    
    public void eliminarRed_Social(int id) {
        rsJpa.deleteEntity(id);
    }
}
