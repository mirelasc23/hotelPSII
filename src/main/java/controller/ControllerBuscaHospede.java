package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Hospede;
import view.BuscaHospede;

public class ControllerBuscaHospede implements ActionListener{
    BuscaHospede telaBuscaHospede;

    public ControllerBuscaHospede(BuscaHospede telaBuscaHospede) {
        this.telaBuscaHospede = telaBuscaHospede;
        
        this.telaBuscaHospede.getjButtonCarregar().addActionListener(this);
        this.telaBuscaHospede.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaHospede.getjButtonFechar().addActionListener(this);
        
        this.telaBuscaHospede.getjComboBoxFiltrarPor().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaHospede.getjButtonCarregar()){
            //JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado");
            if(telaBuscaHospede.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                JOptionPane.showMessageDialog(null, "Carregando Dados");
                //Retornar os dados para a tela de cadastro
                ControllerCadHospedes.codigo = (int)this.telaBuscaHospede.getjTableDados().getValueAt(this.telaBuscaHospede.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaHospede.dispose();
                
            }
        } 
        else if(evento.getSource() == this.telaBuscaHospede.getjButtonFiltrar()){
            //JOptionPane.showMessageDialog(null, "Botão Filtrar Pressionado");
            if(this.telaBuscaHospede.getjTextField1().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                //JOptionPane.showMessageDialog(null, "   Filando Dados");
                if(telaBuscaHospede.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    JOptionPane.showMessageDialog(null, "Filtrando Por Id");
                    
                //Cria objeto para receber dados
                    Hospede hospede = new Hospede();
                    //Carrega o registro do BD para o objeto
                    hospede = service.HospedeService.Carregar(Integer.parseInt(this.telaBuscaHospede.getjTextField1().getText()));
                    System.out.println(hospede);
                    
                    //Cria tabela para apresentar na view
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});
                    
                    
                    
                    
                } else if(telaBuscaHospede.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    //JOptionPane.showMessageDialog(null, "Filtrando Por Nome");
                    
                    List<Hospede> hospedes = new ArrayList<>();
                    hospedes = service.HospedeService.Carregar("nome", this.telaBuscaHospede.getjTextField1().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaHospede.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Hospede hospede : hospedes) {
                        tabela.addRow(new Object[] {hospede.getId(), hospede.getNome(), hospede.getCpf(), hospede.getStatus()});
                        JOptionPane.showMessageDialog(null, ++i);
                    }
                    
                } else if(telaBuscaHospede.getjComboBoxFiltrarPor().getSelectedIndex() == 2){
                    //JOptionPane.showMessageDialog(null, "Filtrando Por CPF");
                    
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

/*
Date hoje = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = sdf.format(hoje);*/