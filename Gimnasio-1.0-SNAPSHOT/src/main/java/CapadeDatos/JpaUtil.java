/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapadeDatos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author andre
 */
public class JpaUtil {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("GimnasioPU");

    private JpaUtil() {}

    public static EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }

    public static void closeEntityManagerFactory() {
        if (EMF != null && EMF.isOpen()) {
            EMF.close();
        }
    }
    
}
