package model.dao;

import java.util.List;
import model.Reserva;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ReservaDAO implements InterfaceDAO<Reserva>{
private static ReservaDAO INSTANCE;
    protected EntityManager entityManager;
    
    public ReservaDAO(){
        entityManager = getEntityManager();
    }
    
    public static ReservaDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ReservaDAO();
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
    public void create(Reserva objeto) {
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
    public Reserva retrieve(int id) {
        Reserva modelo = new Reserva();
        modelo = entityManager.find(Reserva.class, id);
        return modelo;
    }

    @Override
    public List<Reserva> retrieve(String atributo, String valor) {
        List<Reserva> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select res From Reserva res "
                + " where res." + atributo + " like '%" + valor + "%'",Reserva.class).getResultList();
        return modelos;
    }

    @Override
    public void update(Reserva objeto) {
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
    public void delete(Reserva objeto) {
        try {
            entityManager.getTransaction().begin();
            Reserva modelo = new Reserva();
            modelo = entityManager.find(Reserva.class, objeto.getId());
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
