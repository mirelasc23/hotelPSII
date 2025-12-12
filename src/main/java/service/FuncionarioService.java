package service;

import java.util.List;
import model.Funcionario;
import model.dao.FuncionarioDAO;

public class FuncionarioService {
    public static void Criar(Funcionario objeto) {
        FuncionarioDAO.getInstance().create(objeto);
    }

    
    public static Funcionario Carregar(int id) {
        return FuncionarioDAO.getInstance().retrieve(id);
    }

   
    public static List<Funcionario> Carregar(String atributo, String valor) {
        return FuncionarioDAO.getInstance().retrieve(atributo, valor);
    }

    
    public static void Atualizar(Funcionario objeto) {
        FuncionarioDAO.getInstance().update(objeto);
    }

    public void deletar(Funcionario objeto) {
        FuncionarioDAO.getInstance().delete(objeto);
    }
}
