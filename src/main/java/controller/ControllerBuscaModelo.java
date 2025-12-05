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
        
        this.telaBuscaModelo.getjButtonCarregar().addActionListener(this);
        this.telaBuscaModelo.getjButtonFiltrar().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaModelo.getjButtonCarregar()){
            //JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado");
            if(telaBuscaModelo.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                ControllerCadModelo.codigo = (int)this.telaBuscaModelo.getjTableDados().getValueAt(this.telaBuscaModelo.getjTableDados().getSelectedRow(), 0);
                JOptionPane.showMessageDialog(null, ControllerCadModelo.codigo);
            }
            //JOptionPane.showMessageDialog(null, "saiu do if-else");
        } else if(evento.getSource() == this.telaBuscaModelo.getjButtonFiltrar()){
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
                    tabela.addRow(new Object[] {modelo.getId(), modelo.getDescricao(), modelo.getStatus()});
                    
                } else if(telaBuscaModelo.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    List<Modelo> modelos = new ArrayList<>();
                    modelos = service.ModeloService.Carregar("descricao", this.telaBuscaModelo.getjTextFieldValor().getText());
                    //System.out.println(modelo);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    for (Modelo modelo : modelos) {
                        tabela.addRow(new Object[] {modelo.getId(), modelo.getDescricao(), modelo.getStatus()});
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
                }
            }
        } 

    //JOptionPane.showMessageDialog(null, "sai do contrBusca");
    }
    

}
