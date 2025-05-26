package CapadeNegocio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Administrador implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idAdministrador;
    
    @Column(nullable = false)
    private String nombreAdministrador;
    
    @Column(nullable = false, unique = true)
    private String correoAdministrador;
    
    @Column(nullable = false)
    private String contraseniaAdministrador;
    
    public Administrador() {}

    public Administrador(int idAdministrador, String nombreAdministrador, String correoAdministrador, String contraseniaAdministrador) {
        this.idAdministrador = idAdministrador;
        this.nombreAdministrador = nombreAdministrador;
        this.correoAdministrador = correoAdministrador;
        this.contraseniaAdministrador = contraseniaAdministrador;
    }
    
    public int getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(int idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombreAdministrador() {
        return nombreAdministrador;
    }

    public void setNombreAdministrador(String nombreAdministrador) {
        this.nombreAdministrador = nombreAdministrador;
    }

    public String getCorreoAdministrador() {
        return correoAdministrador;
    }

    public void setCorreoAdministrador(String correoAdministrador) {
        this.correoAdministrador = correoAdministrador;
    }

    public String getContraseniaAdministrador() {
        return contraseniaAdministrador;
    }

    public void setContraseniaAdministrador(String contraseniaAdministrador) {
        this.contraseniaAdministrador = contraseniaAdministrador;
    }

   
    
}
