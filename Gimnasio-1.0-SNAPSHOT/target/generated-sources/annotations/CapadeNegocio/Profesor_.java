package CapadeNegocio;

import CapadeNegocio.Localidad;
import CapadeNegocio.Red_Social;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2025-05-26T15:19:41")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, Integer> idProfesor;
    public static volatile SingularAttribute<Profesor, String> contraseniaProfesor;
    public static volatile SingularAttribute<Profesor, String> nombreProfesor;
    public static volatile SingularAttribute<Profesor, String> experienciaProfesor;
    public static volatile SingularAttribute<Profesor, String> descripcionProfesor;
    public static volatile SingularAttribute<Profesor, String> correoProfesor;
    public static volatile SingularAttribute<Profesor, Localidad> localidad;
    public static volatile SingularAttribute<Profesor, String> imgProfesor;
    public static volatile ListAttribute<Profesor, Red_Social> redesSociales;

}