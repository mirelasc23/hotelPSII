package model.dao;

import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Hospede;

public class HospedeDAO implements InterfaceDAO<Hospede>{

    @Override
    public void create(Hospede objeto) {
        
        String sqlInstrucao = "insert into hospede (nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status, razao_social,"
                + " cnpj, inscricao_estadual, contato, sexo)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        /*String sqlInstrucao = "insert into hospede (default, " + objeto.getNome() + ", "
        + objeto.getFone1() + ", " + objeto.getFone2()+ ", "
        + objeto.getEmail()+ ", " + objeto.getCep()+ ", "
        + objeto.getLogradouro()+ ", " + objeto.getBairro()+ ", " 
        + objeto.getCidade()+ ", "+ objeto.getComplemento()+ ");";*/
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        
        try {        
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getCep());
            pstm.setString(6, objeto.getLogradouro());
            pstm.setString(7, objeto.getBairro());
            pstm.setString(8, objeto.getCidade());
            pstm.setString(9, objeto.getComplemento());
            pstm.setString(10, objeto.getDataCadastro());
            pstm.setString(11, objeto.getCpf());
            pstm.setString(12, objeto.getRg());
            pstm.setString(13, objeto.getObs());
            pstm.setString(14, String.valueOf(objeto.getStatus()));
            pstm.setString(15, objeto.getRazaoSocial());
            pstm.setString(16, objeto.getCnpj());
            pstm.setString(17, objeto.getInscricaoEstdual());
            pstm.setString(18, objeto.getContato());
            pstm.setString(19, String.valueOf(objeto.getSexo()));
            
            JOptionPane.showMessageDialog(null, objeto);
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }
    }

    @Override
    public Hospede retrieve(int id) {
        JOptionPane.showMessageDialog(null, "DAO");
        String sqlInstrucao = "select id, nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status, razao_social,"
                + " cnpj, inscricao_estadual, contato, sexo"
                + " from hospede where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Hospede hospede = new Hospede();
        
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while (rst.next()) {  
                System.out.println(rst);
                hospede.setId(rst.getInt("id"));
                hospede.setNome(rst.getString("nome"));
                hospede.setFone1(rst.getString("fone"));
                hospede.setFone2(rst.getString("fone2"));
                hospede.setEmail(rst.getString(5));
                hospede.setCep(rst.getString(6));
                hospede.setLogradouro(rst.getString(7));
                hospede.setBairro(rst.getString(8));
                hospede.setCidade(rst.getString(9));
                hospede.setComplemento(rst.getString(10));
                hospede.setDataCadastro(rst.getString(11));
                hospede.setCpf(rst.getString(12));
                hospede.setRg(rst.getString(13));
                hospede.setObs(rst.getString(14));
                hospede.setStatus(rst.getString(15).charAt(0));
                hospede.setRazaoSocial(rst.getString(16));
                hospede.setCnpj(rst.getString(17));
                hospede.setInscricaoEstdual(rst.getString(18));
                hospede.setContato(rst.getString(19));
                hospede.setSexo(rst.getString(20).charAt(0));
                
                JOptionPane.showMessageDialog(null, hospede);
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
            
        }
        
        return hospede;
        
        
    }

    @Override
    public List<Hospede> retrieve(String atributo, String valor) {
        String sqlInstrucao = "select id, nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status, razao_social,"
                + " cnpj, inscricao_estadual, contato, sexo"
                + " from hospede where " + atributo + " like ? COLLATE utf8mb4_unicode_ci";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Hospede> hospedes = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {    
                Hospede hospede = new Hospede();
                hospede.setId(rst.getInt("id"));
                hospede.setNome(rst.getString("nome"));
                hospede.setFone1(rst.getString("fone"));
                hospede.setFone2(rst.getString("fone2"));
                hospede.setEmail(rst.getString(5));
                hospede.setCep(rst.getString(6));
                hospede.setLogradouro(rst.getString(7));
                hospede.setBairro(rst.getString(8));
                hospede.setCidade(rst.getString(9));
                hospede.setComplemento(rst.getString(10));
                hospede.setDataCadastro(rst.getString(11));
                hospede.setCpf(rst.getString(12));
                hospede.setRg(rst.getString(13));
                hospede.setObs(rst.getString(14));
                hospede.setStatus(rst.getString(15).charAt(0));
                hospede.setRazaoSocial(rst.getString(16));
                hospede.setCnpj(rst.getString(17));
                hospede.setInscricaoEstdual(rst.getString(18));
                hospede.setContato(rst.getString(19));
                hospede.setSexo(rst.getString(20).charAt(0));
                hospedes.add(hospede);
                
                JOptionPane.showMessageDialog(null, "cadastro obtido");
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);            
        }
        
        return hospedes;
    }

    @Override
    public void update(Hospede objeto) {
        String sqlInstrucao = "update hospede set nome = ?,"
                + " fone = ?, fone2 = ?, email = ?, cep = ?, logradouro = ?, bairro = ?,"
                + " cidade = ?, complemento = ?, data_cadastro = ?, cpf = ?, rg = ?,"
                + " obs = ?, status = ?, razao_social = ?,"
                + " cnpj = ?, inscricao_estadual = ?, contato = ?, sexo = ?"
                + " where id = ?";
        /*String sqlInstrucao = "insert into hospede (default, " + objeto.getNome() + ", "
        + objeto.getFone1() + ", " + objeto.getFone2()+ ", "
        + objeto.getEmail()+ ", " + objeto.getCep()+ ", "
        + objeto.getLogradouro()+ ", " + objeto.getBairro()+ ", " 
        + objeto.getCidade()+ ", "+ objeto.getComplemento()+ ");";*/
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        
        try {        
            pstm = conexao.prepareStatement(sqlInstrucao);
            
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getFone1());
            pstm.setString(3, objeto.getFone2());
            pstm.setString(4, objeto.getEmail());
            pstm.setString(5, objeto.getCep());
            pstm.setString(6, objeto.getLogradouro());
            pstm.setString(7, objeto.getBairro());
            pstm.setString(8, objeto.getCidade());
            pstm.setString(9, objeto.getComplemento());
            pstm.setString(10, objeto.getDataCadastro());
            pstm.setString(11, objeto.getCpf());
            pstm.setString(12, objeto.getRg());
            pstm.setString(13, objeto.getObs());
            pstm.setString(14, String.valueOf(objeto.getStatus()));
            pstm.setString(15, objeto.getRazaoSocial());
            pstm.setString(16, objeto.getCnpj());
            pstm.setString(17, objeto.getInscricaoEstdual());
            pstm.setString(18, objeto.getContato());
            pstm.setString(19, String.valueOf(objeto.getSexo()));
            pstm.setInt(20, objeto.getId());
            JOptionPane.showMessageDialog(null, objeto);
            
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }
    }

    @Override
    public void delete(Hospede objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    
}
