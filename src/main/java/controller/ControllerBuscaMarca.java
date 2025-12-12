package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Marca;
import view.BuscaMarca;

public  class ControllerBuscaMarca implements ActionListener{
    private BuscaMarca telaBuscaMarca;

    public ControllerBuscaMarca(BuscaMarca telaBuscaMarca) {
        this.telaBuscaMarca = telaBuscaMarca;
        
        this.telaBuscaMarca.getjButtonCarregar().addActionListener(this);
        this.telaBuscaMarca.getjButtonFiltrar().addActionListener(this);
        //this.telaBuscaMarca.getjButtonCancelarFiltro().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaMarca.getjButtonCarregar()){
            //JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado");
            if(telaBuscaMarca.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                ControllerCadMarca.codigo = (int)this.telaBuscaMarca.getjTableDados().getValueAt(this.telaBuscaMarca.getjTableDados().getSelectedRow(), 0);
            }
            //JOptionPane.showMessageDialog(null, "saiu do if-else");
        } else if(evento.getSource() == this.telaBuscaMarca.getjButtonFiltrar()){
            //JOptionPane.showMessageDialog(null, "Botão Filtrar Pressionado");
            if(this.telaBuscaMarca.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                this.telaBuscaMarca.getjTableDados().setEnabled(true);
                if(telaBuscaMarca.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    Marca marca = new Marca();
                    marca = service.MarcaService.Carregar(Integer.parseInt(this.telaBuscaMarca.getjTextFieldValor().getText()));
                    //System.out.println(marca);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {marca.getId(), marca.getDescricao(), marca.getStatus()});
                    
                } else if(telaBuscaMarca.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    List<Marca> marcas = new ArrayList<>();
                    marcas = service.MarcaService.Carregar("descricao", this.telaBuscaMarca.getjTextFieldValor().getText());
                    //System.out.println(marca);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    for (Marca marca : marcas) {
                        tabela.addRow(new Object[] {marca.getId(), marca.getDescricao(), marca.getStatus()});
                    }
                    /*JOptionPane.showMessageDialog(null, "Filtrando Por Descricao");
                    List<Marca> marcaes = new ArrayList<>();
                    marcaes = service.MarcaService.Carregar("descricao", this.telaBuscaMarca.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    //int i=0;
                    for (Marca marca : marcaes) {
                        tabela.addRow(new Object[] {marca.getId(), marca.getDescricao(), marca.getStatus()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }*/
                }
            }
        } 

    //JOptionPane.showMessageDialog(null, "sai do contrBusca");
    }
    
}
