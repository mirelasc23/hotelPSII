package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import model.Servico;
import org.w3c.dom.events.MouseEvent;
import view.BuscaHospede;
import view.BuscaServico;
import view.CadastroServico;
import view.MovimentoCheck;

public class ControllerMovimentoCheck implements ActionListener, MouseListener{
    MovimentoCheck telaMovimentoCheck;
    public static int codigo;

    public ControllerMovimentoCheck(MovimentoCheck telaMovimentoCheck) {
        this.telaMovimentoCheck = telaMovimentoCheck;
        this.telaMovimentoCheck.getjButtonNovo().addActionListener(this);
        this.telaMovimentoCheck.getjButtonGravar().addActionListener(this);
        this.telaMovimentoCheck.getjButtonBuscar().addActionListener(this);
        this.telaMovimentoCheck.getjButtonCancelar().addActionListener(this);
        this.telaMovimentoCheck.getjButtonSair().addActionListener(this);
        this.telaMovimentoCheck.getjTextFieldIDHospede().addMouseListener(this);
        utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), true);
        utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelDados(), true);
        utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.telaMovimentoCheck.getjButtonNovo()) {
            
            Date hoje = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = sdf.format(hoje);
            
            utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), true);
            
            this.telaMovimentoCheck.getjFormattedTextFieldDataCadastro().setText(data);
            this.telaMovimentoCheck.getjFormattedTextFieldDataCadastro().setEnabled(false);
            
            //this.telaMovimentoCheck.getjTextFieldIDReserva().setEnabled(false);
            this.telaMovimentoCheck.getjComboBoxStatusReserva().setSelectedIndex(0);
            this.telaMovimentoCheck.getjComboBoxStatusReserva().setEnabled(false);
            this.telaMovimentoCheck.getjComboBoxStatusReserva().setEnabled(false);
            //this.telaMovimentoCheck.getjComboBoxFiltrarPor().setEnabled(false);
            //this.telaMovimentoCheck.getjTextFieldValor().setEnabled(false);

        }/* else if (e.getSource() == this.telaMovimentoCheck.getjButtonGravar()) {
            if (this.telaMovimentoCheck.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaMovimentoCheck.getjTextFieldDescricao().requestFocus();
            } else {
                Servico servico = new Servico();

                servico.setDescricao(this.telaMovimentoCheck.getjTextFieldDescricao().getText());
                servico.setObs(this.telaMovimentoCheck.getjTextAreaObs().getText());

                if (this.telaMovimentoCheck.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    //inclusao
                    servico.setStatus('A');
                    service.ServicoService.Criar(servico);
                } else {
                    servico.setId(Integer.parseInt(this.telaMovimentoCheck.getjTextFieldID().getText()));
                    char status;
                    if(this.telaMovimentoCheck.getjComboBoxSituacao().getSelectedIndex() == 0){
                        status = 'A';
                    }else{
                        status = 'I';
                    }

                    servico.setStatus(status);
                    service.ServicoService.Atualizar(servico);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), false);
            }
        } else if (e.getSource() == this.telaMovimentoCheck.getjButtonBuscar()) {
            codigo = 0;

            BuscaServico telaBuscaServico = new BuscaServico(null, true);
            ControllerBuscaServico controllerBuscaServico = new ControllerBuscaServico(telaBuscaServico);
            telaBuscaServico.setVisible(true);
            
            if (codigo != 0) {
                utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), true);

                this.telaMovimentoCheck.getjTextFieldIDReserva().setText(codigo + "");
                this.telaMovimentoCheck.getjTextFieldIDReserva().setEnabled(false);
            
                Servico servico = new Servico();
                servico = service.ServicoService.Carregar(codigo);
                
                this.telaMovimentoCheck.getjTextFieldDescricao().setText(servico.getDescricao());
                this.telaMovimentoCheck.getjTextFieldObsReserva().setText(servico.getObs());
                
                int index_status;
                if(servico.getStatus() == 'a' || servico.getStatus() == 'A' ){
                    index_status = 0;
                }else{
                    index_status = 1;
                }
                
                this.telaMovimentoCheck.getjComboBoxStatusReserva().setSelectedIndex(index_status);  
            }
        }*/ else if (e.getSource() == this.telaMovimentoCheck.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), false);
        } else if (e.getSource() == this.telaMovimentoCheck.getjButtonSair()) {
            this.telaMovimentoCheck.dispose();
        }
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        /*if(evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDHospede()){
            if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                JOptionPane.showMessageDialog(null, "Clique Duplo");
                System.out.println("Clique Duplo Detectado!");
            }
        }*/
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDHospede()) {
            if (evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                System.out.println("Clique Duplo Detectado no MousePressed!");
                // Sua lógica de busca aqui
                BuscaHospede telaBuscaHospede = new BuscaHospede(null, true);
                ControllerBuscaHospede controllerBuscaHospede = new ControllerBuscaHospede(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
            }
        }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        //Border bordaHover = BorderFactory.createLineBorder(Color.BLUE, 2);
        //this.telaMovimentoCheck.getjTextFieldIDHospede().setBorder(bordaHover);
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        //this.telaMovimentoCheck.getjTextFieldIDHospede().setBorder(this.telaMovimentoCheck.getjTextFieldEmail1().getBorder());
    }
}
