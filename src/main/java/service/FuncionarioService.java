package service;

import java.util.List;
import model.Funcionario;
import model.dao.FuncionarioDAO;

public class FuncionarioService {

    public static void Criar(Funcionario objeto) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.create(objeto);
    }

    public static Funcionario Carregar(int id) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.retrieve(id);
    }

    public static List<Funcionario> Carregar(String atributo, String valor) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        return funcionarioDAO.retrieve(atributo, valor);
    }

    public static void Atualizar(Funcionario objeto) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.update(objeto);
    }

    public static void deletar(Funcionario objeto) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        funcionarioDAO.delete(objeto);
    }
    
}
