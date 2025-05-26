/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapadeDatos;

import CapadeNegocio.Alumno;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class AlumnoJpaController {

    public void createEntity(Alumno object) {
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

    public Alumno findEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Alumno alu = null;
        try {
            alu = em.find(Alumno.class, id);
        }catch (Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al buscar entidad", e);
        } finally {
            em.close();
        }
        return alu;
    }

    public void updateEntity(Alumno object) {
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
            Alumno alu = em.find(Alumno.class, id);
            if (alu != null) {
                em.remove(alu);
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
