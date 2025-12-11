package model.dao;

import java.util.List;
import model.CopaQuarto;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CopaQuartoDAO implements InterfaceDAO<CopaQuarto>{
private static CopaQuartoDAO INSTANCE;
    protected EntityManager entityManager;
    
    public CopaQuartoDAO(){
        entityManager = getEntityManager();
    }
    
    public static CopaQuartoDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CopaQuartoDAO();
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
    public void create(CopaQuarto objeto) {
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
    public CopaQuarto retrieve(int id) {
        CopaQuarto modelo = new CopaQuarto();
        modelo = entityManager.find(CopaQuarto.class, id);
        return modelo;
    }

    @Override
    public List<CopaQuarto> retrieve(String atributo, String valor) {
        List<CopaQuarto> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mar From modelo mar "
                + " where " + atributo + " like (%" + valor + "%)",CopaQuarto.class).getResultList();
        return modelos;
    }

    @Override
    public void update(CopaQuarto objeto) {
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
    public void delete(CopaQuarto objeto) {
        try {
            entityManager.getTransaction().begin();
            CopaQuarto modelo = new CopaQuarto();
            modelo = entityManager.find(CopaQuarto.class, objeto.getId());
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
