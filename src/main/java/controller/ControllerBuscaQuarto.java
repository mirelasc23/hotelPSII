package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Quarto;
import view.BuscaQuarto;

public class ControllerBuscaQuarto implements ActionListener{
    private BuscaQuarto telaBuscaQuarto;

    public ControllerBuscaQuarto(BuscaQuarto telaBuscaQuarto) {
        this.telaBuscaQuarto = telaBuscaQuarto;
        
        this.telaBuscaQuarto.getjButtonCarregar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaQuarto.getjButtonFechar().addActionListener(this);

    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaQuarto.getjButtonCarregar()){
            //JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado");
            if(telaBuscaQuarto.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                //JOptionPane.showMessageDialog(null, "Carregando Dados");
                ControllerCadQuarto.codigo = (int)this.telaBuscaQuarto.getjTableDados().getValueAt(this.telaBuscaQuarto.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaQuarto.dispose();
            }
        } else if(evento.getSource() == this.telaBuscaQuarto.getjButtonFiltrar()){
            //JOptionPane.showMessageDialog(null, "Botão Filtrar Pressionado");
            if(this.telaBuscaQuarto.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                if(telaBuscaQuarto.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    Quarto quarto = new Quarto();
                    quarto = service.QuartoService.Carregar(Integer.parseInt(this.telaBuscaQuarto.getjTextFieldValor().getText()));
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {quarto.getId(), quarto.getIdentificacao(), quarto.getCapacidadeHospedes(), quarto.getMetragem()});
                    
                } else if(telaBuscaQuarto.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    List<Quarto> quartos = new ArrayList<>();
                    quartos = service.QuartoService.Carregar("identificacao", this.telaBuscaQuarto.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Quarto quarto : quartos) {
                        tabela.addRow(new Object[] {quarto.getId(), quarto.getIdentificacao(), quarto.getCapacidadeHospedes(), quarto.getMetragem()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }
                } else if(telaBuscaQuarto.getjComboBoxFiltrarPor().getSelectedIndex() == 2){
                    List<Quarto> quartos = new ArrayList<>();
                    quartos = service.QuartoService.Carregar("capacidade_hospedes", this.telaBuscaQuarto.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Quarto quarto : quartos) {
                        tabela.addRow(new Object[] {quarto.getId(), quarto.getIdentificacao(), quarto.getCapacidadeHospedes(), quarto.getMetragem()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }
                } else if(telaBuscaQuarto.getjComboBoxFiltrarPor().getSelectedIndex() == 3){
                    List<Quarto> quartos = new ArrayList<>();
                    quartos = service.QuartoService.Carregar("metragem", this.telaBuscaQuarto.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaQuarto.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Quarto quarto : quartos) {
                        tabela.addRow(new Object[] {quarto.getId(), quarto.getIdentificacao(), quarto.getCapacidadeHospedes(), quarto.getMetragem()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }
                }
            }
        } else if(evento.getSource() == this.telaBuscaQuarto.getjButtonFechar()){
            this.telaBuscaQuarto.dispose();
        }
    }
}
