package service;

import java.util.List;
import model.Fornecedor;
import model.dao.FornecedorDAO;

public class FornecedorService {

    public static void Criar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.create(objeto);
    }

    
    public static Fornecedor Carregar(int id) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(id);
    }

   
    public static List<Fornecedor> Carregar(String atributo, String valor) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        return fornecedorDAO.retrieve(atributo, valor);
    }

    
    public static void Atualizar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.update(objeto);
    }

    public void deletar(Fornecedor objeto) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();
        fornecedorDAO.delete(objeto);
    }
    
}
