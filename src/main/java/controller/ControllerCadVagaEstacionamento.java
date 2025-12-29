package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.VagaEstacionamento;
import view.CadastroVagaEstacionamento;

public class ControllerCadVagaEstacionamento implements ActionListener{
        CadastroVagaEstacionamento telaCadastroVagaEstacionamento;

    public ControllerCadVagaEstacionamento(CadastroVagaEstacionamento telaCadastroVagaEstacionamento) {
        this.telaCadastroVagaEstacionamento = telaCadastroVagaEstacionamento;
        this.telaCadastroVagaEstacionamento.getjButtonNovo().addActionListener(this);
        this.telaCadastroVagaEstacionamento.getjButtonGravar().addActionListener(this);
        this.telaCadastroVagaEstacionamento.getjButtonBuscar().addActionListener(this);
        this.telaCadastroVagaEstacionamento.getjButtonCancelar().addActionListener(this);
        this.telaCadastroVagaEstacionamento.getjButtonSair().addActionListener(this);
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVagaEstacionamento.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstacionamento.getjPanelDados(), false);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonNovo()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVagaEstacionamento.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstacionamento.getjPanelDados(), true);
            this.telaCadastroVagaEstacionamento.getjTextFieldID().setEnabled(false);
            this.telaCadastroVagaEstacionamento.getjComboBoxSituacao().setSelectedIndex(0);
            this.telaCadastroVagaEstacionamento.getjComboBoxSituacao().setEnabled(false);
            this.telaCadastroVagaEstacionamento.getjComboBoxFIltrarPor().setEnabled(false);
            this.telaCadastroVagaEstacionamento.getjTextFieldValor().setEnabled(false);

        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonGravar()){
            if (this.telaCadastroVagaEstacionamento.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroVagaEstacionamento.getjTextFieldDescricao().requestFocus();
                this.telaCadastroVagaEstacionamento.getjTextFieldDescricao().setText("vazio");
            } else {
                VagaEstacionamento servico = new VagaEstacionamento();

                servico.setDescricao(this.telaCadastroVagaEstacionamento.getjTextFieldDescricao().getText());
                servico.setObs(this.telaCadastroVagaEstacionamento.getjTextAreaObs().getText());

                if (this.telaCadastroVagaEstacionamento.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    //inclusao
                    servico.setStatus('A');
                    service.VagaEstacionamentoService.Criar(servico);
                } else {
                    servico.setId(Integer.parseInt(this.telaCadastroVagaEstacionamento.getjTextFieldID().getText()));
                    char status;
                    if(this.telaCadastroVagaEstacionamento.getjComboBoxSituacao().getSelectedIndex() == 0){
                        status = 'a';
                    }else{
                        status = 'i';
                    }

                    servico.setStatus(status);
                    service.VagaEstacionamentoService.Atualizar(servico);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVagaEstacionamento.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstacionamento.getjPanelDados(), false);
            }
        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonBuscar()){
            /*BuscaHospede telaBuscaHospede= new BuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospedes = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);*/
        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVagaEstacionamento.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstacionamento.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonSair()){
           this.telaCadastroVagaEstacionamento.dispose();
        }
        
    }
}