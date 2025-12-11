package model.dao;

import java.util.List;
import model.ReservaQuarto;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ReservaQuartoDAO implements InterfaceDAO<ReservaQuarto>{
private static ReservaQuartoDAO INSTANCE;
    protected EntityManager entityManager;
    
    public ReservaQuartoDAO(){
        entityManager = getEntityManager();
    }
    
    public static ReservaQuartoDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ReservaQuartoDAO();
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
    public void create(ReservaQuarto objeto) {
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
    public ReservaQuarto retrieve(int id) {
        ReservaQuarto modelo = new ReservaQuarto();
        modelo = entityManager.find(ReservaQuarto.class, id);
        return modelo;
    }

    @Override
    public List<ReservaQuarto> retrieve(String atributo, String valor) {
        List<ReservaQuarto> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mar From modelo mar "
                + " where " + atributo + " like (%" + valor + "%)",ReservaQuarto.class).getResultList();
        return modelos;
    }

    @Override
    public void update(ReservaQuarto objeto) {
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
    public void delete(ReservaQuarto objeto) {
        try {
            entityManager.getTransaction().begin();
            ReservaQuarto modelo = new ReservaQuarto();
            modelo = entityManager.find(ReservaQuarto.class, objeto.getId());
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
