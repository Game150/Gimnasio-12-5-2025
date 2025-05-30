/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapadeDatos;

import CapadeNegocio.Red_Social;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class Red_SocialJpaController {

    public void createEntity(Red_Social object) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public void updateEntity(Red_Social object) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al actualizar la entidad", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Red_Social findEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Red_Social red = null;
        try {
            red = em.find(Red_Social.class, id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al buscar entidad", e);
        } finally {
            em.close();
        }
        return red;
    }

    public void deleteEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Red_Social red = em.find(Red_Social.class, id);
            if (red != null) {
                em.remove(red);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al eliminar la entidad", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
