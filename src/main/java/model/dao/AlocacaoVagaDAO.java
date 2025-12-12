package model.dao;

import java.util.List;
import model.AlocacaoVaga;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlocacaoVagaDAO implements InterfaceDAO<AlocacaoVaga>{
private static AlocacaoVagaDAO INSTANCE;
    protected EntityManager entityManager;
    
    public AlocacaoVagaDAO(){
        entityManager = getEntityManager();
    }
    
    public static AlocacaoVagaDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new AlocacaoVagaDAO();
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
    public void create(AlocacaoVaga objeto) {
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
    public AlocacaoVaga retrieve(int id) {
        AlocacaoVaga modelo = new AlocacaoVaga();
        modelo = entityManager.find(AlocacaoVaga.class, id);
        return modelo;
    }

    @Override
    public List<AlocacaoVaga> retrieve(String atributo, String valor) {
        List<AlocacaoVaga> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select al_v From AlocacaoVaga al_v "
                + " where al_v." + atributo + " like '%" + valor + "%'",AlocacaoVaga.class).getResultList();
        return modelos;
    }

    @Override
    public void update(AlocacaoVaga objeto) {
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
    public void delete(AlocacaoVaga objeto) {
        try {
            entityManager.getTransaction().begin();
            AlocacaoVaga modelo = new AlocacaoVaga();
            modelo = entityManager.find(AlocacaoVaga.class, objeto.getId());
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
