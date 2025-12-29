package service;

import java.util.List;
import model.VagaEstacionamento;
import model.dao.VagaEstacionamentoDAO;

public class VagaEstacionamentoService{

    public static void Criar(VagaEstacionamento objeto) {
        VagaEstacionamentoDAO.getInstance().create(objeto);
    }

    public static VagaEstacionamento Carregar(int id) {
        return VagaEstacionamentoDAO.getInstance().retrieve(id);
    }

    public static List<VagaEstacionamento> Carregar(String atributo, String valor) {
        return VagaEstacionamentoDAO.getInstance().retrieve(atributo, valor);
    }

    public static void Atualizar(VagaEstacionamento objeto) {
        VagaEstacionamentoDAO.getInstance().update(objeto);
    }

    public static void Deletar(VagaEstacionamento objeto) {
        VagaEstacionamentoDAO.getInstance().delete(objeto);
    }
    
}
