package CapadeNegocio;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Red_Social implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idRed;

    @Basic
    String nombreUsuario;
    String plataforma;
    String url;

    //Hace referencia al atributo multivaluado Red_Social dentro de Profesor
    @ManyToOne
    Profesor profesor;

    public Red_Social(int idRed, String nombreUsuario, String plataforma, String url) {
        this.idRed = idRed;
        this.nombreUsuario = nombreUsuario;
        this.plataforma = plataforma;
        this.url = url;
    }

    public Red_Social() {
    }

    public int getIdRed() {
        return idRed;
    }

    public void setIdRed(int idRed) {
        this.idRed = idRed;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }



}
