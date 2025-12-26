package service;

import java.util.List;
import model.Marca;
import model.dao.MarcaDAO;

public class MarcaService {
    public static void Criar(Marca objeto) {
        MarcaDAO.getInstance().create(objeto);
        /*MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.create(objeto);*/
    }

    public static List<Marca> Carregar() {
        return MarcaDAO.getInstance().retrieveAll();
    }

    public static Marca Carregar(int id) {
        return MarcaDAO.getInstance().retrieve(id);
        /*MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrieve(id);*/
    }

   
    public static List<Marca> Carregar(String atributo, String valor) {
        return MarcaDAO.getInstance().retrieve(atributo, valor);
        /*MarcaDAO marcaDAO = new MarcaDAO();
        return marcaDAO.retrieve(atributo, valor);*/
    }

    
    public static void Atualizar(Marca objeto) {
        MarcaDAO.getInstance().update(objeto);
        /*MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.update(objeto);*/
    }

    public void deletar(Marca objeto) {
        MarcaDAO.getInstance().delete(objeto);
        /*MarcaDAO marcaDAO = new MarcaDAO();
        marcaDAO.delete(objeto);*/
    }
}
