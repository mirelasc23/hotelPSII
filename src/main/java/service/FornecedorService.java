package service;

import java.util.List;
import model.Fornecedor;
import model.dao.FornecedorDAO;

public class FornecedorService {
    public static void Criar(Fornecedor objeto) {
        FornecedorDAO.getInstance().create(objeto);
    }

    
    public static Fornecedor Carregar(int id) {
        return FornecedorDAO.getInstance().retrieve(id);
    }

   
    public static List<Fornecedor> Carregar(String atributo, String valor) {
        return FornecedorDAO.getInstance().retrieve(atributo, valor);
    }

    
    public static void Atualizar(Fornecedor objeto) {
        FornecedorDAO.getInstance().update(objeto);
    }

    public void deletar(Fornecedor objeto) {
        FornecedorDAO.getInstance().delete(objeto);
    }
}
