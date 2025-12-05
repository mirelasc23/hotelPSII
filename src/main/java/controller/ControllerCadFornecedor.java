package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Fornecedor;
import javax.swing.JOptionPane;
import view.BuscaFornecedor;
import view.CadastroFornecedores;

public class ControllerCadFornecedor implements ActionListener{
    private CadastroFornecedores telaCadastroFornecedores;
    public static int codigo;
    
    public ControllerCadFornecedor(CadastroFornecedores telaCadastroFornecedores) {
        this.telaCadastroFornecedores = telaCadastroFornecedores;
        
        this.telaCadastroFornecedores.getjButtonNovo().addActionListener(this);
        this.telaCadastroFornecedores.getjButtonGravar().addActionListener(this);
        this.telaCadastroFornecedores.getjButtonBuscar().addActionListener(this);
        this.telaCadastroFornecedores.getjButtonCancelar().addActionListener(this);
        this.telaCadastroFornecedores.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFornecedores.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroFornecedores.getjPanelDados(), false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroFornecedores.getjButtonNovo()){
            Date hoje = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = sdf.format(hoje);
            
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFornecedores.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedores.getjPanelDados(), true);
            
            this.telaCadastroFornecedores.getjFormattedTextFieldDataCadastro().setText(data);
            this.telaCadastroFornecedores.getjFormattedTextFieldDataCadastro().setEnabled(false);
            this.telaCadastroFornecedores.getjTextFieldID().setEnabled(false);
        }else if(e.getSource() == this.telaCadastroFornecedores.getjButtonGravar()){
             if(this.telaCadastroFornecedores.getjTextFieldNomeFantasia().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroFornecedores.getjTextFieldNomeFantasia().requestFocus();
            }else{

                Fornecedor fornecedor = new Fornecedor();

                //hospede.setId(Integer.parseInt(this.telaCadastroHospedes.getjTextFieldID().getText()));
                fornecedor.setNome(this.telaCadastroFornecedores.getjTextFieldNomeFantasia().getText());
                fornecedor.setFone1(this.telaCadastroFornecedores.getjFormattedTextFieldFone().getText());
                fornecedor.setFone2(this.telaCadastroFornecedores.getjFormattedTextFieldFone2().getText());
                fornecedor.setEmail(this.telaCadastroFornecedores.getjTextFieldEmail().getText());
                fornecedor.setCep(this.telaCadastroFornecedores.getjFormattedTextFieldCep().getText());
                fornecedor.setLogradouro(this.telaCadastroFornecedores.getjTextFieldLogradouro().getText());
                fornecedor.setBairro(this.telaCadastroFornecedores.getjTextFielBairro().getText());
                fornecedor.setCidade(this.telaCadastroFornecedores.getjTextFieldCidade().getText());
                fornecedor.setComplemento(this.telaCadastroFornecedores.getjTextFieldComplemento().getText());
                fornecedor.setDataCadastro(this.telaCadastroFornecedores.getjFormattedTextFieldDataCadastro().getText());
                fornecedor.setCpf(this.telaCadastroFornecedores.getjFormattedTextFieldCpf().getText());
                fornecedor.setRg(this.telaCadastroFornecedores.getjTextFieldRG().getText());
                fornecedor.setObs(this.telaCadastroFornecedores.getjTextFieldObs().getText());
                //hospede.setStatus(this.telaCadastroHospedes.getj().setText(hospede.getStatus()));
                fornecedor.setRazaoSocial(this.telaCadastroFornecedores.getjTextFieldRazaoSocial().getText());
                fornecedor.setCnpj(this.telaCadastroFornecedores.getjFormattedTextFieldCnpj().getText());
                fornecedor.setInscricaoEstadual(this.telaCadastroFornecedores.getjTextFieldIE().getText());
                fornecedor.setContato(this.telaCadastroFornecedores.getjTextFieldContato().getText());
                char sexo;
                if(this.telaCadastroFornecedores.getjComboBoxSexo().getSelectedIndex() == 0){
                    sexo = 'f';
                }else {
                    sexo = 'm';
                }
                fornecedor.setSexo(sexo);
                if(this.telaCadastroFornecedores.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                    //inclusao
                    fornecedor.setStatus('A');
                    service.FornecedorService.Criar(fornecedor);
                } else{
                    fornecedor.setId(Integer.parseInt(this.telaCadastroFornecedores.getjTextFieldID().getText()));
                    service.FornecedorService.Atualizar(fornecedor);
                }
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFornecedores.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroFornecedores.getjPanelDados(), false);
             }
        }else if(e.getSource() == this.telaCadastroFornecedores.getjButtonBuscar()){
            //JOptionPane.showMessageDialog(null, "Falta ControllerBuscaFuncionarios");
            JOptionPane.showMessageDialog(null, "ENTROU EM BUSCAR");
            BuscaFornecedor telaBuscaFornecedor= new BuscaFornecedor(null, true);
            ControllerBuscaFornecedor controllerBuscaFornecedor = new ControllerBuscaFornecedor(telaBuscaFornecedor);
            telaBuscaFornecedor.setVisible(true);
            
            if (codigo != 0) {
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFornecedores.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroFornecedores.getjPanelDados(), true);

                this.telaCadastroFornecedores.getjTextFieldID().setText(codigo + "");
                this.telaCadastroFornecedores.getjTextFieldID().setEnabled(false);
                
                
                Fornecedor fornecedor = new Fornecedor();
                fornecedor = service.FornecedorService.Carregar(codigo);

                this.telaCadastroFornecedores.getjTextFieldNomeFantasia().setText(fornecedor.getNome());
                this.telaCadastroFornecedores.getjFormattedTextFieldFone().setText(fornecedor.getFone1());
                this.telaCadastroFornecedores.getjFormattedTextFieldFone2().setText(fornecedor.getFone2());
                this.telaCadastroFornecedores.getjTextFieldEmail().setText(fornecedor.getEmail());
                this.telaCadastroFornecedores.getjFormattedTextFieldCep().setText(fornecedor.getCep());
                this.telaCadastroFornecedores.getjTextFieldLogradouro().setText(fornecedor.getLogradouro());
                this.telaCadastroFornecedores.getjTextFielBairro().setText(fornecedor.getBairro());
                this.telaCadastroFornecedores.getjTextFieldCidade().setText(fornecedor.getCidade());
                this.telaCadastroFornecedores.getjTextFieldComplemento().setText(fornecedor.getComplemento());
                this.telaCadastroFornecedores.getjFormattedTextFieldDataCadastro().setText(fornecedor.getDataCadastro());
                this.telaCadastroFornecedores.getjFormattedTextFieldCpf().setText(fornecedor.getCpf());
                this.telaCadastroFornecedores.getjTextFieldRG().setText(fornecedor.getRg());
                this.telaCadastroFornecedores.getjTextFieldObs().setText(fornecedor.getObs());
                //this.telaCadastroFornecedores.getj().setText(hospede.getStatus());
                this.telaCadastroFornecedores.getjTextFieldRazaoSocial().setText(fornecedor.getRazaoSocial());
                this.telaCadastroFornecedores.getjFormattedTextFieldCnpj().setText(fornecedor.getCnpj());
                this.telaCadastroFornecedores.getjTextFieldIE().setText(fornecedor.getInscricaoEstadual());
                this.telaCadastroFornecedores.getjTextFieldContato().setText(fornecedor.getContato());
                int index_sexo;
                if(fornecedor.getSexo() == 'f' || fornecedor.getSexo() == 'F'){
                    index_sexo = 0;
                }else{
                    index_sexo = 1;
                }
                this.telaCadastroFornecedores.getjComboBoxSexo().setSelectedIndex(index_sexo);
                

                //carregar os dados para os containers faltantes
                this.telaCadastroFornecedores.getjTextFieldNomeFantasia().requestFocus();
            }


        }else if(e.getSource() == this.telaCadastroFornecedores.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroFornecedores.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroFornecedores.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroFornecedores.getjButtonSair()){
           this.telaCadastroFornecedores.dispose();
        }
    }
    
    
}
