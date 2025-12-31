package model.dao;

import java.util.List;
import model.Quarto;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;


public class QuartoDAO implements InterfaceDAO<Quarto>{
private static QuartoDAO INSTANCE;
    protected EntityManager entityManager;
    
    public QuartoDAO(){
        entityManager = getEntityManager();
    }
    
    public static QuartoDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new QuartoDAO();
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
    public void create(Quarto objeto) {
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
    public Quarto retrieve(int id) {
        Quarto modelo = new Quarto();
        modelo = entityManager.find(Quarto.class, id);
        return modelo;
    }

    @Override
    public List<Quarto> retrieve(String atributo, String valor) {
        List<Quarto> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select qu From Quarto qu "
                + " where qu." + atributo + " like '%" + valor + "%'",Quarto.class).getResultList();
        return modelos;
    }

    public List<Quarto> retrieveAll() {
        TypedQuery<Quarto> query = entityManager.createQuery("Select qu From Quarto qu ORDER BY qu.id",Quarto.class);
        //TypedQuery<Quarto> query = entityManager.createQuery("Select qu From Quarto qu WHERE qu.status = :status ORDER BY qu.id",Quarto.class);
        query.setMaxResults(30);
        //query.setParameter("status", 'l');
        
        List<Quarto> quartos = new ArrayList<>();
        quartos = query.getResultList();
        return quartos;
    }

    @Override
    public void update(Quarto objeto) {
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
    public void delete(Quarto objeto) {
        try {
            entityManager.getTransaction().begin();
            Quarto modelo = new Quarto();
            modelo = entityManager.find(Quarto.class, objeto.getId());
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
