/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapadeDatos;

import javax.persistence.Query;

/**
 *
 * @author andre
 */
public class ComprobarUsuario {

    public static int Comprobar(String Correo, String Pass) {
        //JPQL no me sirvio, así que se armo una sentencia SQL Query con sus valores ? asignados respectivamente
        String consulta = "SELECT COUNT(*) FROM ("
                + "SELECT 1 FROM ALUMNO WHERE ALUMNO.CORREOALUMNO = ? AND ALUMNO.CONTRASENIAALUMNO = ? "
                + "UNION ALL "
                + "SELECT 1 FROM PROFESOR WHERE PROFESOR.CORREOPROFESOR = ? AND PROFESOR.CONTRASENIAPROFESOR = ?"
                + ") AS resultado;";

        var EMF = JpaUtil.getEntityManager();
        Query SQL = (Query) EMF.createNativeQuery(consulta);
        SQL.setParameter(1, Correo);
        SQL.setParameter(2, Pass);
        SQL.setParameter(3, Correo);
        SQL.setParameter(4, Pass);
        Object resultado = SQL.getSingleResult();
        int valor = ((Number)resultado).intValue();
        return valor;
    }
}
