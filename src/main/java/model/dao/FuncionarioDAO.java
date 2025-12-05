package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Funcionario;

public class FuncionarioDAO implements InterfaceDAO<Funcionario>{

    @Override
    public void create(Funcionario objeto) {
        String sqlInstrucao = "insert into funcionario (nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status, sexo, usuario, senha)"
                + " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
                + " ?, ?, ?, ?, ?, ?, ?)";
        
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
            pstm.setString(15, String.valueOf(objeto.getSexo()));
            pstm.setString(16, objeto.getUsuario());
            pstm.setString(17, objeto.getSenha());
            
            JOptionPane.showMessageDialog(null, objeto);
            pstm.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }
    }

    @Override
    public Funcionario retrieve(int id) {
        String sqlInstrucao = "select id, nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status,"
                + " sexo, usuario, senha"
                + " from funcionario where id = ?";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        Funcionario funcionario = new Funcionario();
        
        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setInt(1, id);
            rst = pstm.executeQuery();
            
            while (rst.next()) {  
                System.out.println(rst);
                funcionario.setId(rst.getInt("id"));
                funcionario.setNome(rst.getString("nome"));
                funcionario.setFone1(rst.getString("fone"));
                funcionario.setFone2(rst.getString("fone2"));
                funcionario.setEmail(rst.getString(5));
                funcionario.setCep(rst.getString(6));
                funcionario.setLogradouro(rst.getString(7));
                funcionario.setBairro(rst.getString(8));
                funcionario.setCidade(rst.getString(9));
                funcionario.setComplemento(rst.getString(10));
                funcionario.setDataCadastro(rst.getString(11));
                funcionario.setCpf(rst.getString(12));
                funcionario.setRg(rst.getString(13));
                funcionario.setObs(rst.getString(14));
                funcionario.setStatus(rst.getString(15).charAt(0));
                funcionario.setSexo(rst.getString(16).charAt(0));
                funcionario.setUsuario(rst.getString(17));
                funcionario.setSenha(rst.getString(18));
                
                JOptionPane.showMessageDialog(null, funcionario);
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
            
        }
        return funcionario;
    }

    @Override
    public List<Funcionario> retrieve(String atributo, String valor) {
        String sqlInstrucao = "select id, nome,"
                + " fone, fone2, email, cep, logradouro, bairro,"
                + " cidade, complemento, data_cadastro, cpf, rg,"
                + " obs, status,"
                + " sexo, usuario, senha"
                + " from funcionario where " + atributo + " like ? COLLATE utf8mb4_unicode_ci";
        
        Connection conexao = ConnectionFactoty.getConnection();    
        JOptionPane.showMessageDialog(null, "conexao ok");
        JOptionPane.showMessageDialog(null, conexao);
        PreparedStatement pstm = null;
        ResultSet rst = null;
        List<Funcionario> funcionarios = new ArrayList<>();

        try{
            pstm = conexao.prepareStatement(sqlInstrucao);
            pstm.setString(1, "%" + valor + "%");
            rst = pstm.executeQuery();
            
            while (rst.next()) {    
                Funcionario funcionario = new Funcionario();
                funcionario.setId(rst.getInt("id"));
                funcionario.setNome(rst.getString("nome"));
                funcionario.setFone1(rst.getString("fone"));
                funcionario.setFone2(rst.getString("fone2"));
                funcionario.setEmail(rst.getString(5));
                funcionario.setCep(rst.getString(6));
                funcionario.setLogradouro(rst.getString(7));
                funcionario.setBairro(rst.getString(8));
                funcionario.setCidade(rst.getString(9));
                funcionario.setComplemento(rst.getString(10));
                funcionario.setDataCadastro(rst.getString(11));
                funcionario.setCpf(rst.getString(12));
                funcionario.setRg(rst.getString(13));
                funcionario.setObs(rst.getString(14));
                funcionario.setStatus(rst.getString(15).charAt(0));
                funcionario.setSexo(rst.getString(16).charAt(0));
                funcionario.setUsuario(rst.getString(17));
                funcionario.setSenha(rst.getString(18));
                funcionarios.add(funcionario);
                
                JOptionPane.showMessageDialog(null, "cadastro obtido");
            }
            
        }catch(SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);            
        }
        
        return funcionarios;
    }

    @Override
    public void update(Funcionario objeto) {
        String sqlInstrucao = "update funcionario set nome = ?,"
                + " fone = ?, fone2 = ?, email = ?, cep = ?, logradouro = ?, bairro = ?,"
                + " cidade = ?, complemento = ?, data_cadastro = ?, cpf = ?, rg = ?,"
                + " obs = ?, status = ?, sexo = ?, usuario = ?, senha = ?"
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
            pstm.setString(15, String.valueOf(objeto.getSexo()));
            pstm.setString(16, objeto.getUsuario());
            pstm.setString(17, objeto.getSenha());
            pstm.setInt(18, objeto.getId());
            JOptionPane.showMessageDialog(null, objeto);
            
            pstm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactoty.closeConnecition(conexao, pstm);
        }
    }

    @Override
    public void delete(Funcionario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 }

