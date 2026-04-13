package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Servico;
import view.BuscaProdutoCopa;
import view.BuscaServico;

public class ControllerBuscaServico2 implements ActionListener{
    private BuscaServico telaBuscaServico;

    public ControllerBuscaServico2(BuscaServico telaBuscaServico) {
        this.telaBuscaServico = telaBuscaServico;
        
        this.telaBuscaServico.getjButtonCarregar().addActionListener(this);
        this.telaBuscaServico.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaServico.getjButtonFechar().addActionListener(this);
        
        List<Servico> servicos = new ArrayList<>();
        servicos = service.ServicoService.Carregar("obs", this.telaBuscaServico.getjTextFieldValor().getText());

        DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaServico.getjTableDados().getModel();
        tabela.setRowCount(0);
        int i=0;
        for (Servico servico : servicos) {
            tabela.addRow(new Object[] {servico.getId(), servico.getDescricao(), servico.getObs(), servico.getStatus()});
        }
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaServico.getjButtonCarregar()){
            //JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado");
            if(telaBuscaServico.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                ControllerMovimentoCheck.codigo = (int)this.telaBuscaServico.getjTableDados().getValueAt(this.telaBuscaServico.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaServico.dispose();
            }
        } else if(evento.getSource() == this.telaBuscaServico.getjButtonFiltrar()){
            //JOptionPane.showMessageDialog(null, "Botão Filtrar Pressionado");
            if(this.telaBuscaServico.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                if(telaBuscaServico.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    Servico produtoCopa = new Servico();
                    produtoCopa = service.ServicoService.Carregar(Integer.parseInt(this.telaBuscaServico.getjTextFieldValor().getText()));
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaServico.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getObs(), produtoCopa.getStatus()});
                    
                } else if(telaBuscaServico.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    List<Servico> produtosCopa = new ArrayList<>();
                    // JPA: lida com o atributo do java, e nao com o campo do BD
                    produtosCopa = service.ServicoService.Carregar("descricao", this.telaBuscaServico.getjTextFieldValor().getText());
                    
                    // .JAR =: produtosCopa = service.ServicoService.Carregar("decricao", this.telaBuscaServico.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaServico.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Servico produtoCopa : produtosCopa) {
                        tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getObs(), produtoCopa.getStatus()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }
                } else if(telaBuscaServico.getjComboBoxFiltrarPor().getSelectedIndex() == 2){
                    List<Servico> produtosCopa = new ArrayList<>();
                    produtosCopa = service.ServicoService.Carregar("obs", this.telaBuscaServico.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaServico.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Servico produtoCopa : produtosCopa) {
                        tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getObs(), produtoCopa.getStatus()});
                    }
                }
            }
        } else if(evento.getSource() == this.telaBuscaServico.getjButtonFechar()){
            this.telaBuscaServico.dispose();
        }
    }
    
    
}
