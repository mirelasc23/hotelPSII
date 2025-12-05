package controller;

import java.util.List;
import model.Marca;
import model.dao.MarcaDAO;

public class JavaTest {
    //new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" })
    //new javax.swing.DefaultComboBoxModel<>(controller.JavaTest.retornaMarca())
    
    
    public static String[] retornaMarca(){
        MarcaDAO marcaDAO = new MarcaDAO();
        List<Marca> marcas = marcaDAO.retrieveAll();
        String[] vet_marcas = null;
        int i = 0;
        for (Marca marca : marcas) {
            vet_marcas[i] =  marca.getDescricao();
            i++;
        }
        return vet_marcas;
    }
    
    public void retornaMarca1(){
        MarcaDAO marcaDAO = new MarcaDAO();
        List<Marca> marcas = marcaDAO.retrieveAll();
        for (Marca marca : marcas) {
            System.out.println(marca.getDescricao());
        }
    }
}
