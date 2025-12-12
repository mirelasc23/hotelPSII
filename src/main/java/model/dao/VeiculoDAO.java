package model.dao;

import java.util.List;
import model.Veiculo;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class VeiculoDAO implements InterfaceDAO<Veiculo>{
private static VeiculoDAO INSTANCE;
    protected EntityManager entityManager;
    
    public VeiculoDAO(){
        entityManager = getEntityManager();
    }
    
    public static VeiculoDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new VeiculoDAO();
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
    public void create(Veiculo objeto) {
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
    public Veiculo retrieve(int id) {
        Veiculo modelo = new Veiculo();
        modelo = entityManager.find(Veiculo.class, id);
        return modelo;
    }

    @Override
    public List<Veiculo> retrieve(String atributo, String valor) {
        List<Veiculo> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select vei From Veiculo vei "
                + " where forn." + atributo + " like '%" + valor + "%'",Veiculo.class).getResultList();
        return modelos;
    }

    @Override
    public void update(Veiculo objeto) {
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
    public void delete(Veiculo objeto) {
        try {
            entityManager.getTransaction().begin();
            Veiculo modelo = new Veiculo();
            modelo = entityManager.find(Veiculo.class, objeto.getId());
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
