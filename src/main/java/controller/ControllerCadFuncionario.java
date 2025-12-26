package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Funcionario;
import view.BuscaFuncionario;
import view.CadastroFuncionarios;

public class ControllerCadFuncionario implements ActionListener{
    private CadastroFuncionarios telaCadastroFuncionarios;
    public static int codigo;
    
    public ControllerCadFuncionario(CadastroFuncionarios telaCadastroFuncionarios) {
        this.telaCadastroFuncionarios = telaCadastroFuncionarios;
        this.telaCadastroFuncionarios.getjButtonNovo().addActionListener(this);
        this.telaCadastroFuncionarios.getjButtonGravar().addActionListener(this);
        this.telaCadastroFuncionarios.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFuncionarios.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFuncionarios.getjButtonSair().addActionListener(this);
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFuncionarios.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFuncionarios.getjPanelDados(), false);
        
        //Desenvolver as setagens de situação inicial dos componentes:  ||quais botões estarão ativos
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroFuncionarios.getjButtonNovo()){
            Date hoje = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = sdf.format(hoje);
            
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFuncionarios.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionarios.getjPanelDados(), true);
            
            this.telaCadastroFuncionarios.getjFormattedTextFieldDataCadastro().setText(data);
            this.telaCadastroFuncionarios.getjFormattedTextFieldDataCadastro().setEnabled(false);
            this.telaCadastroFuncionarios.getjTextFieldID().setEnabled(false);
          
        }else if(e.getSource() == this.telaCadastroFuncionarios.getjButtonGravar()){
            if(this.telaCadastroFuncionarios.getjTextFieldNomeFantasia().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroFuncionarios.getjTextFieldNomeFantasia().requestFocus();
            }else{

                Funcionario funcionario = new Funcionario();

                //funcionario.setId(Integer.parseInt(this.telaCadastroFuncionarios.getjTextFieldID().getText()));
                funcionario.setNome(this.telaCadastroFuncionarios.getjTextFieldNomeFantasia().getText());
                funcionario.setFone1(this.telaCadastroFuncionarios.getjFormattedTextFieldFone().getText());
                funcionario.setFone2(this.telaCadastroFuncionarios.getjFormattedTextFieldFone2().getText());
                funcionario.setEmail(this.telaCadastroFuncionarios.getjTextFieldEmail().getText());
                funcionario.setCep(this.telaCadastroFuncionarios.getjFormattedTextFieldCep().getText());
                funcionario.setLogradouro(this.telaCadastroFuncionarios.getjTextFieldLogradouro().getText());
                funcionario.setBairro(this.telaCadastroFuncionarios.getjTextFielBairro().getText());
                funcionario.setCidade(this.telaCadastroFuncionarios.getjTextFieldCidade().getText());
                funcionario.setComplemento(this.telaCadastroFuncionarios.getjTextFieldComplemento().getText());
                funcionario.setDataCadastro(this.telaCadastroFuncionarios.getjFormattedTextFieldDataCadastro().getText());
                funcionario.setCpf(this.telaCadastroFuncionarios.getjFormattedTextFieldCpf().getText());
                funcionario.setRg(this.telaCadastroFuncionarios.getjTextFieldRG().getText());
                funcionario.setObs(this.telaCadastroFuncionarios.getjTextFieldObs().getText());
                funcionario.setUsuario(this.telaCadastroFuncionarios.getjTextFieldUsuario().getText());
                funcionario.setSenha(this.telaCadastroFuncionarios.getjPasswordFieldSenha().getText());
                
                char sexo;
                if(this.telaCadastroFuncionarios.getjComboBoxSexo().getSelectedIndex() == 0){
                    sexo = 'f';
                }else {
                    sexo = 'm';
                }
                
                
                funcionario.setSexo(sexo);
                if(this.telaCadastroFuncionarios.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                    //inclusao
                    //JOptionPane.showMessageDialog(null, "entrou em criar");
                    funcionario.setStatus('a');
                    service.FuncionarioService.Criar(funcionario);
                } else{
                    funcionario.setId(Integer.parseInt(this.telaCadastroFuncionarios.getjTextFieldID().getText()));
                    char status;
                    if(this.telaCadastroFuncionarios.getjComboBoxSexoStatus().getSelectedIndex() == 0){
                        status = 'a';
                    }else{
                        status = 'i';
                    }

                    funcionario.setStatus(status);
                    /*JOptionPane.showMessageDialog(null, status);
                    JOptionPane.showMessageDialog(null, "entrou em atualizar");
                    JOptionPane.showMessageDialog(null, funcionario);*/
                    service.FuncionarioService.Atualizar(funcionario);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFuncionarios.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroFuncionarios.getjPanelDados(), false);
             }
        }else if(e.getSource() == this.telaCadastroFuncionarios.getjButtonBuscar()){
            //JOptionPane.showMessageDialog(null, "Falta Controller Busca!!");
            
            BuscaFuncionario telaBuscaFuncionario = new BuscaFuncionario(null, true);
            ControllerBuscaFuncionario controllerBuscaHospedes = new ControllerBuscaFuncionario(telaBuscaFuncionario);
            telaBuscaFuncionario.setVisible(true);
            
            if (codigo != 0) {
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFuncionarios.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroFuncionarios.getjPanelDados(), true);

                this.telaCadastroFuncionarios.getjTextFieldID().setText(codigo + "");
                this.telaCadastroFuncionarios.getjTextFieldID().setEnabled(false);
                
                
                Funcionario funcionario = new Funcionario();
                funcionario = service.FuncionarioService.Carregar(codigo);

                this.telaCadastroFuncionarios.getjTextFieldNomeFantasia().setText(funcionario.getNome());
                this.telaCadastroFuncionarios.getjFormattedTextFieldFone().setText(funcionario.getFone1());
                this.telaCadastroFuncionarios.getjFormattedTextFieldFone2().setText(funcionario.getFone2());
                this.telaCadastroFuncionarios.getjTextFieldEmail().setText(funcionario.getEmail());
                this.telaCadastroFuncionarios.getjFormattedTextFieldCep().setText(funcionario.getCep());
                this.telaCadastroFuncionarios.getjTextFieldLogradouro().setText(funcionario.getLogradouro());
                this.telaCadastroFuncionarios.getjTextFielBairro().setText(funcionario.getBairro());
                this.telaCadastroFuncionarios.getjTextFieldCidade().setText(funcionario.getCidade());
                this.telaCadastroFuncionarios.getjTextFieldComplemento().setText(funcionario.getComplemento());
                this.telaCadastroFuncionarios.getjFormattedTextFieldDataCadastro().setText(funcionario.getDataCadastro());
                this.telaCadastroFuncionarios.getjFormattedTextFieldCpf().setText(funcionario.getCpf());
                this.telaCadastroFuncionarios.getjTextFieldRG().setText(funcionario.getRg());
                this.telaCadastroFuncionarios.getjTextFieldUsuario().setText(funcionario.getUsuario());
                this.telaCadastroFuncionarios.getjPasswordFieldSenha().setText(funcionario.getSenha());
                this.telaCadastroFuncionarios.getjTextFieldObs().setText(funcionario.getObs());
                
                
                int index_sexo;
                if(funcionario.getSexo() == 'f' || funcionario.getSexo() == 'F'){
                    index_sexo = 0;
                }else{
                    index_sexo = 1;
                }
         
                int index_status;
                if(funcionario.getStatus() == 'a' || funcionario.getStatus() == 'A' ){
                    index_status = 0;
                }else{
                    index_status = 1;
                }
                
                this.telaCadastroFuncionarios.getjComboBoxSexo().setSelectedIndex(index_sexo);
                this.telaCadastroFuncionarios.getjComboBoxSexoStatus().setSelectedIndex(index_status);

                //carregar os dados para os containers faltantes
                this.telaCadastroFuncionarios.getjTextFieldNomeFantasia().requestFocus();
            }


        }else if(e.getSource() == this.telaCadastroFuncionarios.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFuncionarios.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFuncionarios.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroFuncionarios.getjButtonSair()){
           this.telaCadastroFuncionarios.dispose();
        }
        
    }

}
