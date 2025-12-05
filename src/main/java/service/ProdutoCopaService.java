package service;

import java.util.List;
import model.ProdutoCopa;
import model.dao.ProdutoCopaDAO;

public class ProdutoCopaService{

    public static void Criar(ProdutoCopa objeto) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        produtoCopaDAO.create(objeto);
    }

    public static ProdutoCopa Carregar(int id) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        return produtoCopaDAO.retrieve(id);
    }

    public static List<ProdutoCopa> Carregar(String atributo, String valor) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        return produtoCopaDAO.retrieve(atributo, valor);
    }

    public static void Atualizar(ProdutoCopa objeto) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        produtoCopaDAO.update(objeto);
    }

    public static void Deletar(ProdutoCopa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
