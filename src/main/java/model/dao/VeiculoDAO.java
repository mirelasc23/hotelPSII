package model.dao;

import java.util.List;
import model.Veiculo;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


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
                + " where vei." + atributo + " like '%" + valor + "%'",Veiculo.class).getResultList();
        return modelos;
    }
    
    public List<Veiculo> retrieveJoin(String consulta) {
                    List<Veiculo> modelos = new ArrayList<>();

        // Mudamos o nome do parâmetro do ID para :idFiltro
        String jpql = "SELECT v FROM Veiculo v JOIN v.modelo mo JOIN mo.marca ma" +
                      "WHERE ma.id = :idFiltro OR ma.descricao LIKE :descFiltro";

        try {
            Query query = entityManager.createQuery(jpql, Veiculo.class);

            // 1. Tenta converter a consulta para número. Se não for número, coloca um ID impossível (-1)
            int idBusca;
            try {
                idBusca = Integer.parseInt(consulta);
            } catch (NumberFormatException e) {
                idBusca = -1; 
            }

            // 2. Define os parâmetros separadamente
            query.setParameter("idFiltro", idBusca);
            query.setParameter("descFiltro", "%" + consulta + "%");

            modelos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
