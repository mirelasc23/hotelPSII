package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.ProdutoCopa;
import view.BuscaProdutoCopa;
import view.CadastroProdutoCopa;

public class ControllerCadProdutoCopa implements ActionListener{
        private CadastroProdutoCopa telaCadastroProdutoCopa;
        public static int codigo;

    public ControllerCadProdutoCopa(CadastroProdutoCopa telaCadastroProdutoCopa) {
        this.telaCadastroProdutoCopa = telaCadastroProdutoCopa;
        
        this.telaCadastroProdutoCopa.getjButtonNovo().addActionListener(this);
        this.telaCadastroProdutoCopa.getjButtonGravar().addActionListener(this);
        this.telaCadastroProdutoCopa.getjButtonBuscar().addActionListener(this);
        this.telaCadastroProdutoCopa.getjButtonCancelar().addActionListener(this);
        this.telaCadastroProdutoCopa.getjButtonSair().addActionListener(this);
        
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroProdutoCopa.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroProdutoCopa.getjPanelDados(), false);
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroProdutoCopa.getjButtonNovo()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroProdutoCopa.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroProdutoCopa.getjPanelDados(), true);
            
            this.telaCadastroProdutoCopa.getjTextFieldID().setEnabled(false);
            this.telaCadastroProdutoCopa.getjComboBoxStatus().setSelectedIndex(0);
            this.telaCadastroProdutoCopa.getjComboBoxStatus().setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "botao NOVO");
        }else if(e.getSource() == this.telaCadastroProdutoCopa.getjButtonGravar()){
            JOptionPane.showMessageDialog(null, "botao GRAVAR");
            if(this.telaCadastroProdutoCopa.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")){
                JOptionPane.showMessageDialog(null, "Atributo Obrigatorio");
                this.telaCadastroProdutoCopa.getjTextFieldDescricao().requestFocus();
            }else{
                ProdutoCopa produtoCopa = new ProdutoCopa();
                
                produtoCopa.setDescricao(this.telaCadastroProdutoCopa.getjTextFieldDescricao().getText());
                
                try {
                    // Isso pode lançar a NumberFormatException: empty String (se vazio) 
                    // ou apenas NumberFormatException (se não for número)
                    produtoCopa.setValor(Float.parseFloat(this.telaCadastroProdutoCopa.getjFormattedTextFieldValor().getText()));
                } catch (NumberFormatException ex) {
                    // O campo estava vazio OU o texto não era um número
                    // Você pode registrar o erro, setar um valor padrão, ou avisar o usuário.
                    JOptionPane.showMessageDialog(null, "Erro de formato numérico ou campo vazio. Use '.' para separar os decimais.");
                    // e.printStackTrace(); // Apenas para debug
                }
                
                produtoCopa.setObs(this.telaCadastroProdutoCopa.getjTextAreaObs().getText());
                
                char status;
                if(this.telaCadastroProdutoCopa.getjComboBoxStatus().getSelectedIndex() == 0){
                    status = 'a';
                }else {
                    status = 'i';
                }
                produtoCopa.setStatus(status);
                
                this.telaCadastroProdutoCopa.getjTextFieldDescricao().requestFocus();
                
                if(this.telaCadastroProdutoCopa.getjTextFieldID().getText().trim().equalsIgnoreCase("")){
                    //inclusao
                    produtoCopa.setStatus('A');
                    service.ProdutoCopaService.Criar(produtoCopa);
                } else{
                    produtoCopa.setId(Integer.parseInt(this.telaCadastroProdutoCopa.getjTextFieldID().getText()));
                    service.ProdutoCopaService.Atualizar(produtoCopa);
                }
                
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroProdutoCopa.getjPanelBotoes(), true);
                utilities.Utilities.limpaComponentes(this.telaCadastroProdutoCopa.getjPanelDados(), false);
            }
        }else if(e.getSource() == this.telaCadastroProdutoCopa.getjButtonBuscar()){
            JOptionPane.showMessageDialog(null, "botao BUSCAR");
            BuscaProdutoCopa telaBuscaProdutoCopa= new BuscaProdutoCopa(null, true);
            ControllerBuscaProdutoCopa controllerBuscaProdutoCopa = new ControllerBuscaProdutoCopa(telaBuscaProdutoCopa);
            telaBuscaProdutoCopa.setVisible(true);
            
            if (codigo != 0) {
                utilities.Utilities.ativaDesativaBotoes(this.telaCadastroProdutoCopa.getjPanelBotoes(), false);
                utilities.Utilities.limpaComponentes(this.telaCadastroProdutoCopa.getjPanelDados(), true);

                this.telaCadastroProdutoCopa.getjTextFieldID().setText(codigo + "");
                this.telaCadastroProdutoCopa.getjTextFieldID().setEnabled(false);
                
                
                ProdutoCopa produtoCopa = new ProdutoCopa();
                produtoCopa = service.ProdutoCopaService.Carregar(codigo);

                this.telaCadastroProdutoCopa.getjTextFieldDescricao().setText(produtoCopa.getDescricao());
                this.telaCadastroProdutoCopa.getjFormattedTextFieldValor().setText(String.valueOf(produtoCopa.getValor()));
                this.telaCadastroProdutoCopa.getjTextAreaObs().setText(produtoCopa.getObs());
                int index_status;
                if(produtoCopa.getStatus() == 'a' || produtoCopa.getStatus() == 'A'){
                    index_status = 0;
                }else {
                    
                    index_status = 1;
                }
                this.telaCadastroProdutoCopa.getjComboBoxStatus().setSelectedIndex(index_status);
                this.telaCadastroProdutoCopa.getjTextFieldDescricao().requestFocus();
        
        }else if(e.getSource() == this.telaCadastroProdutoCopa.getjButtonCancelar()){
            JOptionPane.showMessageDialog(null, "botao cancelar");
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroProdutoCopa.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroProdutoCopa.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroProdutoCopa.getjButtonSair()){
           this.telaCadastroProdutoCopa.dispose();
        }  
    
    }}
}