package service;

import java.util.List;
import model.ProdutoCopa;
import model.dao.ProdutoCopaDAO;

public class ProdutoCopaService{

    public static void Criar(ProdutoCopa objeto) {
        ProdutoCopaDAO.getInstance().create(objeto);
    }

    public static List<ProdutoCopa> Carregar() {
        return ProdutoCopaDAO.getInstance().retrieveAll();
    }

    public static ProdutoCopa Carregar(int id) {
        return ProdutoCopaDAO.getInstance().retrieve(id);
    }

    public static List<ProdutoCopa> Carregar(String atributo, String valor) {
        return ProdutoCopaDAO.getInstance().retrieve(atributo, valor);
    }

    public static void Atualizar(ProdutoCopa objeto) {
        ProdutoCopaDAO produtoCopaDAO = new ProdutoCopaDAO();
        produtoCopaDAO.update(objeto);
    }

    public static void Deletar(ProdutoCopa objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
