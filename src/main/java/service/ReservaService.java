package service;

import java.util.List;
import model.Reserva;
import model.dao.ReservaDAO;

public class ReservaService{

    public static void Criar(Reserva objeto) {
        ReservaDAO.getInstance().create(objeto);
    }

    /*public static List<Reserva> Carregar() {
        return ReservaDAO.getInstance().retrieveAll();
    }
    
    /public static List<String> CarregarCheckBox() {
        return ReservaDAO.getInstance().retrieveCheckBox();
    }*/

    public static Reserva Carregar(int id) {
        return ReservaDAO.getInstance().retrieve(id);
    }

    public static List<Reserva> Carregar(String atributo, String valor) {
        return ReservaDAO.getInstance().retrieve(atributo, valor);
    }
    
    /*public static List<Reserva> ConsultaJoin(String consulta) {
        return ReservaDAO.getInstance().retrieveJoin(consulta);
    }*/

    public static void Atualizar(Reserva objeto) {
        ReservaDAO.getInstance().update(objeto);
    }

    public static void Deletar(Reserva objeto) {
        ReservaDAO.getInstance().delete(objeto);
    }
    
}
