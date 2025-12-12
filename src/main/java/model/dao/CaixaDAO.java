package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Caixa;

public class CaixaDAO implements InterfaceDAO<Caixa>{
private static CaixaDAO INSTANCE;
    protected EntityManager entityManager;
    
    public CaixaDAO(){
        entityManager = getEntityManager();
    }
    
    public static CaixaDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new CaixaDAO();
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
    public void create(Caixa objeto) {
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
    public Caixa retrieve(int id) {
        Caixa caixa = new Caixa();
        caixa = entityManager.find(Caixa.class, id);
        return caixa;
    }

    @Override
    public List<Caixa> retrieve(String atributo, String valor) {
        List<Caixa> caixas = new ArrayList<>();
        caixas = entityManager.createQuery(" Select cai From Caixa cai "
                + " where forn." + atributo + " like '%" + valor + "%'",Caixa.class).getResultList();
        return caixas;
    }

    @Override
    public void update(Caixa objeto) {
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
    public void delete(Caixa objeto) {
        try {
            entityManager.getTransaction().begin();
            Caixa caixa = new Caixa();
            caixa = entityManager.find(Caixa.class, objeto.getId());
            if(caixa != null){
                entityManager.remove(caixa);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
