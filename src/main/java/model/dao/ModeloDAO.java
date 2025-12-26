package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Modelo;

public class ModeloDAO implements InterfaceDAO<Modelo>{
    private static ModeloDAO INSTANCE;
    protected EntityManager entityManager;
    
    public ModeloDAO(){
        entityManager = getEntityManager();
    }
    
    public static ModeloDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ModeloDAO();
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
    public void create(Modelo objeto) {
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
    public Modelo retrieve(int id) {
        Modelo modelo = new Modelo();
        modelo = entityManager.find(Modelo.class, id);
        return modelo;
    }

    @Override
    public List<Modelo> retrieve(String atributo, String valor) {
        List<Modelo> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mod From Modelo mod "
                + " where mod." + atributo + " like '%" + valor + "%'",Modelo.class).getResultList();
        return modelos;
    }
    
    public List<Modelo> retrieveAll() {
        TypedQuery<Modelo> query = entityManager.createQuery("Select mod From Modelo mod ORDER BY mod.id",Modelo.class);
        query.setMaxResults(30);
        
        List<Modelo> modelos = new ArrayList<>();
        modelos = query.getResultList();
        return modelos;
    }


    @Override
    public void update(Modelo objeto) {
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
    public void delete(Modelo objeto) {
        try {
            entityManager.getTransaction().begin();
            Modelo modelo = new Modelo();
            modelo = entityManager.find(Modelo.class, objeto.getId());
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
