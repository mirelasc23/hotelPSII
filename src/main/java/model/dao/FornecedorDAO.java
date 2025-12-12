package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Fornecedor;

public class FornecedorDAO implements InterfaceDAO<Fornecedor>{
    private static FornecedorDAO INSTANCE;
    protected EntityManager entityManager;
    
    public FornecedorDAO(){
        entityManager = getEntityManager();
    }
    
    public static FornecedorDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new FornecedorDAO();
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
    public void create(Fornecedor objeto) {
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
    public Fornecedor retrieve(int id) {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor = entityManager.find(Fornecedor.class, id);
        return fornecedor;
    }

    @Override
    public List<Fornecedor> retrieve(String atributo, String valor) {
        List<Fornecedor> fornecedores = new ArrayList<>();
        fornecedores = entityManager.createQuery(" Select forn From Fornecedor f "
                + " where " + atributo + " like (%" + valor + "%)",Fornecedor.class).getResultList();
        return fornecedores;
    }

    @Override
    public void update(Fornecedor objeto) {
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
    public void delete(Fornecedor objeto) {
        try {
            entityManager.getTransaction().begin();
            Fornecedor fornecedor = new Fornecedor();
            fornecedor = entityManager.find(Fornecedor.class, objeto.getId());
            if(fornecedor != null){
                entityManager.remove(fornecedor);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
