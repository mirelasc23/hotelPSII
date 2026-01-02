package service;

import java.util.List;
import model.Veiculo;
import model.dao.VeiculoDAO;

public class VeiculoService{

    public static void Criar(Veiculo objeto) {
        VeiculoDAO.getInstance().create(objeto);
    }

    public static List<Veiculo> Carregar() {
        return VeiculoDAO.getInstance().retrieveAll();
    }
    
    public static List<String> CarregarCheckBox() {
        return VeiculoDAO.getInstance().retrieveCheckBox();
    }

    public static Veiculo Carregar(int id) {
        return VeiculoDAO.getInstance().retrieve(id);
    }

    public static List<Veiculo> Carregar(String atributo, String valor) {
        return VeiculoDAO.getInstance().retrieve(atributo, valor);
    }
    
    public static List<Veiculo> ConsultaJoin(String consulta) {
        return VeiculoDAO.getInstance().retrieveJoin(consulta);
    }

    public static void Atualizar(Veiculo objeto) {
        VeiculoDAO.getInstance().update(objeto);
    }

    public static void Deletar(Veiculo objeto) {
        VeiculoDAO.getInstance().delete(objeto);
    }
    
}
