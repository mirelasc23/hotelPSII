package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Servico;
import view.BuscaServico;
import view.CadastroServico;

public class ControllerCadServico implements ActionListener {
//parei na linha 78
    CadastroServico telaCadastroServico;
    public static int codigo;

    public ControllerCadServico(CadastroServico telaCadastroServico) {
        this.telaCadastroServico = telaCadastroServico;
        this.telaCadastroServico.getjButtonNovo().addActionListener(this);
        this.telaCadastroServico.getjButtonGravar().addActionListener(this);
        this.telaCadastroServico.getjButtonBuscar().addActionListener(this);
        this.telaCadastroServico.getjButtonCancelar().addActionListener(this);
        this.telaCadastroServico.getjButtonSair().addActionListener(this);
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);

        //Desenvolver as setagens de situação inicial dos componentes:  ||quais botões estarão ativos
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaCadastroServico.getjButtonNovo()) {
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), true);
            this.telaCadastroServico.getjTextFieldID().setEnabled(false);
            this.telaCadastroServico.getjComboBoxSituacao().setSelectedIndex(0);
            this.telaCadastroServico.getjComboBoxSituacao().setEnabled(false);
            this.telaCadastroServico.getjComboBoxFiltrarPor().setEnabled(false);
            this.telaCadastroServico.getjTextFieldValor().setEnabled(false);

        } else if (e.getSource() == this.telaCadastroServico.getjButtonGravar()) {
            if (this.telaCadastroServico.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroServico.getjTextFieldDescricao().requestFocus();
                this.telaCadastroServico.getjTextFieldDescricao().setText("vazio");
            } else {
                Servico servico = new Servico();

                servico.setDescricao(this.telaCadastroServico.getjTextFieldDescricao().getText());
                servico.setObs(this.telaCadastroServico.getjTextAreaObs().getText());

                if (this.telaCadastroServico.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    //inclusao
                    servico.setStatus('A');
                    service.ServicoService.Criar(servico);
                } else {
                    servico.setId(Integer.parseInt(this.telaCadastroServico.getjTextFieldID().getText()));
                    char status;
                    if(this.telaCadastroServico.getjComboBoxSituacao().getSelectedIndex() == 0){
                        status = 'a';
                    }else{
                        status = 'i';
                    }

                    servico.setStatus(status);
                    service.ServicoService.Atualizar(servico);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);
            }
        } else if (e.getSource() == this.telaCadastroServico.getjButtonBuscar()) {
            codigo = 0;

            BuscaServico telaBuscaServico = new BuscaServico(null, true);
            ControllerBuscaServico controllerBuscaServico = new ControllerBuscaServico(telaBuscaServico);
            telaBuscaServico.setVisible(true);
            
            if (codigo != 0) {
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), true);

                this.telaCadastroServico.getjTextFieldID().setText(codigo + "");
                this.telaCadastroServico.getjTextFieldID().setEnabled(false);
            
                Servico servico = new Servico();
                servico = service.ServicoService.Carregar(codigo);
                
                this.telaCadastroServico.getjTextFieldDescricao().setText(servico.getDescricao());
                this.telaCadastroServico.getjTextAreaObs().setText(servico.getObs());
                
                int index_status;
                if(servico.getStatus() == 'a' || servico.getStatus() == 'A' ){
                    index_status = 0;
                }else{
                    index_status = 1;
                }
                
                this.telaCadastroServico.getjComboBoxSituacao().setSelectedIndex(index_status);
                
                //servico.setDescricao(this.telaCadastroServico.getjTextFieldDescricao().getText());
                //servico.setObs(this.telaCadastroServico.getjTextAreaObs().getText());
                
            }
        } else if (e.getSource() == this.telaCadastroServico.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);
        } else if (e.getSource() == this.telaCadastroServico.getjButtonSair()) {
            this.telaCadastroServico.dispose();
        }

    }
}
