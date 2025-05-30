package Controladoras;
import CapadeDatos.AlumnoJpaController;
import CapadeDatos.ProfesorJpaController;
import CapadeDatos.Red_SocialJpaController;
import CapadeNegocio.Alumno;
import CapadeNegocio.Profesor;
import CapadeNegocio.Red_Social;

public class ControladoradePersistencias {
    
    AlumnoJpaController aluJpa = new AlumnoJpaController();
    ProfesorJpaController proJpa = new ProfesorJpaController();
    Red_SocialJpaController rsJpa = new Red_SocialJpaController();
    
    public void crearProfesorCP (Profesor pro) throws Exception {
        proJpa.createEntity(pro);      
    }
    
    public void crearAlumnoCP (Alumno alu) throws Exception {
        aluJpa.createEntity(alu);
    }
    
    public void crearRedsocialCP (Red_Social red) throws Exception {
        rsJpa.createEntity(red);   
    }
    
    
}
