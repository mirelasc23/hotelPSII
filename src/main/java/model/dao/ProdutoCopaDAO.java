package model.dao;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ProdutoCopa;

public class ProdutoCopaDAO implements InterfaceDAO<ProdutoCopa>{

    @Override
    public void create(ProdutoCopa objeto) {
        String sqlInstrucao = "insert into produto_copa (decricao, valor, obs) values(?, ?, ?)";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        
        try {        
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setFloat(2, objeto.getValor());
            pstm.setString(3, objeto.getObs());
            
            JOptionPane.showMessageDialog(null, objeto);
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }
    }

    @Override
    public ProdutoCopa retrieve(int id) {
        String sqlInstrucao = "select id, decricao, valor, obs, status"
                + " from produto_copa where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        ProdutoCopa produtoCopa = new ProdutoCopa();
        
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while (rst.next()) {  
                System.out.println(rst);
                produtoCopa.setId(rst.getInt("id"));
                produtoCopa.setDescricao(rst.getString("decricao"));
                produtoCopa.setValor(rst.getFloat("valor"));
                produtoCopa.setObs(rst.getString(4));
                produtoCopa.setStatus(rst.getString(5).charAt(0));
                
                JOptionPane.showMessageDialog(null, produtoCopa);
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
            
        }
        return produtoCopa;
    }

    @Override
    public List<ProdutoCopa> retrieve(String atributo, String valor) {
        String sqlInstrucao = "select id, decricao, valor, obs, status"
                + " from produto_copa where " + atributo + " like ? COLLATE utf8mb4_unicode_ci";
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<ProdutoCopa> produtoCopas = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {    
                ProdutoCopa produtoCopa = new ProdutoCopa();
                produtoCopa.setId(rst.getInt("id"));
                produtoCopa.setDescricao(rst.getString("decricao"));
                produtoCopa.setValor(rst.getFloat("valor"));
                produtoCopa.setObs(rst.getString(4));
                produtoCopa.setStatus(rst.getString(5).charAt(0));
                produtoCopas.add(produtoCopa);
                
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);            
        }
        
        return produtoCopas;
    }

    @Override
    public void update(ProdutoCopa objeto) {
        String sqlInstrucao = "update produto_copa set decricao = ?,"
                + " valor = ?, obs = ?, status = ? where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        
        try {        
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setFloat(2, objeto.getValor());
            pstm.setString(3, objeto.getObs());
            pstm.setString(4, String.valueOf(objeto.getStatus()));
            pstm.setInt(5, objeto.getId());
            JOptionPane.showMessageDialog(null, objeto);
            
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }
    }

    @Override
    public void delete(ProdutoCopa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
