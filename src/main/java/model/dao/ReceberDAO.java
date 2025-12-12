package model.dao;

import java.util.List;
import model.Receber;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ReceberDAO implements InterfaceDAO<Receber>{
private static ReceberDAO INSTANCE;
    protected EntityManager entityManager;
    
    public ReceberDAO(){
        entityManager = getEntityManager();
    }
    
    public static ReceberDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ReceberDAO();
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
    public void create(Receber objeto) {
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
    public Receber retrieve(int id) {
        Receber modelo = new Receber();
        modelo = entityManager.find(Receber.class, id);
        return modelo;
    }

    @Override
    public List<Receber> retrieve(String atributo, String valor) {
        List<Receber> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select rec From Receber rec "
                + " where rec." + atributo + " like '%" + valor + "%'",Receber.class).getResultList();
        return modelos;
    }

    @Override
    public void update(Receber objeto) {
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
    public void delete(Receber objeto) {
        try {
            entityManager.getTransaction().begin();
            Receber modelo = new Receber();
            modelo = entityManager.find(Receber.class, objeto.getId());
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
