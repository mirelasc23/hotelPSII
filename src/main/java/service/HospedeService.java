package service;

import java.util.List;
import model.Hospede;
import model.dao.HospedeDAO;

public class HospedeService {
    public static void Criar(Hospede objeto) {
        HospedeDAO.getInstance().create(objeto);
    }

    public static List<Hospede> Carregar() {
        return HospedeDAO.getInstance().retrieveAll();
    }

    
    public static Hospede Carregar(int id) {
        return HospedeDAO.getInstance().retrieve(id);
    }

   
    public static List<Hospede> Carregar(String atributo, String valor) {
        return HospedeDAO.getInstance().retrieve(atributo, valor);
    }

    
    public static void Atualizar(Hospede objeto) {
        HospedeDAO.getInstance().update(objeto);
    }

    public void deletar(Hospede objeto) {
        HospedeDAO.getInstance().delete(objeto);
    }
}
