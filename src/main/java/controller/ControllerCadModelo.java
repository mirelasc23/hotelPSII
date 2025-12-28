package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Modelo;
import view.CadastroModelo;

public class ControllerCadModelo implements ActionListener{
    private CadastroModelo telaCadastroModelo;
    public static int codigo;

    public ControllerCadModelo(CadastroModelo telaCadastroModelo) {
        this.telaCadastroModelo = telaCadastroModelo;
        
        this.telaCadastroModelo.getjButtonNovo().addActionListener(this);
        this.telaCadastroModelo.getjButtonGravar().addActionListener(this);
        this.telaCadastroModelo.getjButtonBuscar().addActionListener(this);
        this.telaCadastroModelo.getjButtonCancelar().addActionListener(this);
        this.telaCadastroModelo.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroModelo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroModelo.getjButtonNovo()){
           
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroModelo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), true);
            
            this.telaCadastroModelo.getjTextFieldID().setEnabled(false);
            this.telaCadastroModelo.getjComboBoxStatus().setSelectedIndex(0);
            this.telaCadastroModelo.getjComboBoxStatus().setEnabled(false);
            
            this.telaCadastroModelo.getjComboBoxFiltrarPor().setEnabled(false);
            this.telaCadastroModelo.getjTextFieldValor().setEnabled(false);
            
        }else if(e.getSource() == this.telaCadastroModelo.getjButtonGravar()){
            if(this.telaCadastroModelo.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroModelo.getjTextFieldDescricao().requestFocus();
            }else{

                Modelo modelo = new Modelo();

                //modelo.setId(Integer.parseInt(this.telaCadastroModelo.getjTextFieldID().getText()));
                modelo.setDescricao(this.telaCadastroModelo.getjTextFieldDescricao().getText());
                
                char status;
                if(this.telaCadastroModelo.getjComboBoxStatus().getSelectedIndex() == 0){
                    status = 'a';
                }else {
                    status = 'i';
                } modelo.setStatus(status);
                
                if(this.telaCadastroModelo.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                    //inclusao
                    modelo.setStatus('A');
                    service.ModeloService.Criar(modelo);
                } else{
                    modelo.setId(Integer.parseInt(this.telaCadastroModelo.getjTextFieldID().getText()));
                    service.ModeloService.Atualizar(modelo);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroModelo.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);
             }
            //utilities.Utilities.ativaDesativaBotoes(this.telaCadastroModelo.getjPanelBotoes(), true);
            //utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroModelo.getjButtonBuscar()){
            
            //ATIVA BOTOES PARA BUSCA
            /*utilities.Utilities.ativaDesativaBusca(this.telaCadastroModelo.getjPanelDados(), true);*/
            
            //ATIVA COMPONENTES PARA BUSCA
            this.telaCadastroModelo.getjComboBoxFiltrarPor().setEnabled(true);
            this.telaCadastroModelo.getjTextFieldValor().setEnabled(true);            
            
            //CONTROLLER
            ControllerBuscaModelo controllerBuscaModelo = new ControllerBuscaModelo(this.telaCadastroModelo);
            
            /*DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaModelo.getjTableDados().getModel();
                //Limpa a tabela a cada filtragem
                tabela.setRowCount(0);*/
            //JOptionPane.showMessageDialog(null, "saiu do contrBusca");
            //JOptionPane.showMessageDialog(null, "cód. em CadModelo" + ControllerCadModelo.codigo);
            
            if (codigo != 0) {
                
                //JOptionPane.showMessageDialog(null, "entrou no if(codigo)");

                //DESATIVA BOTOES PARA BUSCA
                /*utilities.Utilities.ativaDesativaBusca(this.telaCadastroModelo.getjPanelDados(), false);

                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroModelo.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), true);
                
                //DESATIVA COMPONENTES PARA BUSCA
                this.telaCadastroModelo.getjTableDados().setEnabled(false);
                this.telaCadastroModelo.getjComboBoxFiltrarPor().setEnabled(false);
                this.telaCadastroModelo.getjTextFieldValor().setEnabled(false);*/
            //JOptionPane.showMessageDialog(null, "desativou componentes"); 
                //this.telaCadastroModelo.getjTextFieldValor().setEnabled(false);
                /*DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroModelo.getjTableDados().getModel();
                //Limpa a tabela a cada filtragem
                tabela.setRowCount(0);
                this.telaCadastroModelo.getjTableDados().setEnabled(true);
                this.telaCadastroModelo.getjComboBoxFiltrarPor().setEnabled(false);*/

                this.telaCadastroModelo.getjTextFieldID().setText(codigo + "");
                this.telaCadastroModelo.getjTextFieldID().setEnabled(false);
                
                Modelo modelo = new Modelo();
                modelo  = service.ModeloService.Carregar(codigo);
                
                //JOptionPane.showMessageDialog(null, modelo);
                this.telaCadastroModelo.getjTextFieldDescricao().setText(modelo.getDescricao());
                int index_status;
                if(modelo.getStatus()== 'a' || modelo.getStatus()== 'A'){
                    index_status = 0;
                }else{
                    index_status = 1;
                }
                this.telaCadastroModelo.getjComboBoxStatus().setSelectedIndex(index_status);
                
                this.telaCadastroModelo.getjTextFieldDescricao().requestFocus();
            }
        }else if(e.getSource() == this.telaCadastroModelo.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroModelo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroModelo.getjPanelDados(), false);
            
        }else if(e.getSource() == this.telaCadastroModelo.getjButtonSair()){
           this.telaCadastroModelo.dispose();
        }
        
    }
}
