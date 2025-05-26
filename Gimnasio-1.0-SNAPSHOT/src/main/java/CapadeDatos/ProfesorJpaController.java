/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapadeDatos;

import CapadeNegocio.Profesor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class ProfesorJpaController {

   public void createEntity(Profesor object) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al crear entidad", e);
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public Profesor findEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Profesor pro = null;
        try {
            pro = em.find(Profesor.class, id);
        }catch (Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al buscar entidad", e);
        } finally {
            em.close();
        }
        return pro;
    }

    public void updateEntity(Profesor object) {
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

    public void deleteEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            Profesor pro = em.find(Profesor.class, id);
            if (pro != null) {
                em.remove(pro);
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
