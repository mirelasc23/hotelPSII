package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Check;

public class CheckDAO implements InterfaceDAO<Check>{
private static CheckDAO INSTANCE;
    protected EntityManager entityManager;
    
    public CheckDAO(){
        entityManager = getEntityManager();
    }
    
    public static CheckDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CheckDAO();
        }
        return INSTANCE;
    }
    
    private EntityManager getEntityManager(){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
            if(this.entityManager == null){
                this.entityManager = factory.createEntityManager();
            }
            return this.entityManager;
    }
    
    @Override
    public void create(Check objeto) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(objeto);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Check retrieve(int id) {
        Check modelo = new Check();
        modelo = entityManager.find(Check.class, id);
        return modelo;
    }

    @Override
    public List<Check> retrieve(String atributo, String valor) {
        List<Check> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mar From modelo mar "
                + " where " + atributo + " like (%" + valor + "%)",Check.class).getResultList();
        return modelos;
    }

    @Override
    public void update(Check objeto) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Check objeto) {
        try {
            entityManager.getTransaction().begin();
            Check modelo = new Check();
            modelo = entityManager.find(Check.class, objeto.getId());
            if(modelo != null){
                entityManager.remove(modelo);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
