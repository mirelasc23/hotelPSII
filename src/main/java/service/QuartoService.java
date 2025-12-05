package service;

import java.util.List;
import model.Quarto;
import model.dao.QuartoDAO;

public class QuartoService {

    public static void Criar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.create(objeto);
    }

    public static Quarto Carregar(int id) {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.retrieve(id);
    }

    public static List<Quarto> Carregar(String atributo, String valor) {
        QuartoDAO quartoDAO = new QuartoDAO();
        return quartoDAO.retrieve(atributo, valor);
    }

    public static void Atualizar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.update(objeto);
    }

    public static void Deletar(Quarto objeto) {
        QuartoDAO quartoDAO = new QuartoDAO();
        quartoDAO.delete(objeto);
    }
    
}
