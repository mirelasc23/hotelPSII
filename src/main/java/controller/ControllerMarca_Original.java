package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Marca;
import view.CadastroMarca;

public class ControllerMarca_Original implements ActionListener{
    private CadastroMarca telaCadastroMarca;
    public static int codigo;

    public ControllerMarca_Original(CadastroMarca telaCadastroMarca) {
        this.telaCadastroMarca = telaCadastroMarca;
        
        this.telaCadastroMarca.getjButtonNovo().addActionListener(this);
        this.telaCadastroMarca.getjButtonGravar().addActionListener(this);
        //this.telaCadastroMarca.getjButtonBuscar().addActionListener(this);
        this.telaCadastroMarca.getjButtonCancelar().addActionListener(this);
        this.telaCadastroMarca.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroMarca.getjButtonNovo()){
           
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);
            
            this.telaCadastroMarca.getjTextFieldID().setEnabled(false);
            this.telaCadastroMarca.getjComboBoxStatus().setSelectedIndex(0);
            this.telaCadastroMarca.getjComboBoxStatus().setEnabled(false);
            
            this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(false);
            this.telaCadastroMarca.getjTextFieldValor().setEnabled(false);
            
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonGravar()){
            if(this.telaCadastroMarca.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroMarca.getjTextFieldDescricao().requestFocus();
            }else{

                Marca marca = new Marca();

                //marca.setId(Integer.parseInt(this.telaCadastroMarca.getjTextFieldID().getText()));
                marca.setDescricao(this.telaCadastroMarca.getjTextFieldDescricao().getText());
                
                char status;
                if(this.telaCadastroMarca.getjComboBoxStatus().getSelectedIndex() == 0){
                    status = 'a';
                }else {
                    status = 'i';
                } marca.setStatus(status);
                
                if(this.telaCadastroMarca.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                    //inclusao
                    marca.setStatus('A');
                    service.MarcaService.Criar(marca);
                } else{
                    marca.setId(Integer.parseInt(this.telaCadastroMarca.getjTextFieldID().getText()));
                    service.MarcaService.Atualizar(marca);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
             }
            //utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
            //utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonBuscar()){
            
            //ATIVA BOTOES PARA BUSCA
            utilities.Utilities.ativaDesativaBusca(this.telaCadastroMarca.getjPanelDados(), true);
            
            //ATIVA COMPONENTES PARA BUSCA
            this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(true);
            this.telaCadastroMarca.getjTextFieldValor().setEnabled(true);
            JOptionPane.showMessageDialog(null, "ativou componentes"); 
            
            
            //CONTROLLER
            ControllerBuscaMarca controllerBuscaHospedes = new ControllerBuscaMarca(this.telaCadastroMarca);
            
            /*DefaultTableModel tabela = (DefaultTableModel) this.telaBuscaMarca.getjTableDados().getModel();
                //Limpa a tabela a cada filtragem
                tabela.setRowCount(0);*/
            //JOptionPane.showMessageDialog(null, "saiu do contrBusca");
            //JOptionPane.showMessageDialog(null, "cód. em CadMarca" + ControllerCadMarca.codigo);
            
            if (codigo != 0) {
                
                //JOptionPane.showMessageDialog(null, "entrou no if(codigo)");

                //DESATIVA BOTOES PARA BUSCA
                utilities.Utilities.ativaDesativaBusca(this.telaCadastroMarca.getjPanelDados(), false);

                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), true);
                
                //DESATIVA COMPONENTES PARA BUSCA
                this.telaCadastroMarca.getjTableDados().setEnabled(false);
                this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(false);
                this.telaCadastroMarca.getjTextFieldValor().setEnabled(false);
            //JOptionPane.showMessageDialog(null, "desativou componentes"); 
                //this.telaCadastroMarca.getjTextFieldValor().setEnabled(false);
                /*DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroMarca.getjTableDados().getModel();
                //Limpa a tabela a cada filtragem
                tabela.setRowCount(0);
                this.telaCadastroMarca.getjTableDados().setEnabled(true);
                this.telaCadastroMarca.getjComboBoxFiltrarPor().setEnabled(false);*/

                this.telaCadastroMarca.getjTextFieldID().setText(codigo + "");
                this.telaCadastroMarca.getjTextFieldID().setEnabled(false);
                
                Marca marca = new Marca();
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
            }
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroMarca.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroMarca.getjPanelDados(), false);
            
        }else if(e.getSource() == this.telaCadastroMarca.getjButtonSair()){
           this.telaCadastroMarca.dispose();
        }
        
    }
}
