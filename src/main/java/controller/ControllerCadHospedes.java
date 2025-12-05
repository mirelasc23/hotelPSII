package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import model.Hospede;
import view.BuscaHospede;
import view.CadastroHospedes;

public class ControllerCadHospedes implements ActionListener{
    CadastroHospedes telaCadastroHospedes;
    public static int codigo;

    public ControllerCadHospedes(CadastroHospedes telaCadastroHospedes) {
        this.telaCadastroHospedes = telaCadastroHospedes;
        this.telaCadastroHospedes.getjButtonNovo().addActionListener(this);
        this.telaCadastroHospedes.getjButtonGravar().addActionListener(this);
        this.telaCadastroHospedes.getjButtonBuscar().addActionListener(this);
        this.telaCadastroHospedes.getjButtonCancelar().addActionListener(this);
        this.telaCadastroHospedes.getjButtonSair().addActionListener(this);
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroHospedes.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroHospedes.getjPanelDados(), false);
        
        //Desenvolver as setagens de situação inicial dos componentes:  ||quais botões estarão ativos
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroHospedes.getjButtonNovo()){
            
            Date hoje = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String data = sdf.format(hoje);
            
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroHospedes.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospedes.getjPanelDados(), true);
            
            this.telaCadastroHospedes.getjFormattedTextFieldDataCadastro().setText(data);
            this.telaCadastroHospedes.getjFormattedTextFieldDataCadastro().setEnabled(false);
            this.telaCadastroHospedes.getjTextFieldID().setEnabled(false);
        }else if(e.getSource() == this.telaCadastroHospedes.getjButtonGravar()){
            
            if(this.telaCadastroHospedes.getjTextFieldNomeFantasia().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroHospedes.getjTextFieldNomeFantasia().requestFocus();
            }else{

                Hospede hospede = new Hospede();

                //hospede.setId(Integer.parseInt(this.telaCadastroHospedes.getjTextFieldID().getText()));
                hospede.setNome(this.telaCadastroHospedes.getjTextFieldNomeFantasia().getText());
                hospede.setFone1(this.telaCadastroHospedes.getjFormattedTextFieldFone1().getText());
                hospede.setFone2(this.telaCadastroHospedes.getjFormattedTextFieldFone2().getText());
                hospede.setEmail(this.telaCadastroHospedes.getjTextFieldEmail().getText());
                hospede.setCep(this.telaCadastroHospedes.getjFormattedTextFieldCep().getText());
                hospede.setLogradouro(this.telaCadastroHospedes.getjTextFieldLogradouro().getText());
                hospede.setBairro(this.telaCadastroHospedes.getjTextFielBairro().getText());
                hospede.setCidade(this.telaCadastroHospedes.getjTextFieldCidade().getText());
                hospede.setComplemento(this.telaCadastroHospedes.getjTextFieldComplemento().getText());
                hospede.setDataCadastro(this.telaCadastroHospedes.getjFormattedTextFieldDataCadastro().getText());
                hospede.setCpf(this.telaCadastroHospedes.getjFormattedTextFieldCpf().getText());
                hospede.setRg(this.telaCadastroHospedes.getjTextFieldRG().getText());
                hospede.setObs(this.telaCadastroHospedes.getjTextFieldObs().getText());
                //hospede.setStatus(this.telaCadastroHospedes.getj().setText(hospede.getStatus()));
                hospede.setRazaoSocial(this.telaCadastroHospedes.getjTextFieldRazaoSocial().getText());
                hospede.setCnpj(this.telaCadastroHospedes.getjFormattedTextFieldCnpj().getText());
                hospede.setInscricaoEstdual(this.telaCadastroHospedes.getjTextFieldIE().getText());
                hospede.setContato(this.telaCadastroHospedes.getjTextFieldContato().getText());
                char sexo;
                if(this.telaCadastroHospedes.getjComboBoxSexo().getSelectedIndex() == 0){
                    sexo = 'f';
                }else {
                    sexo = 'm';
                }
                hospede.setSexo(sexo);

                /*
                    Não efetuar a atribuicao de id como set porque no bd é automatico
                    Não efetuar a atribuicao de status porque ainda nao esta sendo considerado

                */


                //try{
                    if(this.telaCadastroHospedes.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                        //inclusao
                        hospede.setStatus('A');
                        service.HospedeService.criar(hospede);
                    } else{
                        hospede.setId(Integer.parseInt(this.telaCadastroHospedes.getjTextFieldID().getText()));
                        service.HospedeService.atualizar(hospede);
                    }
                /*} catch (Exception ex) {
                    ex.printStackTrace();
                } */

                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroHospedes.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroHospedes.getjPanelDados(), false);
            }

        }else if(e.getSource() == this.telaCadastroHospedes.getjButtonBuscar()){
            /*BuscaHospede telaBuscaHospede= new BuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospedes = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);
            
            if (codigo != 0){
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroHospedes.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroHospedes.getjPanelDados(), true);
                
                this.telaCadastroHospedes.getjTextFieldID().setText(codigo + "");
                this.telaCadastroHospedes.getjTextFieldID().setEnabled(false);
                
                Hospede hospede = new Hospede();
                hospede = service.HospedeService.carregar(codigo);
                
                this.telaCadastroHospedes.getjTextFieldNomeFantasia().setText(hospede.getNome());
                this.telaCadastroHospedes.getjFormattedTextField2().setText(hospede.getFone1());
                this.telaCadastroHospedes.getjFormattedTextField3().setText(hospede.getFone2());
                this.telaCadastroHospedes.getjTextFieldEmail().setText(hospede.getEmail());
                this.telaCadastroHospedes.getjFormattedTextField4().setText(hospede.getCep());
                this.telaCadastroHospedes.getjTextFieldLogradouro().setText(hospede.getLogradouro());
                this.telaCadastroHospedes.getjTextFielBairro().setText(hospede.getBairro());
                this.telaCadastroHospedes.getjTextFieldCidade().setText(hospede.getCidade());
                this.telaCadastroHospedes.getjTextFieldComplemento().setText(hospede.getComplemento());
                this.telaCadastroHospedes.getjFormattedTextField5().setText(hospede.getDataCadastro());
                this.telaCadastroHospedes.getjFormattedTextField6().setText(hospede.getCpf());
                this.telaCadastroHospedes.getjTextFieldRG().setText(hospede.getRg());
                this.telaCadastroHospedes.getjTextFieldObs().setText(hospede.getObs());
                //this.telaCadastroHospedes.getj().setText(hospede.getStatus());
                this.telaCadastroHospedes.getjTextFieldRazaoSocial().setText(hospede.getRazaoSocial());
                this.telaCadastroHospedes.getjFormattedTextField7().setText(hospede.getCnpj());
                this.telaCadastroHospedes.getjTextFieldIE().setText(hospede.getInscricaoEstdual());
                this.telaCadastroHospedes.getjTextFieldContato().setText(hospede.getContato());
                
                this.telaCadastroHospedes.getjTextFieldNomeFantasia().requestFocus();
                */
            
            
            codigo = 0;

            BuscaHospede telaBuscaHospede = new BuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospede = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);

            if (codigo != 0) {
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroHospedes.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroHospedes.getjPanelDados(), true);

                this.telaCadastroHospedes.getjTextFieldID().setText(codigo + "");
                this.telaCadastroHospedes.getjTextFieldID().setEnabled(false);

                Hospede hospede = new Hospede();
                hospede = service.HospedeService.Carregar(codigo);

                this.telaCadastroHospedes.getjTextFieldNomeFantasia().setText(hospede.getNome());
                this.telaCadastroHospedes.getjFormattedTextFieldFone1().setText(hospede.getFone1());
                this.telaCadastroHospedes.getjFormattedTextFieldFone2().setText(hospede.getFone2());
                this.telaCadastroHospedes.getjTextFieldEmail().setText(hospede.getEmail());
                this.telaCadastroHospedes.getjFormattedTextFieldCep().setText(hospede.getCep());
                this.telaCadastroHospedes.getjTextFieldLogradouro().setText(hospede.getLogradouro());
                this.telaCadastroHospedes.getjTextFielBairro().setText(hospede.getBairro());
                this.telaCadastroHospedes.getjTextFieldCidade().setText(hospede.getCidade());
                this.telaCadastroHospedes.getjTextFieldComplemento().setText(hospede.getComplemento());
                this.telaCadastroHospedes.getjFormattedTextFieldDataCadastro().setText(hospede.getDataCadastro());
                this.telaCadastroHospedes.getjFormattedTextFieldCpf().setText(hospede.getCpf());
                this.telaCadastroHospedes.getjTextFieldRG().setText(hospede.getRg());
                this.telaCadastroHospedes.getjTextFieldObs().setText(hospede.getObs());
                //this.telaCadastroHospedes.getj().setText(hospede.getStatus());
                this.telaCadastroHospedes.getjTextFieldRazaoSocial().setText(hospede.getRazaoSocial());
                this.telaCadastroHospedes.getjFormattedTextFieldCnpj().setText(hospede.getCnpj());
                this.telaCadastroHospedes.getjTextFieldIE().setText(hospede.getInscricaoEstdual());
                this.telaCadastroHospedes.getjTextFieldContato().setText(hospede.getContato());
                int index_sexo;
                if(hospede.getSexo() == 'f' || hospede.getSexo() == 'F'){
                    index_sexo = 0;
                }else{
                    index_sexo = 1;
                }
                this.telaCadastroHospedes.getjComboBoxSexo().setSelectedIndex(index_sexo);
                

                //carregar os dados para os containers faltantes
                this.telaCadastroHospedes.getjTextFieldNomeFantasia().requestFocus();
            }
        }else if(e.getSource() == this.telaCadastroHospedes.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroHospedes.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroHospedes.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroHospedes.getjButtonSair()){
           this.telaCadastroHospedes.dispose();
        }
        
    }
    

}
//https://www.google.com/search?q=como+ativar+e+desativar+sequencia+de+botoes+com+netbeans%2C+usando+mvc&oq=como+ativar+e+desativar+sequencia+de+botoes+com+netbeans%2C+usando+mvc&aqs=chrome..69i57.36815j0j1&sourceid=chrome&ie=UTF-8
//https://www.guj.com.br/t/duvidas-de-ordenacao-e-limpar-textarea-resolvido/36037

