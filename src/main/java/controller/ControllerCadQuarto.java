package controller;

import view.CadastroQuarto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Quarto;
import view.BuscaQuarto;

public class ControllerCadQuarto implements ActionListener{
    private CadastroQuarto telaCadastroQuarto;
    public static int codigo;

    public ControllerCadQuarto(CadastroQuarto telaCadastroQuarto) {
        this.telaCadastroQuarto = telaCadastroQuarto;
        
        this.telaCadastroQuarto.getjButtonNovo().addActionListener(this);
        this.telaCadastroQuarto.getjButtonGravar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonBuscar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonCancelar().addActionListener(this);
        this.telaCadastroQuarto.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroQuarto.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), false);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(e.getSource() == this.telaCadastroQuarto.getjButtonNovo()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroQuarto.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), true);
        }else if(e.getSource() == this.telaCadastroQuarto.getjButtonGravar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroQuarto.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroQuarto.getjButtonBuscar()){
            /*BuscaHospede telaBuscaHospede= new BuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospedes = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);
        }else if(e.getSource() == this.telaCadastroQuarto.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroQuarto.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroQuarto.getjButtonSair()){
           this.telaCadastroQuarto.dispose();
        }*/
        if(e.getSource() == this.telaCadastroQuarto.getjButtonNovo()){
            
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroQuarto.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), true);

            this.telaCadastroQuarto.getjTextFieldID().setEnabled(false);
            this.telaCadastroQuarto.getjComboBoxStatus().setSelectedIndex(0);
            this.telaCadastroQuarto.getjComboBoxStatus().setEnabled(false);
        }else if(e.getSource() == this.telaCadastroQuarto.getjButtonGravar()){
             if(this.telaCadastroQuarto.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroQuarto.getjTextFieldDescricao().requestFocus();
            }else{

                Quarto quarto = new Quarto();

                quarto.setDescricao(this.telaCadastroQuarto.getjTextFieldDescricao().getText());
                quarto.setCapacidadeHospedes(Integer.parseInt(this.telaCadastroQuarto.getjTextFieldCapacidade().getText()));
                quarto.setMetragem(Float.parseFloat(this.telaCadastroQuarto.getjTextFieldMetragem().getText()));
                quarto.setIdentificacao(this.telaCadastroQuarto.getjTextFieldIdentificacao().getText());
                quarto.setAndar(Integer.parseInt(this.telaCadastroQuarto.getjTextFieldAndar().getText()));
                quarto.setFlagAnimais(this.telaCadastroQuarto.getjCheckBoxAnimais().isSelected());
                quarto.setFlagBebe(this.telaCadastroQuarto.getjCheckBoxBebes().isSelected());
                quarto.setFlagFumante(this.telaCadastroQuarto.getjCheckBoxFumante().isSelected());
                quarto.setObs(this.telaCadastroQuarto.getjTextAreaObs().getText());
                
                char status;
                if(this.telaCadastroQuarto.getjComboBoxStatus().getSelectedIndex() == 0){
                    status = 'a';
                }else {
                    status = 'm';
                }
                quarto.setStatus(status);
                if(this.telaCadastroQuarto.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                    //inclusao
                    quarto.setStatus('A');
                    service.QuartoService.Criar(quarto);
                } else{
                    quarto.setId(Integer.parseInt(this.telaCadastroQuarto.getjTextFieldID().getText()));
                    service.QuartoService.Atualizar(quarto);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroQuarto.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), false);
             }
        }else if(e.getSource() == this.telaCadastroQuarto.getjButtonBuscar()){
            //JOptionPane.showMessageDialog(null, "Falta ControllerBuscaFuncionarios");
            //JOptionPane.showMessageDialog(null, "ENTROU EM BUSCAR");
            BuscaQuarto telaBuscaQuarto= new BuscaQuarto(null, true);
            ControllerBuscaQuarto controllerBuscaQuarto = new ControllerBuscaQuarto(telaBuscaQuarto);
            telaBuscaQuarto.setVisible(true);
            
            if (codigo != 0) {
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroQuarto.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), true);

                this.telaCadastroQuarto.getjTextFieldID().setText(codigo + "");
                this.telaCadastroQuarto.getjTextFieldID().setEnabled(false);
                
                
                Quarto quarto = new Quarto();
                quarto = service.QuartoService.Carregar(codigo);

                this.telaCadastroQuarto.getjTextFieldDescricao().setText(quarto.getDescricao());
                this.telaCadastroQuarto.getjTextFieldIdentificacao().setText(quarto.getIdentificacao());
                this.telaCadastroQuarto.getjTextFieldCapacidade().setText(String.valueOf(quarto.getCapacidadeHospedes()));
                this.telaCadastroQuarto.getjTextFieldMetragem().setText(String.valueOf(quarto.getMetragem()));
                this.telaCadastroQuarto.getjTextFieldAndar().setText(String.valueOf(quarto.getAndar()));
                this.telaCadastroQuarto.getjCheckBoxAnimais().setSelected(quarto.isFlagAnimais());
                this.telaCadastroQuarto.getjCheckBoxBebes().setSelected(quarto.isFlagBebe());
                this.telaCadastroQuarto.getjCheckBoxFumante().setSelected(quarto.isFlagFumante());
                this.telaCadastroQuarto.getjTextAreaObs().setText(quarto.getObs());
                //this.telaCadastroQuarto.getj().setText(hospede.getStatus());
                int index_status;
                if(quarto.getStatus()== 'a' || quarto.getStatus()== 'A'){
                    index_status = 0;
                }else{
                    index_status = 1;
                }
                this.telaCadastroQuarto.getjComboBoxStatus().setSelectedIndex(index_status);
                

                //carregar os dados para os containers faltantes
                this.telaCadastroQuarto.getjTextFieldDescricao().requestFocus();
            }


        }else if(e.getSource() == this.telaCadastroQuarto.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroQuarto.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroQuarto.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroQuarto.getjButtonSair()){
           this.telaCadastroQuarto.dispose();
        }
    }
}
