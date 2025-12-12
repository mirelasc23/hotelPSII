package model.dao;

import java.util.List;
import model.Hospede;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class HospedeDAO implements InterfaceDAO<Hospede>{
private static HospedeDAO INSTANCE;
    protected EntityManager entityManager;
    
    public HospedeDAO(){
        entityManager = getEntityManager();
    }
    
    public static HospedeDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new HospedeDAO();
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
    public void create(Hospede objeto) {
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
    public Hospede retrieve(int id) {
        Hospede modelo = new Hospede();
        modelo = entityManager.find(Hospede.class, id);
        return modelo;
    }

    @Override
    public List<Hospede> retrieve(String atributo, String valor) {
        List<Hospede> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select hosp From Hospede hosp "
                + " where hosp." + atributo + " like '%" + valor + "%'",Hospede.class).getResultList();
        return modelos;
    }

    @Override
    public void update(Hospede objeto) {
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
    public void delete(Hospede objeto) {
        try {
            entityManager.getTransaction().begin();
            Hospede modelo = new Hospede();
            modelo = entityManager.find(Hospede.class, objeto.getId());
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
