package model.dao;

import java.util.List;
import model.Servico;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ServicoDAO implements InterfaceDAO<Servico>{
private static ServicoDAO INSTANCE;
    protected EntityManager entityManager;
    
    public ServicoDAO(){
        entityManager = getEntityManager();
    }
    
    public static ServicoDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ServicoDAO();
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
    public void create(Servico objeto) {
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
    public Servico retrieve(int id) {
        Servico modelo = new Servico();
        modelo = entityManager.find(Servico.class, id);
        return modelo;
    }

    @Override
    public List<Servico> retrieve(String atributo, String valor) {
        List<Servico> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mar From modelo mar "
                + " where " + atributo + " like (%" + valor + "%)",Servico.class).getResultList();
        return modelos;
    }

    @Override
    public void update(Servico objeto) {
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
    public void delete(Servico objeto) {
        try {
            entityManager.getTransaction().begin();
            Servico modelo = new Servico();
            modelo = entityManager.find(Servico.class, objeto.getId());
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
