package model.dao;

import java.util.List;
import model.MovimentoCaixa;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MovimentoCaixaDAO implements InterfaceDAO<MovimentoCaixa>{
private static MovimentoCaixaDAO INSTANCE;
    protected EntityManager entityManager;
    
    public MovimentoCaixaDAO(){
        entityManager = getEntityManager();
    }
    
    public static MovimentoCaixaDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MovimentoCaixaDAO();
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
    public void create(MovimentoCaixa objeto) {
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
    public MovimentoCaixa retrieve(int id) {
        MovimentoCaixa modelo = new MovimentoCaixa();
        modelo = entityManager.find(MovimentoCaixa.class, id);
        return modelo;
    }

    @Override
    public List<MovimentoCaixa> retrieve(String atributo, String valor) {
        List<MovimentoCaixa> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mv_cx From MovimentoCaixa mv_cx "
                + " where mv_cx." + atributo + " like '%" + valor + "%'",MovimentoCaixa.class).getResultList();
        return modelos;
    }

    @Override
    public void update(MovimentoCaixa objeto) {
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
    public void delete(MovimentoCaixa objeto) {
        try {
            entityManager.getTransaction().begin();
            MovimentoCaixa modelo = new MovimentoCaixa();
            modelo = entityManager.find(MovimentoCaixa.class, objeto.getId());
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
