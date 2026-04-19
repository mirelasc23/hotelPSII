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
/*
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroVeiculo extends JFrame {
    
    private JComboBox<String> cbMarca;
    private JComboBox<String> cbModelo;
    
    // Flag para evitar loops de eventos
    private boolean isUpdating = false;

    public TelaCadastroVeiculo() {
        // ... inicialização dos componentes ...

        cbMarca.addActionListener(e -> {
            if (isUpdating) return; // Se já estamos atualizando, não faz nada
            atualizarModelos();
        });

        cbModelo.addActionListener(e -> {
            if (isUpdating) return;
            atualizarMarcas();
        });
    }

    private void atualizarModelos() {
        isUpdating = true; // Inicia bloqueio
        
        String marcaSelecionada = (String) cbMarca.getSelectedItem();
        // Lógica: buscar modelos no seu banco de dados ou lista
        String[] novosModelos = buscarModelosPorMarca(marcaSelecionada);
        
        cbModelo.setModel(new DefaultComboBoxModel<>(novosModelos));
        
        isUpdating = false; // Libera o bloqueio
    }

    private void atualizarMarcas() {
        isUpdating = true; // Inicia bloqueio
        
        String modeloSelecionado = (String) cbModelo.getSelectedItem();
        // Lógica: identificar a marca daquele modelo
        String novaMarca = buscarMarcaPorModelo(modeloSelecionado);
        
        cbMarca.setSelectedItem(novaMarca);
        
        isUpdating = false; // Libera o bloqueio
    }
    
    // Métodos auxiliares (Substitua pela sua lógica de dados)
    private String[] buscarModelosPorMarca(String marca) {
        // Exemplo: return dao.listarModelos(marca);
        return new String[] {"Modelo A", "Modelo B"};
    }
    
    private String buscarMarcaPorModelo(String modelo) {
        // Exemplo: return dao.getMarca(modelo);
        return "Toyota";
    }
}*/