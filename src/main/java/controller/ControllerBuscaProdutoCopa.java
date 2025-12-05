package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ProdutoCopa;
import view.BuscaProdutoCopa;

public class ControllerBuscaProdutoCopa implements ActionListener{
    private BuscaProdutoCopa telaBuscaProdutoCopa;

    public ControllerBuscaProdutoCopa(BuscaProdutoCopa telaBuscaProdutoCopa) {
        this.telaBuscaProdutoCopa = telaBuscaProdutoCopa;
        
        this.telaBuscaProdutoCopa.getjButtonCarregar().addActionListener(this);
        this.telaBuscaProdutoCopa.getjButtonFiltrar().addActionListener(this);
        this.telaBuscaProdutoCopa.getjButtonFechar().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource() == this.telaBuscaProdutoCopa.getjButtonCarregar()){
            //JOptionPane.showMessageDialog(null, "Botão Carregar Pressionado");
            if(telaBuscaProdutoCopa.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                ControllerCadProdutoCopa.codigo = (int)this.telaBuscaProdutoCopa.getjTableDados().getValueAt(this.telaBuscaProdutoCopa.getjTableDados().getSelectedRow(), 0);
                this.telaBuscaProdutoCopa.dispose();
            }
        } else if(evento.getSource() == this.telaBuscaProdutoCopa.getjButtonFiltrar()){
            //JOptionPane.showMessageDialog(null, "Botão Filtrar Pressionado");
            if(this.telaBuscaProdutoCopa.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                if(telaBuscaProdutoCopa.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    ProdutoCopa produtoCopa = new ProdutoCopa();
                    produtoCopa = service.ProdutoCopaService.Carregar(Integer.parseInt(this.telaBuscaProdutoCopa.getjTextFieldValor().getText()));
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProdutoCopa.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getValor(), produtoCopa.getStatus()});
                    
                } else if(telaBuscaProdutoCopa.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    List<ProdutoCopa> produtosCopa = new ArrayList<>();
                    produtosCopa = service.ProdutoCopaService.Carregar("decricao", this.telaBuscaProdutoCopa.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProdutoCopa.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (ProdutoCopa produtoCopa : produtosCopa) {
                        tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getValor(), produtoCopa.getStatus()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }
                } else if(telaBuscaProdutoCopa.getjComboBoxFiltrarPor().getSelectedIndex() == 2){
                    List<ProdutoCopa> produtosCopa = new ArrayList<>();
                    produtosCopa = service.ProdutoCopaService.Carregar("valor", this.telaBuscaProdutoCopa.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProdutoCopa.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (ProdutoCopa produtoCopa : produtosCopa) {
                        tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getValor(), produtoCopa.getStatus()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }
                } else if(telaBuscaProdutoCopa.getjComboBoxFiltrarPor().getSelectedIndex() == 3){
                    List<ProdutoCopa> produtosCopa = new ArrayList<>();
                    produtosCopa = service.ProdutoCopaService.Carregar("obs", this.telaBuscaProdutoCopa.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaProdutoCopa.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (ProdutoCopa produtoCopa : produtosCopa) {
                        tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getValor(), produtoCopa.getStatus()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }
                }
            }
        } else if(evento.getSource() == this.telaBuscaProdutoCopa.getjButtonFechar()){
            this.telaBuscaProdutoCopa.dispose();
        }
    }
    
    
}
