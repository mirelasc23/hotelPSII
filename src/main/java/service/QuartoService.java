package service;

import java.util.List;
import model.Quarto;
import model.dao.QuartoDAO;

public class QuartoService {
    public static void Criar(Quarto objeto) {
        QuartoDAO.getInstance().create(objeto);
    }
    
    public static Quarto Carregar(int id) {
        return QuartoDAO.getInstance().retrieve(id);
    }

    public static List<Quarto> Carregar(String atributo, String valor) {
        return QuartoDAO.getInstance().retrieve(atributo, valor);
    }
    
    public static void Atualizar(Quarto objeto) {
        QuartoDAO.getInstance().update(objeto);
    }

    public void deletar(Quarto objeto) {
        QuartoDAO.getInstance().delete(objeto);
    }
}