package CapadeNegocio;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Profesor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProfesor;

    @Column(nullable = false)
    private String nombreProfesor;

    @Column(nullable = false, unique = true)
    private String correoProfesor;

    @Column(nullable = false)
    private String contraseniaProfesor;
    
    @Basic
    private String imgProfesor;
    private String experienciaProfesor;
    private String descripcionProfesor;
    
    @OneToOne
    @JoinColumn(name="idLocalidad")
    private Localidad localidad;

    //Hace referencia al atributo multivaluado Red_Social
    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL)
    private List<Red_Social> redesSociales;

    public Profesor() {
    }

    public Profesor(int idProfesor, String nombreProfesor, String correoProfesor, String contraseniaProfesor, String imgProfesor, String experienciaProfesor, String descripcionProfesor, Localidad localidad, List<Red_Social> redesSociales) {
        this.idProfesor = idProfesor;
        this.nombreProfesor = nombreProfesor;
        this.correoProfesor = correoProfesor;
        this.contraseniaProfesor = contraseniaProfesor;
        this.imgProfesor = imgProfesor;
        this.experienciaProfesor = experienciaProfesor;
        this.descripcionProfesor = descripcionProfesor;
        this.localidad = localidad;
        this.redesSociales = redesSociales;
    }
    
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombreProfesor() {
        return nombreProfesor;
    }

    public void setNombreProfesor(String nombreProfesor) {
        this.nombreProfesor = nombreProfesor;
    }

    public String getCorreoProfesor() {
        return correoProfesor;
    }

    public void setCorreoProfesor(String correoProfesor) {
        this.correoProfesor = correoProfesor;
    }

    public String getContraseniaProfesor() {
        return contraseniaProfesor;
    }

    public void setContraseniaProfesor(String contraseniaProfesor) {
        this.contraseniaProfesor = contraseniaProfesor;
    }

    public String getImgProfesor() {
        return imgProfesor;
    }

    public void setImgProfesor(String imgProfesor) {
        this.imgProfesor = imgProfesor;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String getExperienciaProfesor() {
        return experienciaProfesor;
    }

    public void setExperienciaProfesor(String experienciaProfesor) {
        this.experienciaProfesor = experienciaProfesor;
    }

    public String getDescripcionProfesor() {
        return descripcionProfesor;
    }

    public void setDescripcionProfesor(String descripcionProfesor) {
        this.descripcionProfesor = descripcionProfesor;
    }

    public List<Red_Social> getRedesSociales() {
        return redesSociales;
    }

    public void setRedesSociales(List<Red_Social> redesSociales) {
        this.redesSociales = redesSociales;
    }

   
}
