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
    public static int codigo;

    public ControllerCadMarca(CadastroMarca telaCadastroMarca) {
        this.telaCadastroMarca = telaCadastroMarca;
        
        this.telaCadastroMarca.getjButtonNovo().addActionListener(this);
        this.telaCadastroMarca.getjButtonGravar().addActionListener(this);
        this.telaCadastroMarca.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMarca.getjButtonSair().addActionListener(this);
        this.telaCadastroMarca.getjButtonCarregar().addActionListener(this);
        this.telaCadastroMarca.getjButtonFiltrar().addActionListener(this);
        
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
        
        this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(true);
        this.telaCadastroMarca.getjTextFieldValor().setEnabled(true);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

                Marca marca = new Marca();
                marca.setDescricao(this.telaCadastroMarca.getjTextFieldDescricao().getText());
                
                char status;
                if(this.telaCadastroMarca.getjComboBoxStatus().getSelectedIndex() == 0){
                    status = 'a';
                }else {
                    status = 'i';
                } marca.setStatus(status);
                
                if(this.telaCadastroMarca.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                    //inclusao
                    service.MarcaService.Criar(marca);
                } else{
                    marca.setId(Integer.parseInt(this.telaCadastroMarca.getjTextFieldID().getText()));
                    service.MarcaService.Atualizar(marca);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
             }
            
            
        //BOTAO FILTRAR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonFiltrar()){
            
            //ATIVA BOTOES PARA BUSCA
            utilities.Utilities.ativaDesativaBusca(this.telaCadastroMarca.getjPanelDados(), true);
            
            //ATIVA COMPONENTES PARA BUSCA
            this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(true);
            this.telaCadastroMarca.getjTextFieldValor().setEnabled(true);
            //JOptionPane.showMessageDialog(null, "ativou componentes"); 
                        
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
                
                this.telaCadastroMarca.getjTextFieldDescricao().requestFocus();*/
            }
         
        
        //BOTAO CARREGAR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonCarregar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);
            

        //BOTAO CANCELAR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
            
            this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(true);
            this.telaCadastroMarca.getjTextFieldValor().setEnabled(true);    
            
        //BOTAO SAIR
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonSair()){
           this.telaCadastroMarca.dispose();
        }        
    }
}
