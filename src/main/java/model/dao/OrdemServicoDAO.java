package model.dao;

import java.util.List;
import model.OrdemServico;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class OrdemServicoDAO implements InterfaceDAO<OrdemServico>{
private static OrdemServicoDAO INSTANCE;
    protected EntityManager entityManager;
    
    public OrdemServicoDAO(){
        entityManager = getEntityManager();
    }
    
    public static OrdemServicoDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new OrdemServicoDAO();
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
    public void create(OrdemServico objeto) {
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
    public OrdemServico retrieve(int id) {
        OrdemServico modelo = new OrdemServico();
        modelo = entityManager.find(OrdemServico.class, id);
        return modelo;
    }

    @Override
    public List<OrdemServico> retrieve(String atributo, String valor) {
        List<OrdemServico> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select os From OrdemServico os "
                + " where os." + atributo + " like '%" + valor + "%'",OrdemServico.class).getResultList();
        return modelos;
    }

    @Override
    public void update(OrdemServico objeto) {
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
    public void delete(OrdemServico objeto) {
        try {
            entityManager.getTransaction().begin();
            OrdemServico modelo = new OrdemServico();
            modelo = entityManager.find(OrdemServico.class, objeto.getId());
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
