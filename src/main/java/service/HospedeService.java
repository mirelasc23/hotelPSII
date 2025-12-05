package service;

import java.util.List;
import javax.swing.JOptionPane;
import model.Hospede;
import model.dao.HospedeDAO;

public class HospedeService {

    public static void criar(Hospede objeto) {
        HospedeDAO hospedeDAO = new HospedeDAO();
        hospedeDAO.create(objeto);
    }

    public static Hospede Carregar(int id) {
        HospedeDAO hospedeDAO = new HospedeDAO();
        JOptionPane.showMessageDialog(null, "SERVICE");
        return hospedeDAO.retrieve(id);
    }

    public static List<Hospede> Carregar(String atributo, String valor) {
        HospedeDAO hospedeDAO = new HospedeDAO();
        return hospedeDAO.retrieve(atributo, valor);
    }

    public static void atualizar(Hospede objeto) {
        HospedeDAO hospedeDAO = new HospedeDAO();
        hospedeDAO.update(objeto);
    }

    public static void deletar(Hospede objeto) {
        HospedeDAO hospedeDAO = new HospedeDAO();
        hospedeDAO.delete(objeto);
    }
    
}
