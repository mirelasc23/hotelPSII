package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import view.BuscaFuncionario;

public class ControllerBuscaFuncionario implements ActionListener{
    private BuscaFuncionario telaBuscaFuncionario;

    public ControllerBuscaFuncionario(BuscaFuncionario telaBuscaFuncionario) {
        this.telaBuscaFuncionario = telaBuscaFuncionario;
        
        this.telaBuscaFuncionario.getjButtonCarregar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaFuncionario.getjButtonFechar().addActionListener(this);
        
        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios = service.FuncionarioService.Carregar("nome", this.telaBuscaFuncionario.getjTextFieldValor().getText());

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
        tabela.setRowCount(0);
        int i=0;
        for (Funcionario funcionario : funcionarios) {
            tabela.addRow(new Object[] {funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getUsuario(), funcionario.getStatus()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        
        if(evento.getSource() == this.telaBuscaFuncionario.getjButtonCarregar()){
            //JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado");
            if(telaBuscaFuncionario.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                ControllerCadFuncionario.codigo = (int)this.telaBuscaFuncionario.getjTableDados().getValueAt(this.telaBuscaFuncionario.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaFuncionario.dispose();
            }
        } else if(evento.getSource() == this.telaBuscaFuncionario.getjButtonFiltrar()){
            //JOptionPane.showMessageDialog(null, "Botão Filtrar Pressionado");
            if(this.telaBuscaFuncionario.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                //JOptionPane.showMessageDialog(null, "   Filando Dados");
                if(telaBuscaFuncionario.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    //JOptionPane.showMessageDialog(null, "Filtrando Por Id");
                    Funcionario funcionario = new Funcionario();

                    funcionario = service.FuncionarioService.Carregar(Integer.parseInt(this.telaBuscaFuncionario.getjTextFieldValor().getText()));
                    System.out.println(funcionario);
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getUsuario(), funcionario.getStatus()});
                } else if(telaBuscaFuncionario.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    //JOptionPane.showMessageDialog(null, "Filtrando Por Nome");
                    List<Funcionario> funcionarios = new ArrayList<>();
                    funcionarios = service.FuncionarioService.Carregar("nome", this.telaBuscaFuncionario.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Funcionario funcionario : funcionarios) {
                        tabela.addRow(new Object[] {funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getUsuario(), funcionario.getStatus()});
                    }
                } else if(telaBuscaFuncionario.getjComboBoxFiltrarPor().getSelectedIndex() == 2){
                    //JOptionPane.showMessageDialog(null, "Filtrando Por CPF");
                    List<Funcionario> funcionarios = new ArrayList<>();
                    funcionarios = service.FuncionarioService.Carregar("cpf", this.telaBuscaFuncionario.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Funcionario funcionario : funcionarios) {
                        tabela.addRow(new Object[] {funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getUsuario(), funcionario.getStatus()});
                    }
                } else if(telaBuscaFuncionario.getjComboBoxFiltrarPor().getSelectedIndex() == 3){
                    //JOptionPane.showMessageDialog(null, "Filtrando Por Usuário");
                    List<Funcionario> funcionarios = new ArrayList<>();
                    funcionarios = service.FuncionarioService.Carregar("usuario", this.telaBuscaFuncionario.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaFuncionario.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Funcionario funcionario : funcionarios) {
                        tabela.addRow(new Object[] {funcionario.getId(), funcionario.getNome(), funcionario.getCpf(), funcionario.getUsuario(), funcionario.getStatus()});
                    }
                }
            }
        } else if(evento.getSource() == this.telaBuscaFuncionario.getjButtonFechar()){
            this.telaBuscaFuncionario.dispose();
        }
    }
    
}
