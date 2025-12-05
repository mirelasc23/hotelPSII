package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Quarto;

public class QuartoDAO implements InterfaceDAO<Quarto>{

    @Override
    public void create(Quarto objeto) {
        String sqlInstrucao = "insert into quarto (descricao, capacidade_hospedes,"
                + " metragem, identificacao, andar, flag_animais,flag_bebe, flag_fumante, obs, status) values("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        
        try {        
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getCapacidadeHospedes());
            pstm.setFloat(3, objeto.getMetragem());
            pstm.setString(4, objeto.getIdentificacao());
            pstm.setInt(5, objeto.getAndar());
            pstm.setBoolean(6, objeto.isFlagAnimais());
            pstm.setBoolean(7, objeto.isFlagBebe());
            pstm.setBoolean(8, objeto.isFlagFumante());
            pstm.setString(9, objeto.getObs());
            pstm.setString(10, "a");
            
            JOptionPane.showMessageDialog(null, objeto);
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }
    }

    @Override
    public Quarto retrieve(int id) {
        String sqlInstrucao = "select id, descricao, capacidade_hospedes,"
                + " metragem, identificacao, andar, flag_animais,flag_bebe, flag_fumante, obs, status"
                + " from quarto where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Quarto quarto = new Quarto();
        
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while (rst.next()) {  
                System.out.println(rst);
                quarto.setId(rst.getInt("id"));
                quarto.setDescricao(rst.getString("descricao"));
                quarto.setCapacidadeHospedes(rst.getInt(3));
                quarto.setMetragem(rst.getFloat(4));
                quarto.setIdentificacao(rst.getString(5));
                quarto.setAndar(rst.getInt(6));
                quarto.setFlagAnimais(rst.getBoolean(7));
                quarto.setFlagBebe(rst.getBoolean(8));
                quarto.setFlagFumante(rst.getBoolean(9));
                quarto.setObs(rst.getString(10));
                quarto.setStatus(rst.getString(11).charAt(0));
                
                JOptionPane.showMessageDialog(null, quarto);
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
            
        }
        return quarto;
    }

    @Override
    public List<Quarto> retrieve(String atributo, String valor) {
        String sqlInstrucao = "select id, descricao, capacidade_hospedes,"
                + " metragem, identificacao, andar, flag_animais,flag_bebe, flag_fumante, obs, status"
                + " from quarto where " + atributo + " like ? COLLATE utf8mb4_unicode_ci";
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Quarto> quartos = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {    
                Quarto quarto = new Quarto();
                quarto.setId(rst.getInt("id"));
                quarto.setDescricao(rst.getString("descricao"));
                quarto.setCapacidadeHospedes(rst.getInt(3));
                quarto.setMetragem(rst.getFloat(4));
                quarto.setIdentificacao(rst.getString(5));
                quarto.setAndar(rst.getInt(6));
                quarto.setFlagAnimais(rst.getBoolean(7));
                quarto.setFlagBebe(rst.getBoolean(8));
                quarto.setFlagFumante(rst.getBoolean(9));
                quarto.setObs(rst.getString(10));
                quarto.setStatus(rst.getString(11).charAt(0));
                quartos.add(quarto);
                
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);            
        }
        
        return quartos;
    }

    @Override
    public void update(Quarto objeto) {
        String sqlInstrucao = "update quarto set descricao = ?,"
                + " capacidade_hospedes = ?, metragem = ?, identificacao = ?, andar = ?, flag_animais = ?, flag_bebe = ?, flag_fumante = ?, obs = ?, status = ? where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        
        try {        
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getDescricao());
            pstm.setInt(2, objeto.getCapacidadeHospedes());
            pstm.setFloat(3, objeto.getMetragem());
            pstm.setString(4, objeto.getIdentificacao());
            pstm.setInt(5, objeto.getAndar());
            pstm.setBoolean(6, objeto.isFlagAnimais());
            pstm.setBoolean(7, objeto.isFlagBebe());
            pstm.setBoolean(8, objeto.isFlagFumante());
            pstm.setString(9, objeto.getObs());
            pstm.setString(10, String.valueOf(objeto.getStatus()));
            pstm.setInt(11, objeto.getId());
            JOptionPane.showMessageDialog(null, objeto);
            
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }
    }

    @Override
    public void delete(Quarto objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
