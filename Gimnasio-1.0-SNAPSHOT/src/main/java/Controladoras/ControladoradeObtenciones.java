/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladoras;

import CapadeDatos.AlumnoJpaController;
import CapadeDatos.LocalidadJpaController;
import CapadeDatos.ProfesorJpaController;
import CapadeDatos.Red_SocialJpaController;
import CapadeNegocio.Alumno;
import CapadeNegocio.Localidad;
import CapadeNegocio.Profesor;
import CapadeNegocio.Red_Social;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class ControladoradeObtenciones {

    AlumnoJpaController aluJpa = new AlumnoJpaController();
    ProfesorJpaController proJpa = new ProfesorJpaController();
    LocalidadJpaController lcJpa = new LocalidadJpaController();
    Red_SocialJpaController rsJpa = new Red_SocialJpaController();

    public Alumno obtenerAlumno(int id) {
        return aluJpa.findEntity(id);
    }

    public Profesor obtenerProfesor(int id) {
        return proJpa.findEntity(id);
    }

    public Localidad obtenerLocalidad(int id) {
        return lcJpa.findEntity(id);
    }
    
    public Red_Social obtenerRedSocial(int id) {
        return rsJpa.findEntity(id);
    }
    
    public ArrayList<Localidad> obtenerlistadeLocalidades() {
        return new ArrayList<>(lcJpa.localidades());
    }
}
