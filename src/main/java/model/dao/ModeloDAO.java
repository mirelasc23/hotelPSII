package model.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Modelo;

public class ModeloDAO implements InterfaceDAO<Modelo>{
    private static ModeloDAO INSTANCE;
    protected EntityManager entityManager;
    
    public ModeloDAO(){
        entityManager = getEntityManager();
    }
    
    public static ModeloDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new ModeloDAO();
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
    public void create(Modelo objeto) {
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
    public Modelo retrieve(int id) {
        Modelo modelo = new Modelo();
        modelo = entityManager.find(Modelo.class, id);
        return modelo;
    }

    @Override
    public List<Modelo> retrieve(String atributo, String valor) {
        List<Modelo> modelos = new ArrayList<>();
        modelos = entityManager.createQuery(" Select mo From Modelo mo"
        /*linha 56*/        + " where mo." + atributo + " like '%" + valor + "%'",Modelo.class).getResultList();
        return modelos;
    }
    
    public List<Modelo> retrieveJoin(String consulta) {
        List<Modelo> modelos = new ArrayList<>();

        // Mudamos o nome do parâmetro do ID para :idFiltro
        String jpql = "SELECT mo FROM Modelo mo JOIN mo.marca ma " +
                      "WHERE ma.id = :idFiltro OR ma.descricao LIKE :descFiltro";

        try {
            var query = entityManager.createQuery(jpql, Modelo.class);

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
        
        /*List<Modelo> modelos = new ArrayList<>();
        /*modelos = entityManager.createQuery(" Select mo From Modelo mo JOIN FETCH mo.marca"
        /*linha 56        + " where mo." + atributo + " like '%" + valor + "%'",Modelo.class).getResultList();
        
        String jpql = "SELECT mo FROM Modelo mo JOIN mo.marca ma " +
                  "WHERE ma.id = :filtro OR ma.descricao LIKE :filtro";
    
        try {
            modelos = entityManager.createQuery(jpql, Modelo.class)
                        .setParameter("filtro", "%" + consulta + "%")
                        .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelos;*/
    }
    
    public List<Modelo> retrieveAll() {
        List<Modelo> modelos = new ArrayList<>();
        modelos = entityManager.createQuery("Select mo From Modelo mo ORDER BY mo.id",Modelo.class).getResultList();
        /*modelos = entityManager.createNativeQuery("SELECT * FROM hotel.modelo", Modelo.class).getResultList();*/
        return modelos;
    }
    
    public List<String> retrieveCheckBox() {        
        List<Modelo> model = new ArrayList<>();
        model = retrieveAll();
        
        List<String> modelos = new ArrayList<>();
        for (Modelo modelo : model) {
            modelos.add(modelo.getDescricao());
        }
        return modelos;
    }

    @Override
    public void update(Modelo objeto) {
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
    public void delete(Modelo objeto) {
        try {
            entityManager.getTransaction().begin();
            Modelo modelo = new Modelo();
            modelo = entityManager.find(Modelo.class, objeto.getId());
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
