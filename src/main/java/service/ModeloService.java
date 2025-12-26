package service;

import java.util.List;
import model.Modelo;
import model.dao.ModeloDAO;

public class ModeloService{

    public static void Criar(Modelo objeto) {
        ModeloDAO modeloDAO = new ModeloDAO();
        modeloDAO.create(objeto);
    }

    public static List<Modelo> Carregar() {
        return ModeloDAO.getInstance().retrieveAll();
    }

    public static Modelo Carregar(int id) {
        ModeloDAO modeloDAO = new ModeloDAO();
        return modeloDAO.retrieve(id);
    }

    public static List<Modelo> Carregar(String atributo, String valor) {
        ModeloDAO modeloDAO = new ModeloDAO();
        return modeloDAO.retrieve(atributo, valor);
    }

    public static void Atualizar(Modelo objeto) {
        ModeloDAO modeloDAO = new ModeloDAO();
        modeloDAO.update(objeto);
    }

    public static void Deletar(Modelo objeto) {
        ModeloDAO modeloDAO = new ModeloDAO();
        modeloDAO.delete(objeto);
    }
    
}
