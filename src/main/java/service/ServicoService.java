package service;

import java.util.List;
import model.Servico;
import model.dao.ServicoDAO;

public class ServicoService {
    
    public static void Criar(Servico objeto) {
        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.create(objeto);
    }

    public static Servico Carregar(int id) {
        ServicoDAO servicoDAO = new ServicoDAO();
        return servicoDAO.retrieve(id);
    }

    public static List<Servico> Carregar(String atributo, String valor) {
        ServicoDAO servicoDAO = new ServicoDAO();
        return servicoDAO.retrieve(atributo, valor);
    }

    public static void Atualizar(Servico objeto) {
        ServicoDAO servicoDAO = new ServicoDAO();
        servicoDAO.update(objeto);
    }

    public static void Deletar(Servico objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
