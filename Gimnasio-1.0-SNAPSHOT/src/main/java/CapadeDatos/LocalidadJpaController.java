package CapadeDatos;

import CapadeNegocio.Localidad;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class LocalidadJpaController implements Serializable {
       public void createEntity(Localidad object) {
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

    public Localidad findEntity(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        Localidad localidad = null;
        try {
            localidad = em.find(Localidad.class, id);
        }catch (Exception e){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "Error al buscar entidad", e);
        } finally {
            em.close();
        }
        return localidad;
    }

    public ArrayList <Localidad> localidades () {
        String jpql = "SELECT l FROM Localidad l";
        EntityManager em = JpaUtil.getEntityManager();
        TypedQuery<Localidad> query = em.createQuery(jpql, Localidad.class);
        
        return new ArrayList<>(query.getResultList());
        
    }
    
    public void updateEntity(Localidad object) {
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
            Localidad localidad = em.find(Localidad.class, id);
            if (localidad != null) {
                em.remove(localidad);
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
