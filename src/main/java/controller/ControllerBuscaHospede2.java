package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Hospede;
import view.BuscaHospede;

public class ControllerBuscaHospede2 implements ActionListener{
    BuscaHospede telaBuscaHospede;

    public ControllerBuscaHospede2(BuscaHospede telaBuscaHospede) {
        this.telaBuscaHospede = telaBuscaHospede;
        
        this.telaBuscaHospede.getjButtonCarregar().addActionListener(this);
        this.telaBuscaHospede.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaHospede.getjButtonFechar().addActionListener(this);
        
        this.telaBuscaHospede.getjComboBoxFiltrarPor().addActionListener(this);
        
        List<Hospede> hospedes = new ArrayList<>();
        hospedes = service.HospedeService.Carregar();

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
        tabela.setRowCount(0);
        int i=0;
        for (Hospede hospede : hospedes) {
            tabela.addRow(new Object[] {hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaHospede.getjButtonCarregar()){
            if(telaBuscaHospede.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                ControllerMovimentoCheck.codigo = (int)this.telaBuscaHospede.getjTableDados().getValueAt(this.telaBuscaHospede.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaHospede.dispose();
                
            }
        } 
        else if(evento.getSource() == this.telaBuscaHospede.getjButtonFiltrar()){
            if(this.telaBuscaHospede.getjTextField1().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                if(telaBuscaHospede.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Filtrando Por Id");
                    
                    Hospede hospede = new Hospede();
                    hospede = service.HospedeService.Carregar(Integer.parseInt(this.telaBuscaHospede.getjTextField1().getText()));
                    System.out.println(hospede);
                    
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});
                    
                    
                    
                    
                } else if(telaBuscaHospede.getjComboBoxFiltrarPor().getSelectedIndex() == 1){                    
                    List<Hospede> hospedes = new ArrayList<>();
                    hospedes = service.HospedeService.Carregar("nome", this.telaBuscaHospede.getjTextField1().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Hospede hospede : hospedes) {
                        tabela.addRow(new Object[] {hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});
                    }
                    
                } else if(telaBuscaHospede.getjComboBoxFiltrarPor().getSelectedIndex() == 2){                    
                    List<Hospede> hospedes = new ArrayList<>();
                    hospedes = service.HospedeService.Carregar("cpf", this.telaBuscaHospede.getjTextField1().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (Hospede hospede : hospedes) {
                        tabela.addRow(new Object[] {hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});
                    }
                }
            }
        } else if(evento.getSource() == this.telaBuscaHospede.getjButtonFechar()){
            this.telaBuscaHospede.dispose();
        }
    }
}
