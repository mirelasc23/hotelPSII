package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Modelo;
import view.CadastroModelo;

public class ControllerBuscaModelo implements ActionListener{
    private CadastroModelo telaBuscaModelo;

    public ControllerBuscaModelo(CadastroModelo telaBuscaModelo) {
        this.telaBuscaModelo = telaBuscaModelo;
        
        this.telaBuscaModelo.getjButtonFiltrar().addActionListener(this);
        
        List<Modelo> modelos = new ArrayList<>();
        modelos = service.ModeloService.Carregar();
        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
        tabela.setRowCount(0);
        for (Modelo modelo : modelos) {
            tabela.addRow(new Object[] {modelo.getId(), modelo.getDescricao(), modelo.getMarca(), modelo.getStatus()});
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaModelo.getjButtonFiltrar()){
            //JOptionPane.showMessageDialog(null, "Botão Filtrar Pressionado");
            if(this.telaBuscaModelo.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                this.telaBuscaModelo.getjTableDados().setEnabled(true);
                if(telaBuscaModelo.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    Modelo modelo = new Modelo();
                    modelo = service.ModeloService.Carregar(Integer.parseInt(this.telaBuscaModelo.getjTextFieldValor().getText()));
                    //System.out.println(modelo);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {modelo.getId(), modelo.getDescricao(), modelo.getMarca(), modelo.getStatus()});
                    
                } else if(telaBuscaModelo.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    List<Modelo> modelos = new ArrayList<>();
                    modelos = service.ModeloService.Carregar("descricao", this.telaBuscaModelo.getjTextFieldValor().getText());
                    //System.out.println(modelo);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    for (Modelo modelo : modelos) {
                        tabela.addRow(new Object[] {modelo.getId(), modelo.getDescricao(), modelo.getMarca(), modelo.getStatus()});
                    }
                    /*JOptionPane.showMessageDialog(null, "Filtrando Por Descricao");
                    List<Modelo> modeloes = new ArrayList<>();
                    modeloes = service.ModeloService.Carregar("descricao", this.telaBuscaModelo.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    //int i=0;
                    for (Modelo modelo : modeloes) {
                        tabela.addRow(new Object[] {modelo.getId(), modelo.getDescricao(), modelo.getStatus()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }*/
                }else if(telaBuscaModelo.getjComboBoxFiltrarPor().getSelectedIndex() == 2){
                    List<Modelo> modelos = new ArrayList<>();
                    modelos = service.ModeloService.Carregar("marca", this.telaBuscaModelo.getjTextFieldValor().getText());
                    //System.out.println(modelo);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    for (Modelo modelo : modelos) {
                        tabela.addRow(new Object[] {modelo.getId(), modelo.getDescricao(), modelo.getMarca(), modelo.getStatus()});
                    }
                }
            }
        } 
    }
}
