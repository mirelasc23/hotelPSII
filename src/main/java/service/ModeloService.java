package service;

import java.util.List;
import model.Modelo;
import model.dao.ModeloDAO;

public class ModeloService{

    public static void Criar(Modelo objeto) {
        ModeloDAO.getInstance().create(objeto);
    }

    public static List<Modelo> Carregar() {
        return ModeloDAO.getInstance().retrieveAll();
    }
    
    public static List<String> CarregarCheckBox() {
        return ModeloDAO.getInstance().retrieveCheckBox();
    }

    public static Modelo Carregar(int id) {
        return ModeloDAO.getInstance().retrieve(id);
    }

    public static List<Modelo> Carregar(String atributo, String valor) {
        return ModeloDAO.getInstance().retrieve(atributo, valor);
    }

    public static void Atualizar(Modelo objeto) {
        ModeloDAO.getInstance().update(objeto);
    }

    public static void Deletar(Modelo objeto) {
        ModeloDAO.getInstance().delete(objeto);
    }
    
}
