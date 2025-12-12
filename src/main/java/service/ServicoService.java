package service;

import java.util.List;
import model.Servico;
import model.dao.ServicoDAO;

public class ServicoService {
    public static void Criar(Servico objeto) {
        ServicoDAO.getInstance().create(objeto);
    }
    
    public static Servico Carregar(int id) {
        return ServicoDAO.getInstance().retrieve(id);
    }

    public static List<Servico> Carregar(String atributo, String valor) {
        return ServicoDAO.getInstance().retrieve(atributo, valor);
    }
    
    public static void Atualizar(Servico objeto) {
        ServicoDAO.getInstance().update(objeto);
    }

    public void deletar(Servico objeto) {
        ServicoDAO.getInstance().delete(objeto);
    }
}
