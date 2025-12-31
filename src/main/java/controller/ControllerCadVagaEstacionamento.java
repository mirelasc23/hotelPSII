package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
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
        this.telaCadastroVagaEstacionamento.getjButtonFiltrar().addActionListener(this);
        this.telaCadastroVagaEstacionamento.getjButtonCarregar().addActionListener(this);
        
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
            } else {
                VagaEstacionamento vagaEstacionamento = new VagaEstacionamento();

                vagaEstacionamento.setDescricao(this.telaCadastroVagaEstacionamento.getjTextFieldDescricao().getText());
                vagaEstacionamento.setMetragemVaga(Float.parseFloat(this.telaCadastroVagaEstacionamento.getjTextFieldMetragem().getText()));
                vagaEstacionamento.setObs(this.telaCadastroVagaEstacionamento.getjTextAreaObs().getText());

                if (this.telaCadastroVagaEstacionamento.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    //inclusao
                    vagaEstacionamento.setStatus('A');
                    service.VagaEstacionamentoService.Criar(vagaEstacionamento);
                } else {
                    char status;
                    if(this.telaCadastroVagaEstacionamento.getjComboBoxSituacao().getSelectedIndex() == 0){
                        status = 'l';
                    }else if(this.telaCadastroVagaEstacionamento.getjComboBoxSituacao().getSelectedIndex() == 1){
                        status = 'o';
                    }else {
                        status = 'm';
                    }

                    vagaEstacionamento.setStatus(status);
                    vagaEstacionamento.setId(Integer.parseInt(this.telaCadastroVagaEstacionamento.getjTextFieldID().getText()));
                    service.VagaEstacionamentoService.Atualizar(vagaEstacionamento);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVagaEstacionamento.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstacionamento.getjPanelDados(), false);
            }
        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonBuscar()){
            this.telaCadastroVagaEstacionamento.getjComboBoxFIltrarPor().setEnabled(true);
            this.telaCadastroVagaEstacionamento.getjTextFieldValor().setEnabled(true);
            
            //CONTROLLER
            //ControllerBuscaVagaEstacionamento controllerBuscaVaga = new ControllerBuscaVagaEstacionamento(this.telaCadastroVagaEstacionamento);
            List<VagaEstacionamento> vagas = new ArrayList<>();
            vagas = service.VagaEstacionamentoService.Carregar();
            DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroVagaEstacionamento.getjTableDados().getModel();
            tabela.setRowCount(0);
            for (VagaEstacionamento vaga : vagas) {
                tabela.addRow(new Object[] {vaga.getId(), vaga.getDescricao(), vaga.getMetragemVaga(), vaga.getObs(), vaga.getStatus()});
            }
            
            
            /*BuscaHospede telaBuscaHospede= new BuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospedes = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);*/
        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonCarregar()){
            if(telaCadastroVagaEstacionamento.getjTableDados().getRowCount() == 0){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVagaEstacionamento.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstacionamento.getjPanelDados(), true);
            
                int codigo = (int)this.telaCadastroVagaEstacionamento.getjTableDados().getValueAt(this.telaCadastroVagaEstacionamento.getjTableDados().getSelectedRow(), 0);
                
                VagaEstacionamento vaga = service.VagaEstacionamentoService.Carregar(codigo);
                this.telaCadastroVagaEstacionamento.getjTextFieldID().setText(codigo + "");
                this.telaCadastroVagaEstacionamento.getjTextFieldID().setEnabled(false);
                
                this.telaCadastroVagaEstacionamento.getjTextFieldDescricao().setText(vaga.getDescricao());
                this.telaCadastroVagaEstacionamento.getjTextFieldMetragem().setText(String.valueOf(vaga.getMetragemVaga()));
                int index_status;
                if(vaga.getStatus()== 'l' || vaga.getStatus()== 'L'){
                    index_status = 0;
                }else if(vaga.getStatus()== 'o' || vaga.getStatus()== 'O'){
                    index_status = 1;
                }else{
                    index_status = 2;
                }
                this.telaCadastroVagaEstacionamento.getjComboBoxSituacao().setSelectedIndex(index_status);
                
                this.telaCadastroVagaEstacionamento.getjTextFieldDescricao().requestFocus();
                this.telaCadastroVagaEstacionamento.getjComboBoxFIltrarPor().setEnabled(false);
                this.telaCadastroVagaEstacionamento.getjTextFieldValor().setEnabled(false);
                
            }
        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonFiltrar()){
            if(this.telaCadastroVagaEstacionamento.getjTextFieldValor().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "A busca não retornou nada.");
            } else {
                this.telaCadastroVagaEstacionamento.getjTableDados().setEnabled(true);
                if(telaCadastroVagaEstacionamento.getjComboBoxFIltrarPor().getSelectedIndex() == 0){
                    VagaEstacionamento vaga = new VagaEstacionamento();
                    vaga = service.VagaEstacionamentoService.Carregar(Integer.parseInt(this.telaCadastroVagaEstacionamento.getjTextFieldValor().getText()));
                    DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroVagaEstacionamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    tabela.addRow(new Object[] {vaga.getId(), vaga.getDescricao(), vaga.getMetragemVaga(), vaga.getObs(), vaga.getStatus()});
                    
                } else if(telaCadastroVagaEstacionamento.getjComboBoxFIltrarPor().getSelectedIndex() == 1){
                    List<VagaEstacionamento > vagas = new ArrayList<>();
                    vagas = service.VagaEstacionamentoService.Carregar("descricao", this.telaCadastroVagaEstacionamento.getjTextFieldValor().getText());
                    DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroVagaEstacionamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (VagaEstacionamento  vaga : vagas) {
                        tabela.addRow(new Object[] {vaga.getId(), vaga.getDescricao(), vaga.getMetragemVaga(), vaga.getObs(), vaga.getStatus()});
                    }
                } else if(telaCadastroVagaEstacionamento.getjComboBoxFIltrarPor().getSelectedIndex() == 2){
                    List<VagaEstacionamento > vagas = new ArrayList<>();
                    //vagas = service.VagaEstacionamentoService.Carregar("metragem_vaga", this.telaCadastroVagaEstacionamento.getjTextFieldValor().getText());
                    vagas = service.VagaEstacionamentoService.Carregar("metragemVaga", this.telaCadastroVagaEstacionamento.getjTextFieldValor().getText());
                    DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroVagaEstacionamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (VagaEstacionamento  vaga : vagas) {
                        tabela.addRow(new Object[] {vaga.getId(), vaga.getDescricao(), vaga.getMetragemVaga(), vaga.getObs(), vaga.getStatus()});
                    }
                } else if(telaCadastroVagaEstacionamento.getjComboBoxFIltrarPor().getSelectedIndex() == 3){
                    List<VagaEstacionamento > vagas = new ArrayList<>();
                    vagas = service.VagaEstacionamentoService.Carregar("obs", this.telaCadastroVagaEstacionamento.getjTextFieldValor().getText());
                    DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroVagaEstacionamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (VagaEstacionamento  vaga : vagas) {
                        tabela.addRow(new Object[] {vaga.getId(), vaga.getDescricao(), vaga.getMetragemVaga(), vaga.getObs(), vaga.getStatus()});
                    }
                } else if(telaCadastroVagaEstacionamento.getjComboBoxFIltrarPor().getSelectedIndex() == 4){
                    List<VagaEstacionamento > vagas = new ArrayList<>();
                    vagas = service.VagaEstacionamentoService.Carregar("status", this.telaCadastroVagaEstacionamento.getjTextFieldValor().getText());
                    DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroVagaEstacionamento.getjTableDados().getModel();
                    tabela.setRowCount(0);
                    for (VagaEstacionamento  vaga : vagas) {
                        tabela.addRow(new Object[] {vaga.getId(), vaga.getDescricao(), vaga.getMetragemVaga(), vaga.getObs(), vaga.getStatus()});
                    }
                }
            
            }
//            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVagaEstacionamento.getjPanelBotoes(), true);
//            utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstacionamento.getjPanelDados(), false);
            
            
            
        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVagaEstacionamento.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVagaEstacionamento.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroVagaEstacionamento.getjButtonSair()){
           this.telaCadastroVagaEstacionamento.dispose();
        }
        }    
    
}