package model.dao;

import java.util.List;
import model.Veiculo;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;


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
    
    public List<Veiculo> retrieveJoin(String parametro, String consulta) {
        List<Veiculo> modelos = new ArrayList<>();

        /*String jpql = "SELECT v FROM Veiculo v JOIN v.modelo mo JOIN mo.marca ma " +
                      "WHERE ma.id = :idFiltro OR ma.descricao LIKE :descFiltro";   original-ok*/
        String jpql = "SELECT v FROM Veiculo v JOIN";
        String busca;
        
        if(parametro.equals("marca")){
            busca = " v.modelo mo JOIN mo.marca ma " +
                      "WHERE ma.id = :idFiltro OR ma.descricao LIKE :descFiltro";
            //jpql.concat(busca);   || não funciona neste caso, pois ele cria uma nova string, mas nao altera a original
            jpql+=busca;
            JOptionPane.showMessageDialog(null, "definiu marca");
            JOptionPane.showMessageDialog(null, "jpql = " + jpql);
            
        } else if(parametro.equals("modelo")){
            busca = " v.modelo mo " +
                      "WHERE mo.id = :idFiltro OR mo.descricao LIKE :descFiltro";
            jpql+=busca;
            JOptionPane.showMessageDialog(null, "definiu modelo");
            JOptionPane.showMessageDialog(null, "jpql = " + jpql);
        } else{
            JOptionPane.showMessageDialog(null, "não definiu modelo, nem marca");
            JOptionPane.showMessageDialog(null, "jpql = " + jpql);
            
        }
        
        try {
            Query query = entityManager.createQuery(jpql, Veiculo.class);

            int idBusca;
            try {
                idBusca = Integer.parseInt(consulta);
            } catch (NumberFormatException e) {
                idBusca = -1; 
            }

            query.setParameter("idFiltro", idBusca);
            query.setParameter("descFiltro", "%" + consulta + "%");

            modelos = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modelos;
    }
    
    public List<Veiculo> retrieveAll() {
        List<Veiculo> modelos = new ArrayList<>();
        modelos = entityManager.createQuery("Select mo From Veiculo mo ORDER BY mo.id",Veiculo.class).getResultList();
        /*modelos = entityManager.createNativeQuery("SELECT * FROM hotel.modelo", Modelo.class).getResultList();*/
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
