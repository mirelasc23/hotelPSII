package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Marca;
import view.CadastroMarca;

public class ControllerCadMarca implements ActionListener{
    private CadastroMarca telaCadastroMarca;

    public ControllerCadMarca(CadastroMarca telaCadastroMarca) {
        this.telaCadastroMarca = telaCadastroMarca;
        
        this.telaCadastroMarca.getjButtonNovo().addActionListener(this);
        this.telaCadastroMarca.getjButtonGravar().addActionListener(this);
        this.telaCadastroMarca.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMarca.getjButtonSair().addActionListener(this);
        this.telaCadastroMarca.getjButtonCarregar().addActionListener(this);
        this.telaCadastroMarca.getjButtonBuscar().addActionListener(this);
        this.telaCadastroMarca.getjButtonFiltrar().addActionListener(this);
        
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
        
//        this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(true);
//        this.telaCadastroMarca.getjTextFieldValor().setEnabled(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        System.out.println("Evento disparado por: " + e.getSource().toString());
//        String str = "Evento disparado por: " + e.getSource().toString();
//        JOptionPane.showMessageDialog(null, str);
        //BOTAO NOVO
        if(e.getSource() == this.telaCadastroMarca.getjButtonNovo()){            
           //padrao dos botoes
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);
            
            //inativa id, status e campos de filtro
            this.telaCadastroMarca.getjTextFieldID().setEnabled(false);
            this.telaCadastroMarca.getjComboBoxStatus().setSelectedIndex(0);
            this.telaCadastroMarca.getjComboBoxStatus().setEnabled(false);
            
            this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(false);
            this.telaCadastroMarca.getjTextFieldValor().setEnabled(false);
            
            
        //BOTAO GRAVAR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonGravar()){
            if(this.telaCadastroMarca.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroMarca.getjTextFieldDescricao().requestFocus();
            }else{

                JOptionPane.showMessageDialog(null, "entrou no else 1");
                
                Marca marca = new Marca();
                marca.setDescricao(this.telaCadastroMarca.getjTextFieldDescricao().getText());
                
                
                if(this.telaCadastroMarca.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                    //inclusao
                    marca.setStatus('A');
                    service.MarcaService.Criar(marca);
                } else{
                    JOptionPane.showMessageDialog(null, "entrou no else 2");
                    
                    char status;
                    if(this.telaCadastroMarca.getjComboBoxStatus().getSelectedIndex() == 0){
                        status = 'A';
                    }else {
                        status = 'I';
                    } 
                    marca.setStatus(status);
                    JOptionPane.showMessageDialog(null, "Status selecionado: " + status);
                    
                    marca.setDescricao(this.telaCadastroMarca.getjTextFieldDescricao().getText());
                    marca.setId(Integer.parseInt(this.telaCadastroMarca.getjTextFieldID().getText()));
                    System.out.println("");
                    service.MarcaService.Atualizar(marca);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
             }
            
            
        //BOTAO BUSCAR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonBuscar()){
            this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(true);
            this.telaCadastroMarca.getjTextFieldValor().setEnabled(true);
            this.telaCadastroMarca.getjTableDados().setEnabled(true);
            
            List<Marca> marcas = new ArrayList();
            marcas = service.MarcaService.Carregar();
            DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroMarca.getjTableDados().getModel();
            tabela.setRowCount(0);
            for (Marca marca : marcas) {
                tabela.addRow(new Object[] {marca.getId(), marca.getDescricao(), marca.getStatus()});
            }
            
            /*
            if (codigo != 0) {
                
                //DESATIVA BOTOES PARA BUSCA
                utilities.Utilities.ativaDesativaBusca(this.telaCadastroMarca.getjPanelDados(), false);

                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);
                
                //DESATIVA COMPONENTES PARA BUSCA
                this.telaCadastroMarca.getjTableDados().setEnabled(false);
                this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(false);
                this.telaCadastroMarca.getjTextFieldValor().setEnabled(false);

                this.telaCadastroMarca.getjTextFieldID().setText(codigo + "");
                this.telaCadastroMarca.getjTextFieldID().setEnabled(false);
                
                /*Marca marca = new Marca();
                marca  = service.MarcaService.Carregar(codigo);
                
                //JOptionPane.showMessageDialog(null, marca);
                this.telaCadastroMarca.getjTextFieldDescricao().setText(marca.getDescricao());
                int index_status;
                if(marca.getStatus()== 'a' || marca.getStatus()== 'A'){
                    index_status = 0;
                }else{
                    index_status = 1;
                }
                this.telaCadastroMarca.getjComboBoxStatus().setSelectedIndex(index_status);
                
                this.telaCadastroMarca.getjTextFieldDescricao().requestFocus();
            }*/
         
        
        //BOTAO CARREGAR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonCarregar()){
             if(telaCadastroMarca.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);
            
                int codigo = (int)this.telaCadastroMarca.getjTableDados().getValueAt(this.telaCadastroMarca.getjTableDados().getSelectedRow(), 0);
                
                Marca marca = service.MarcaService.Carregar(codigo);
                this.telaCadastroMarca.getjTextFieldID().setText(codigo + "");
                this.telaCadastroMarca.getjTextFieldID().setEnabled(false);
                
                this.telaCadastroMarca.getjTextFieldDescricao().setText(marca.getDescricao());
                int index_status;
                if(marca.getStatus()== 'a' || marca.getStatus()== 'A'){
                    index_status = 0;
                }else{
                    index_status = 1;
                }
                this.telaCadastroMarca.getjComboBoxStatus().setSelectedIndex(index_status);
                
                this.telaCadastroMarca.getjTextFieldDescricao().requestFocus();
                this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(false);
                this.telaCadastroMarca.getjTextFieldValor().setEnabled(false);
                
            }
        
        //BOTAO FILTRAR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonFiltrar()){
           if(this.telaCadastroMarca.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                if(telaCadastroMarca.getjComboBoxFiltrarPor().getSelectedIndex() == 0){
                    Marca produtoCopa = new Marca();
                    produtoCopa = service.MarcaService.Carregar(Integer.parseInt(this.telaCadastroMarca.getjTextFieldValor().getText()));
                    DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroMarca.getjTableDados().getModel();
                    //Limpa a tabela a cada filtragem
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getStatus()});
                
                } else if(telaCadastroMarca.getjComboBoxFiltrarPor().getSelectedIndex() == 1){
                    List<Marca> produtosCopa = new ArrayList<>();
                    // JPA: lida com o atributo do java, e nao com o campo do BD
                    produtosCopa = service.MarcaService.Carregar("descricao", this.telaCadastroMarca.getjTextFieldValor().getText());
                    
                    // .JAR =: produtosCopa = service.MarcaService.Carregar("decricao", this.telaCadastroMarca.getjTextFieldValor().getText());
                                        
                    DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroMarca.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    int i=0;
                    for (Marca produtoCopa : produtosCopa) {
                        tabela.addRow(new Object[] {produtoCopa.getId(), produtoCopa.getDescricao(), produtoCopa.getStatus()});
                        //JOptionPane.showMessageDialog(null, ++i);
                    }
                } 
            }
        
        //BOTAO CANCELAR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
            
            //this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(true);
            //this.telaCadastroMarca.getjTextFieldValor().setEnabled(true);    
            
        //BOTAO SAIR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonSair()){
           this.telaCadastroMarca.dispose();
        }        
    }
}
