package model.dao;


import java.util.ArrayList;
import java.util.List;
import model.ProdutoCopa;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ProdutoCopaDAO implements InterfaceDAO<ProdutoCopa>{
private static ProdutoCopaDAO INSTANCE;
    protected EntityManager entityManager;
    
    public ProdutoCopaDAO(){
        entityManager = getEntityManager();
    }
    
    public static ProdutoCopaDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ProdutoCopaDAO();
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
    public void create(ProdutoCopa objeto) {
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
    public ProdutoCopa retrieve(int id) {
        ProdutoCopa modelo = new ProdutoCopa();
        modelo = entityManager.find(ProdutoCopa.class, id);
        return modelo;
    }

    @Override
    public List<ProdutoCopa> retrieve(String atributo, String valor) {
        List<ProdutoCopa> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mar From modelo mar "
                + " where " + atributo + " like (%" + valor + "%)",ProdutoCopa.class).getResultList();
        return modelos;
    }

    @Override
    public void update(ProdutoCopa objeto) {
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
    public void delete(ProdutoCopa objeto) {
        try {
            entityManager.getTransaction().begin();
            ProdutoCopa modelo = new ProdutoCopa();
            modelo = entityManager.find(ProdutoCopa.class, objeto.getId());
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
