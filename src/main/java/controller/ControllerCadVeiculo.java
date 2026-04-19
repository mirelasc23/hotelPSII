package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Marca;
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
        //this.telaCadastroVeiculo.getjComboBoxModelo().addItemListener(this);
        this.telaCadastroVeiculo.getjComboBoxMarca().addActionListener(this);
        
        this.telaCadastroVeiculo.setTelaInstanciada(false);
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
        this.telaCadastroVeiculo.setTelaInstanciada(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroVeiculo.getjButtonNovo()){
            this.telaCadastroVeiculo.setTelaInstanciada(false);
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), true);
            this.telaCadastroVeiculo.setTelaInstanciada(true);
            
            this.telaCadastroVeiculo.getjTextFieldID().setEnabled(false);
            this.telaCadastroVeiculo.getjComboBoxSituacao().setSelectedIndex(0);
            this.telaCadastroVeiculo.getjComboBoxSituacao().setEnabled(false);
            this.telaCadastroVeiculo.getjComboBoxFiltrarPor().setEnabled(false);
            this.telaCadastroVeiculo.getjTextFieldValor().setEnabled(false);
            
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonGravar()){
            /*this.telaCadastroVeiculo.setTelaInstanciada(false);
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
            this.telaCadastroVeiculo.setTelaInstanciada(true);*/
            
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
                    JOptionPane.showMessageDialog(null, "criar: \n"+veiculo);
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
                    JOptionPane.showMessageDialog(null, "ATUALIZAR: \n"+veiculo);
                    service.VeiculoService.Atualizar(veiculo);
                }
                this.telaCadastroVeiculo.setTelaInstanciada(false);
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
                this.telaCadastroVeiculo.setTelaInstanciada(true);
                this.telaCadastroVeiculo.setAtualizando(false);
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
            this.telaCadastroVeiculo.setTelaInstanciada(false);
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
            this.telaCadastroVeiculo.setTelaInstanciada(true);
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonFiltrar()){
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonCarregar()){
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonSair()){
           this.telaCadastroVeiculo.dispose();
        }
        
        //LISTENERS PARA TROCA JCOMBOBOX
        else if(e.getSource() == this.telaCadastroVeiculo.getjComboBoxModelo()){
            //if(!this.telaCadastroVeiculo.isAtualizando() || this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedIndex()>-1){
            if(this.telaCadastroVeiculo.isTelaInstanciada()){
                if(!this.telaCadastroVeiculo.isAtualizando() || this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedIndex()>-1){
                    this.telaCadastroVeiculo.setAtualizando(true);

                    //String modeloSelecionado_STR = (String)this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedItem();
                    Modelo modeloSelecionado = (Modelo)this.telaCadastroVeiculo.getjComboBoxModelo().getSelectedItem();
                    JOptionPane.showMessageDialog(null, modeloSelecionado);
                    JOptionPane.showMessageDialog(null, "marca: " + modeloSelecionado.getMarca());
                    this.telaCadastroVeiculo.getjComboBoxMarca().setSelectedItem(modeloSelecionado.getMarca());

                    this.telaCadastroVeiculo.getjComboBoxMarca().setEnabled(false);
                }
            }
        } else if(e.getSource() == this.telaCadastroVeiculo.getjComboBoxMarca()){
            if(this.telaCadastroVeiculo.isTelaInstanciada()){
                //JOptionPane.showMessageDialog(null, "if_1: "+this.telaCadastroVeiculo.isTelaInstanciada());
                if(!this.telaCadastroVeiculo.isAtualizando()){
                    JOptionPane.showMessageDialog(null, "if_2: "+this.telaCadastroVeiculo.isTelaInstanciada());
                    //this.telaCadastroVeiculo.setAtualizando(true);

                    Marca marcaSelecionada = (Marca)this.telaCadastroVeiculo.getjComboBoxMarca().getSelectedItem();
                    JOptionPane.showMessageDialog(null, "marca: " + marcaSelecionada);
                    
                    /*List<Modelo> modelosCadastrados = new ArrayList<>();
                    modelosCadastrados = service.ModeloService.ConsultaJoin(this.telaCadastroVeiculo.getjTextFieldValor().getText());*/
                    
                    /*Modelo[] modelosCadastrados;
                    modelosCadastrados = service.ModeloService.ConsultaJoin(this.telaCadastroVeiculo.getjTextFieldValor().getText()).toArray();
                    
                    this.telaCadastroVeiculo.getjComboBoxModelo().setModel(new DefaultComboBoxModel<>(modelosCadastrados.toArray()));*/
                    //JOptionPane.showMessageDialog(null, modeloSelecionado);
                    //this.telaCadastroVeiculo.getjComboBoxMarca().setSelectedItem(modeloSelecionado.getMarca());

                    
                    //----------------CORRECAO DO CODIGO - INICIO--------------------
                    // 1. Obtém a lista do service
                    //List<Modelo> listaModelos = service.ModeloService.ConsultaJoin(this.telaCadastroVeiculo.getjTextFieldValor().getText());
                    List<Modelo> listaModelos = service.ModeloService.ConsultaJoin(marcaSelecionada.toString());

                    // 2. Converte a List<Modelo> para Modelo[] (Array Tipado)
                    Modelo[] arrayModelos = listaModelos.toArray(new Modelo[0]);
                    JOptionPane.showMessageDialog(null, arrayModelos);

                    // 3. Cria o modelo para o JComboBox usando Generics <Modelo>
                    DefaultComboBoxModel<Modelo> model = new DefaultComboBoxModel<>(arrayModelos);

                    // 4. Aplica ao componente
                    this.telaCadastroVeiculo.getjComboBoxModelo().setModel(model);
                    
                    //----------------CORRECAO DO CODIGO - FIM--------------------
                    
                    
                    //JOptionPane.showMessageDialog(null, modeloSelecionado);
                    //this.telaCadastroVeiculo.getjComboBoxMarca().setSelectedItem(modeloSelecionado.getMarca());

                    this.telaCadastroVeiculo.getjComboBoxMarca().setEnabled(false);
                }
            }
        }
        
    }
}