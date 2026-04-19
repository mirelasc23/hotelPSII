package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Modelo;
import model.Veiculo;
import view.CadastroVeiculo;

public class ControllerCadVeiculo implements ActionListener{
        CadastroVeiculo telaCadastroVeiculo;

    public ControllerCadVeiculo(CadastroVeiculo telaCadastroVeiculo) {
        this.telaCadastroVeiculo = telaCadastroVeiculo;
        
        this.telaCadastroVeiculo.getjButtonNovo().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonGravar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonBuscar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonCancelar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonSair().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonFiltrar().addActionListener(this);
        this.telaCadastroVeiculo.getjButtonCarregar().addActionListener(this);
        this.telaCadastroVeiculo.getjComboBoxModelo().addActionListener(this);
        this.telaCadastroVeiculo.getjComboBoxMarca().addActionListener(this);
        
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroVeiculo.getjButtonNovo()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), true);
            
            this.telaCadastroVeiculo.getjTextFieldID().setEnabled(false);
            this.telaCadastroVeiculo.getjComboBoxSituacao().setSelectedIndex(0);
            this.telaCadastroVeiculo.getjComboBoxSituacao().setEnabled(false);
            this.telaCadastroVeiculo.getjComboBoxFiltrarPor().setEnabled(false);
            this.telaCadastroVeiculo.getjTextFieldValor().setEnabled(false);
            
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonGravar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
            
            if (this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroVeiculo.getjComboBoxModelo().requestFocus();
            } else if (this.telaCadastroVeiculo.getjTextFieldPlaca().getText().trim().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroVeiculo.getjTextFieldPlaca().requestFocus();
            } else {
                Veiculo veiculo = new Veiculo();

                veiculo.setModelo((Modelo)this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedItem());
                veiculo.setPlaca(this.telaCadastroVeiculo.getjTextFieldPlaca().getText());
                veiculo.setCor(this.telaCadastroVeiculo.getjTextFieldCor().getText());

                if (this.telaCadastroVeiculo.getjTextFieldID().getText().trim().equalsIgnoreCase("")) {
                    //inclusao
                    veiculo.setStatus('A');
                    service.VeiculoService.Criar(veiculo);
                } else {
                    char status;
                    if(this.telaCadastroVeiculo.getjComboBoxSituacao().getSelectedIndex() == 0){
                        status = 'A';
                    }else if(this.telaCadastroVeiculo.getjComboBoxSituacao().getSelectedIndex() == 1){
                        status = 'E';
                    }else{
                        status = 'I';
                    }

                    veiculo.setStatus(status);
                    veiculo.setId(Integer.parseInt(this.telaCadastroVeiculo.getjTextFieldID().getText()));
                    service.VeiculoService.Atualizar(veiculo);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
            }
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonBuscar()){
            this.telaCadastroVeiculo.getjComboBoxFiltrarPor().setEnabled(true);
            this.telaCadastroVeiculo.getjTextFieldValor().setEnabled(true);
            
            List<Veiculo> veiculos = new ArrayList<>();
            veiculos = service.VeiculoService.Carregar();
            JOptionPane.showMessageDialog(null, veiculos);
            DefaultTableModel tabela = (DefaultTableModel) this.telaCadastroVeiculo.getjTableDados().getModel();
            tabela.setRowCount(0);
            for (Veiculo veiculo : veiculos) {
                tabela.addRow(new Object[] {veiculo.getId(), veiculo.getModelo(), veiculo.getModelo().getMarca(), veiculo.getCor(), veiculo.getPlaca(), veiculo.getStatus()});
            }
            
            /*BuscaHospede telaBuscaHospede= new BuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospedes = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);*/
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonFiltrar()){
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonCarregar()){
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonSair()){
           this.telaCadastroVeiculo.dispose();
        }
        
        //LISTENERS PARA TROCA JCOMBOBOX
        else if(e.getSource() == this.telaCadastroVeiculo.getjButtonSair()){
           this.telaCadastroVeiculo.dispose();
        }
        
    }
}