/* tab index:
    https://www.google.com/search?q=tabindex+em+java+exemplo&oq=tabindex+em+java+exemplo&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDM3OTFqMGoxqAIAsAIA&sourceid=chrome&ie=UTF-8
    https://www.google.com/search?q=alterar+ordem+do+tab+com+tabindex+em+java&sca_esv=cb1e697b99ad7555&sxsrf=AE3TifOFcLI1m6t3Uqc3jtk3RjAZ8UlZhg%3A1757632045149&ei=LVbDaOLvCKrT1sQPrbaTkQE&ved=0ahUKEwiiusnN6dGPAxWqqZUCHS3bJBIQ4dUDCBA&uact=5&oq=alterar+ordem+do+tab+com+tabindex+em+java&gs_lp=Egxnd3Mtd2l6LXNlcnAiKWFsdGVyYXIgb3JkZW0gZG8gdGFiIGNvbSB0YWJpbmRleCBlbSBqYXZhMgUQABjvBTIFEAAY7wUyBRAAGO8FMggQABiiBBiJBTIFEAAY7wVIyixQygdY-ilwAngAkAEAmAGRAaABiA6qAQQwLjE0uAEDyAEA-AEBmAILoAKiCcICCBAAGLADGO8FwgIHECMYsAIYJ8ICChAhGKABGMMEGAqYAwCIBgGQBgSSBwMyLjmgB4RFsgcDMC45uAeZCcIHBTAuOS4yyAcb&sclient=gws-wiz-serp
    https://www.google.com/search?q=alterar+ordem+do+tab+em+java&oq=alterar+ordem+do+tab+em+java&gs_lcrp=EgZjaHJvbWUyBggAEEUYOdIBCDQ1ODRqMGoxqAIAsAIA&sourceid=chrome&ie=UTF-8

    duplo clique:
    https://www.google.com/search?q=como+colocar+evento+em+duplo+clique+em+java&sca_esv=dd1bb8bd48a3d6f2&sxsrf=AE3TifPcos_P5R-hEHgk4m9dKd_ONqyf3A%3A1757631976168&ei=6FXDaOaCCpHT1sQP4rC4oQY&ved=0ahUKEwjmltes6dGPAxWRqZUCHWIYLmQQ4dUDCBA&uact=5&oq=como+colocar+evento+em+duplo+clique+em+java&gs_lp=Egxnd3Mtd2l6LXNlcnAiK2NvbW8gY29sb2NhciBldmVudG8gZW0gZHVwbG8gY2xpcXVlIGVtIGphdmEyBRAAGO8FMggQABiABBiiBDIFEAAY7wUyBRAAGO8FSNUyULUFWPQTcAF4AJABAJgBpAGgAaAKqgEEMC4xMLgBA8gBAPgBAZgCCKACnAfCAggQABiwAxjvBcICCxAAGLADGKIEGIkFwgIHECMYsAIYJ8ICCBAAGKIEGIkFmAMAiAYBkAYDkgcDMS43oAf4MLIHAzAuN7gHlwfCBwUwLjYuMsgHEw&sclient=gws-wiz-serp
*/














