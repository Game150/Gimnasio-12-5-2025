package CapadeNegocio;
import CapadeDatos.AdministradorJpaController;
import CapadeDatos.AlumnoJpaController;
import CapadeDatos.LocalidadJpaController;
import CapadeDatos.ProfesorJpaController;
import CapadeDatos.Red_SocialJpaController;
import java.util.ArrayList;

public class ControladoradePersistencias {
    
    AlumnoJpaController aluJpa = new AlumnoJpaController();
    ProfesorJpaController proJpa = new ProfesorJpaController();
    AdministradorJpaController admJpa = new AdministradorJpaController();
    Red_SocialJpaController rsJpa = new Red_SocialJpaController();
    LocalidadJpaController lcJpa = new LocalidadJpaController();
    
    public void crearProfesorCP (Profesor pro) throws Exception {
        proJpa.createEntity(pro);
        
    }
    
    public void crearAdministradorCP (Administrador adm) throws Exception {
        admJpa.createEntity(adm);
        
    }
    
    public void crearAlumnoCP (Alumno alu) throws Exception {
        aluJpa.createEntity(alu);
        
    }
    
    public void crearRedsocialCP (Red_Social red) throws Exception {
        rsJpa.persist(red);
        
    }
    
    public ArrayList<Localidad> obtenerLocalidadesCP() {
        return new ArrayList<>(lcJpa.localidades());
    }
    
}
