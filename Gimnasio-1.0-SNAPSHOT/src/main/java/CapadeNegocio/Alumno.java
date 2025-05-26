package CapadeNegocio;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idAlumno;
    
    @Column(nullable = false)
    private String nombreAlumno;
    
    @Column(nullable = false, unique = true)
    private String correoAlumno;
    
    @Column(nullable = false)
    private String contraseniaAlumno;
    
    @Basic
    private String imgAlumno;
    private float pesoAlumno;
    private float edadAlumno;
    private float alturaAlumno;
    
    @OneToOne
    @JoinColumn(name="idLocalidad")
    private Localidad localidad;
    
    public Alumno() {
    
    }

    public Alumno(int idAlumno, String nombreAlumno, String correoAlumno, String contraseniaAlumno, String imgAlumno, float pesoAlumno, float edadAlumno, float alturaAlumno, Localidad localidad) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.correoAlumno = correoAlumno;
        this.contraseniaAlumno = contraseniaAlumno;
        this.imgAlumno = imgAlumno;
        this.pesoAlumno = pesoAlumno;
        this.edadAlumno = edadAlumno;
        this.alturaAlumno = alturaAlumno;
        this.localidad = localidad;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getCorreoAlumno() {
        return correoAlumno;
    }

    public void setCorreoAlumno(String correoAlumno) {
        this.correoAlumno = correoAlumno;
    }

    public String getContraseniaAlumno() {
        return contraseniaAlumno;
    }

    public void setContraseniaAlumno(String contraseniaAlumno) {
        this.contraseniaAlumno = contraseniaAlumno;
    }

    public String getImgAlumno() {
        return imgAlumno;
    }

    public void setImgAlumno(String imgAlumno) {
        this.imgAlumno = imgAlumno;
    }

    public float getPesoAlumno() {
        return pesoAlumno;
    }

    public void setPesoAlumno(float pesoAlumno) {
        this.pesoAlumno = pesoAlumno;
    }

    public float getEdadAlumno() {
        return edadAlumno;
    }

    public void setEdadAlumno(float edadAlumno) {
        this.edadAlumno = edadAlumno;
    }

    public float getAlturaAlumno() {
        return alturaAlumno;
    }

    public void setAlturaAlumno(float alturaAlumno) {
        this.alturaAlumno = alturaAlumno;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    
    
}
