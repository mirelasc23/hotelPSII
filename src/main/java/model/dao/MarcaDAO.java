package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.persistence.Persistence;
import model.Marca;

public class MarcaDAO implements InterfaceDAO<Marca>{
    private static MarcaDAO INSTANCE;
    protected EntityManager entityManager;
    
    public MarcaDAO(){
        entityManager = getEntityManager();
    }
    
    public static MarcaDAO getInstance(){
        if(INSTANCE == null){
            INSTANCE = new MarcaDAO();
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
    public void create(Marca objeto) {
        try {
            //envia para o BD (operacao IO), mas falta encapsular com try-catch
            this.entityManager.getTransaction().begin();
            this.entityManager.persist(objeto);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.entityManager.getTransaction().rollback();
        }
        
        /*String sqlInstrucao = "insert into marca (descricao) values(?)";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        
        try {        
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            
            JOptionPane.showMessageDialog(null, objeto);
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }*/
    
    }

    @Override
    public Marca retrieve(int id) {
        Marca marca = new Marca();
        marca = entityManager.find(Marca.class, id);
        return marca;
        
        /*Marca marca = entityManager.find(Marca.class, id);
        return marca;
        
        


        /*String sqlInstrucao = "select id, descricao, status"
                + " from marca where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Marca marca = new Marca();
        
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while (rst.next()) {  
                System.out.println(rst);
                marca.setId(rst.getInt("id"));
                marca.setDescricao(rst.getString("descricao"));
                marca.setStatus(rst.getString(3).charAt(0));
                
                JOptionPane.showMessageDialog(null, marca);
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
            
        }
        return marca;*/
    }

    @Override
    public List<Marca> retrieve(String atributo, String valor) {
        List<Marca> marcas = new ArrayList<>();
        marcas = entityManager.createQuery(" Select mar From Marca mar "
                + " where mar." + atributo + " like '%" + valor + "%'",Marca.class).getResultList();
        return marcas;
        
        /*String sqlInstrucao = "select id, descricao, status"
                + " from marca where " + atributo + " like ? COLLATE utf8mb4_unicode_ci";
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Marca> marcas = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {    
                Marca marca = new Marca();
                marca.setId(rst.getInt("id"));
                marca.setDescricao(rst.getString("descricao"));
                marca.setStatus(rst.getString(3).charAt(0));
                marcas.add(marca);
                
                
                //JOptionPane.showMessageDialog(null, "cadastro obtido");
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);            
        }
        
        return marcas;*/
    }
    
    
    public List<Marca> retrieveAll() {
        List<Marca> marcas = new ArrayList<>();
        marcas = entityManager.createQuery(" Select mar From Marca mar",Marca.class).getResultList();
        return marcas;
        /*String sqlInstrucao = "select id, descricao, status"
                + " from marca ";
        Connection conexao = ConnectionFactoty.getConnection();    
        //JOptionPane.showMessageDialog(null, "conexao ok");
        //JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Marca> marcas = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            //pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {    
                Marca marca = new Marca();
                marca.setId(rst.getInt("id"));
                marca.setDescricao(rst.getString("descricao"));
                marca.setStatus(rst.getString(3).charAt(0));
                marcas.add(marca);
                
                
                //JOptionPane.showMessageDialog(null, "cadastro obtido");
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);            
        }
        
        return marcas;*/
    }
    
    public List<String> retrieveCheckBox() {
        //TypedQuery<Modelo> query = entityManager.createQuery("Select mo From Modelo mo ORDER BY mo.id",Modelo.class);
        
        List<Marca> model = new ArrayList<>();
        model = retrieveAll();
        
        List<String> modelos = new ArrayList<>();
        for (Marca modelo : model) {
            modelos.add(modelo.getDescricao());
        }
        return modelos;
    }

    @Override
    public void update(Marca objeto) {
        //com o framework, só precisa de try-catch quando for operacao de IO
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(objeto);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        
        /*
        String sqlInstrucao = "update marca set descricao = ?,"
                + "  status = ? where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        
        try {        
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setString(2, String.valueOf(objeto.getStatus()));
            pstm.setInt(3, objeto.getId());
            JOptionPane.showMessageDialog(null, objeto);
            
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }*/
    }

    @Override
    public void delete(Marca objeto) {
        //NOTA/MACETE: quando manda deletar direto, não funciona. Tem que selecionar o objeto para então, com  ele na memória
        try {
            entityManager.getTransaction().begin();
            Marca marca = new Marca();
            marca = entityManager.find(Marca.class, objeto.getId());
            if(marca != null){
                entityManager.remove(marca);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
}
