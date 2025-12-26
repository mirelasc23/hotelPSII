package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Funcionario;

public class FuncionarioDAO implements InterfaceDAO<Funcionario>{
private static FuncionarioDAO INSTANCE;
    protected EntityManager entityManager;
    
    public FuncionarioDAO(){
        entityManager = getEntityManager();
    }
    
    public static FuncionarioDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new FuncionarioDAO();
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
    public void create(Funcionario objeto) {
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
    public Funcionario retrieve(int id) {
        Funcionario funcionario = new Funcionario();
        funcionario = entityManager.find(Funcionario.class, id);
        return funcionario;
    }

    @Override
    public List<Funcionario> retrieve(String atributo, String valor) {
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = entityManager.createQuery(" Select f From Funcionario f "
                + " where f." + atributo + " like '%" + valor + "%'",Funcionario.class).getResultList();
        return funcionarios;
    }
    
    public List<Funcionario> retrieveAll() {
        TypedQuery<Funcionario> query = entityManager.createQuery("Select f From Funcionario f ORDER BY f.id",Funcionario.class);
        query.setMaxResults(30);   // Limit: Pega os próximos 5
        
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = query.getResultList();
        return funcionarios;
    }

    @Override
    public void update(Funcionario objeto) {
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
    public void delete(Funcionario objeto) {
        try {
            entityManager.getTransaction().begin();
            Funcionario funcionario = new Funcionario();
            funcionario = entityManager.find(Funcionario.class, objeto.getId());
            if(funcionario != null){
                entityManager.remove(funcionario);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
}
