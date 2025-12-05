package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Modelo;
import model.Modelo;

public class ModeloDAO implements InterfaceDAO<Modelo>{

    @Override
    public void create(Modelo objeto) {
        String sqlInstrucao = "insert into modelo (descricao) values(?)";
        
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
        }
    
    }

    @Override
    public Modelo retrieve(int id) {
        String sqlInstrucao = "select id, descricao, status"
                + " from modelo where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Modelo modelo = new Modelo();
        
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while (rst.next()) {  
                System.out.println(rst);
                modelo.setId(rst.getInt("id"));
                modelo.setDescricao(rst.getString("descricao"));
                modelo.setStatus(rst.getString(3).charAt(0));
                
                JOptionPane.showMessageDialog(null, modelo);
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
            
        }
        return modelo;
    }

    @Override
    public List<Modelo> retrieve(String atributo, String valor) {
        String sqlInstrucao = "select id, descricao, status"
                + " from modelo where " + atributo + " like ? COLLATE utf8mb4_unicode_ci";
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Modelo> modelos = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {    
                Modelo modelo = new Modelo();
                modelo.setId(rst.getInt("id"));
                modelo.setDescricao(rst.getString("descricao"));
                modelo.setStatus(rst.getString(3).charAt(0));
                modelos.add(modelo);
                
                
                //JOptionPane.showMessageDialog(null, "cadastro obtido");
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);            
        }
        
        return modelos;
    }

    @Override
    public void update(Modelo objeto) {
        String sqlInstrucao = "update modelo set descricao = ?,"
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
        }
    }

    @Override
    public void delete(Modelo objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
