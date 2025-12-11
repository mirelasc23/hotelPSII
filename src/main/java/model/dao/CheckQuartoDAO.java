package model.dao;

import java.util.List;
import model.CheckQuarto;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CheckQuartoDAO implements InterfaceDAO<CheckQuarto>{
private static CheckQuartoDAO INSTANCE;
    protected EntityManager entityManager;
    
    public CheckQuartoDAO(){
        entityManager = getEntityManager();
    }
    
    public static CheckQuartoDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CheckQuartoDAO();
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
    public void create(CheckQuarto objeto) {
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
    public CheckQuarto retrieve(int id) {
        CheckQuarto modelo = new CheckQuarto();
        modelo = entityManager.find(CheckQuarto.class, id);
        return modelo;
    }

    @Override
    public List<CheckQuarto> retrieve(String atributo, String valor) {
        List<CheckQuarto> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mar From modelo mar "
                + " where " + atributo + " like (%" + valor + "%)",CheckQuarto.class).getResultList();
        return modelos;
    }

    @Override
    public void update(CheckQuarto objeto) {
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
    public void delete(CheckQuarto objeto) {
        try {
            entityManager.getTransaction().begin();
            CheckQuarto modelo = new CheckQuarto();
            modelo = entityManager.find(CheckQuarto.class, objeto.getId());
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
