package service;

import java.util.List;
import model.ReservaQuarto;
import model.dao.ReservaQuartoDAO;

public class ReservaQuartoService{

    public static void Criar(ReservaQuarto objeto) {
        ReservaQuartoDAO.getInstance().create(objeto);
    }

    /*public static List<ReservaQuarto> Carregar() {
        return ReservaQuartoDAO.getInstance().retrieveAll();
    }
    
    /public static List<String> CarregarCheckBox() {
        return ReservaQuartoDAO.getInstance().retrieveCheckBox();
    }*/

    public static ReservaQuarto Carregar(int id) {
        return ReservaQuartoDAO.getInstance().retrieve(id);
    }

    public static List<ReservaQuarto> Carregar(String atributo, String valor) {
        return ReservaQuartoDAO.getInstance().retrieve(atributo, valor);
    }
    
    /*public static List<ReservaQuarto> ConsultaJoin(String consulta) {
        return ReservaQuartoDAO.getInstance().retrieveJoin(consulta);
    }*/

    public static void Atualizar(ReservaQuarto objeto) {
        ReservaQuartoDAO.getInstance().update(objeto);
    }

    public static void Deletar(ReservaQuarto objeto) {
        ReservaQuartoDAO.getInstance().delete(objeto);
    }
    
}
