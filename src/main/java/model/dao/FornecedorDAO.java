package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Fornecedor;
import model.Hospede;

public class FornecedorDAO implements InterfaceDAO<Fornecedor>{

    @Override
    public void create(Fornecedor objeto) {
        String sqlInstrucao = "insert into fornecedor (nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status, razao_social,"
                + " cnpj, inscricao_estadual, contato, sexo)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
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
            pstm.setString(17, objeto.getInscricaoEstadual());
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
    public Fornecedor retrieve(int id) {
        JOptionPane.showMessageDialog(null, "DAO");
        String sqlInstrucao = "select id, nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status, razao_social,"
                + " cnpj, inscricao_estadual, contato, sexo"
                + " from fornecedor where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Fornecedor fornecedor = new Fornecedor();
        
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while (rst.next()) {  
                System.out.println(rst);
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString(5));
                fornecedor.setCep(rst.getString(6));
                fornecedor.setLogradouro(rst.getString(7));
                fornecedor.setBairro(rst.getString(8));
                fornecedor.setCidade(rst.getString(9));
                fornecedor.setComplemento(rst.getString(10));
                fornecedor.setDataCadastro(rst.getString(11));
                fornecedor.setCpf(rst.getString(12));
                fornecedor.setRg(rst.getString(13));
                fornecedor.setObs(rst.getString(14));
                fornecedor.setStatus(rst.getString(15).charAt(0));
                fornecedor.setRazaoSocial(rst.getString(16));
                fornecedor.setCnpj(rst.getString(17));
                fornecedor.setInscricaoEstadual(rst.getString(18));
                fornecedor.setContato(rst.getString(19));
                fornecedor.setSexo(rst.getString(20).charAt(0));
                
                JOptionPane.showMessageDialog(null, fornecedor);
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
            
        }
        return fornecedor;
    }

    @Override
    public List<Fornecedor> retrieve(String atributo, String valor) {
        String sqlInstrucao = "select id, nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status, razao_social,"
                + " cnpj, inscricao_estadual, contato, sexo"
                + " from fornecedor where " + atributo + " like ? COLLATE utf8mb4_unicode_ci";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Fornecedor> fornecedores = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {    
                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setId(rst.getInt("id"));
                fornecedor.setNome(rst.getString("nome"));
                fornecedor.setFone1(rst.getString("fone"));
                fornecedor.setFone2(rst.getString("fone2"));
                fornecedor.setEmail(rst.getString(5));
                fornecedor.setCep(rst.getString(6));
                fornecedor.setLogradouro(rst.getString(7));
                fornecedor.setBairro(rst.getString(8));
                fornecedor.setCidade(rst.getString(9));
                fornecedor.setComplemento(rst.getString(10));
                fornecedor.setDataCadastro(rst.getString(11));
                fornecedor.setCpf(rst.getString(12));
                fornecedor.setRg(rst.getString(13));
                fornecedor.setObs(rst.getString(14));
                fornecedor.setStatus(rst.getString(15).charAt(0));
                fornecedor.setRazaoSocial(rst.getString(16));
                fornecedor.setCnpj(rst.getString(17));
                fornecedor.setInscricaoEstadual(rst.getString(18));
                fornecedor.setContato(rst.getString(19));
                fornecedor.setSexo(rst.getString(20).charAt(0));
                fornecedores.add(fornecedor);
                
                JOptionPane.showMessageDialog(null, "cadastro obtido");
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
            ex.getErrorCode();
            ex.getMessage();
            ex.getCause();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);            
        }
        
        return fornecedores;
    }

    @Override
    public void update(Fornecedor objeto) {
        String sqlInstrucao = "update fornecedor set nome = ?,"
                + " fone = ?, fone2 = ?, email = ?, cep = ?, logradouro = ?, bairro = ?,"
                + " cidade = ?, complemento = ?, data_cadastro = ?, cpf = ?, rg = ?,"
                + " obs = ?, status = ?, razao_social = ?,"
                + " cnpj = ?, inscricao_estadual = ?, contato = ?, sexo = ?"
                + " where id = ?";
        
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
            pstm.setString(17, objeto.getInscricaoEstadual());
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
    public void delete(Fornecedor objeto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
