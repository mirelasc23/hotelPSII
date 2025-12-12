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
    //protected EntityManager em;
    
    public ProdutoCopaDAO(){
        //em = getEntityManager();
    }
    
    public static ProdutoCopaDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ProdutoCopaDAO();
        }
        return INSTANCE;
    }
    /*
    private EntityManager getEntityManager(){
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU");
            if(em == null){
                em = factory.createEntityManager();
            }
            return em;
    }*/
    
    @Override
    public void create(ProdutoCopa objeto) {
        EntityManager em = utilities.Utilities.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            // É fundamental fechar o EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public ProdutoCopa retrieve(int id) {
        EntityManager em = utilities.Utilities.getEntityManager();
        ProdutoCopa modelo = new ProdutoCopa();
        modelo = em.find(ProdutoCopa.class, id);
        return modelo;
    }

    @Override
    public List<ProdutoCopa> retrieve(String atributo, String valor) {
        EntityManager em = utilities.Utilities.getEntityManager();
        List<ProdutoCopa> modelos = new ArrayList<>();
        modelos = em.createQuery(" Select pc From ProdutoCopa pc "
                + " where pc." + atributo + " like '%" + valor + "%'",ProdutoCopa.class).getResultList();
        return modelos;
    }

    @Override
    public void update(ProdutoCopa objeto) {
        EntityManager em = utilities.Utilities.getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            // É fundamental fechar o EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void delete(ProdutoCopa objeto) {
        EntityManager em = utilities.Utilities.getEntityManager();
        try {
            em.getTransaction().begin();
            ProdutoCopa modelo = new ProdutoCopa();
            modelo = em.find(ProdutoCopa.class, objeto.getId());
            if(modelo != null){
                em.remove(modelo);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            // É fundamental fechar o EntityManager
            if (em != null) {
                em.close();
            }
        }
    }
}
