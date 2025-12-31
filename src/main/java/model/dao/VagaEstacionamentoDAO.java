  package model.dao;

import java.util.List;
import model.VagaEstacionamento;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class VagaEstacionamentoDAO implements InterfaceDAO<VagaEstacionamento>{
private static VagaEstacionamentoDAO INSTANCE;
    protected EntityManager entityManager;
    
    public VagaEstacionamentoDAO(){
        entityManager = getEntityManager();
    }
    
    public static VagaEstacionamentoDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new VagaEstacionamentoDAO();
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
    public void create(VagaEstacionamento objeto) {
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
    public VagaEstacionamento retrieve(int id) {
        VagaEstacionamento modelo = new VagaEstacionamento();
        modelo = entityManager.find(VagaEstacionamento.class, id);
        return modelo;
    }

    @Override
    public List<VagaEstacionamento> retrieve(String atributo, String valor) {
        List<VagaEstacionamento> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select vg_e From VagaEstacionamento vg_e "
                + " where vg_e." + atributo + " like '%" + valor + "%'",VagaEstacionamento.class).getResultList();
        return modelos;
    }

    public List<VagaEstacionamento> retrieveAll() {
        List<VagaEstacionamento> modelos = new ArrayList<>();
        modelos = entityManager.createQuery("Select vg_e From VagaEstacionamento vg_e WHERE vg_e.status = :status ORDER BY vg_e.id",VagaEstacionamento.class)
                .setParameter("status", 'a').getResultList();
        return modelos;
    }
      
        
    @Override
    public void update(VagaEstacionamento objeto) {
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
    public void delete(VagaEstacionamento objeto) {
        try {
            entityManager.getTransaction().begin();
            VagaEstacionamento modelo = new VagaEstacionamento();
            modelo = entityManager.find(VagaEstacionamento.class, objeto.getId());
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
