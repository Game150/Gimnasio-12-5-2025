/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapadeDatos;

import CapadeNegocio.Administrador;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

/**
 *
 * @author andre
 */
public class AdministradorJpaController implements Serializable {

    public void createEntity(Administrador object) {
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

    public Administrador findEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Administrador adm = null;
        try {
            adm = em.find(Administrador.class, id);
        }catch (Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al buscar entidad", e);
        } finally {
            em.close();
        }
        return adm;
    }

    public void updateEntity(Administrador object) {
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
            Administrador adm = em.find(Administrador.class, id);
            if (adm != null) {
                em.remove(adm);
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
