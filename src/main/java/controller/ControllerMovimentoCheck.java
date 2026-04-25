package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import model.Hospede;
import model.OrdemServico;
import model.ProdutoCopa;
import model.Quarto;
import model.Servico;
import model.VagaEstacionamento;
import org.w3c.dom.events.MouseEvent;
import view.BuscaHospede;
import view.BuscaProdutoCopa;
import view.BuscaQuarto;
import view.BuscaServico;
import view.CadastroServico;
import view.CadastroVagaEstacionamento;
import view.CadastroVeiculo;
import view.MovimentoCheck;

public class ControllerMovimentoCheck implements ActionListener, MouseListener, KeyListener{
    MovimentoCheck telaMovimentoCheck;
    public static int codigo;
    public static float total;
    public static List<Quarto> quartos;

    public ControllerMovimentoCheck(MovimentoCheck telaMovimentoCheck) {
        this.telaMovimentoCheck = telaMovimentoCheck;
        
        this.telaMovimentoCheck.getjButtonNovo().addActionListener(this);
        this.telaMovimentoCheck.getjButtonGravar().addActionListener(this);
        this.telaMovimentoCheck.getjButtonBuscar().addActionListener(this);
        this.telaMovimentoCheck.getjButtonCancelar().addActionListener(this);
        this.telaMovimentoCheck.getjButtonSair().addActionListener(this);
        this.telaMovimentoCheck.getjButtonAddCopaProduto().addActionListener(this);
        this.telaMovimentoCheck.getjButtonAddHospede().addActionListener(this);
        this.telaMovimentoCheck.getjButtonAddOS().addActionListener(this);
        this.telaMovimentoCheck.getjButtonAddQuarto().addActionListener(this);
        this.telaMovimentoCheck.getjButtonAddVaga().addActionListener(this);
        
        this.telaMovimentoCheck.getjTextFieldIDHospede().addMouseListener(this);
        //this.telaMovimentoCheck.getjTextFieldIDHospede().addKeyEvent(this);
        this.telaMovimentoCheck.getjTextFieldCopaQuantidade().addKeyListener(this);
        this.telaMovimentoCheck.getjTextFieldOSValor().addKeyListener(this);
        this.telaMovimentoCheck.getjTextFieldIDVaga().addMouseListener(this);
        this.telaMovimentoCheck.getjTextFieldIDQuarto().addMouseListener(this);
        this.telaMovimentoCheck.getjTextFieldIDOs().addMouseListener(this);
        this.telaMovimentoCheck.getjTextFieldIDCopa().addMouseListener(this);
        
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
            utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelDados(), false);
            utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), true);
            
            this.telaMovimentoCheck.getjFormattedTextFieldDataCadastro().setText(data);
            this.telaMovimentoCheck.getjFormattedTextFieldDataCadastro().setEnabled(false);
            
            this.telaMovimentoCheck.getjTextFieldIDReserva().setEnabled(false);
            this.telaMovimentoCheck.getjComboBoxStatusReserva().setSelectedIndex(0);
            this.telaMovimentoCheck.getjComboBoxStatusReserva().setEnabled(false);
            this.telaMovimentoCheck.getjComboBoxStatusReserva().setEnabled(false);
            
            total = 0;
            //this.telaMovimentoCheck.getjComboBoxFiltrarPor().setEnabled(false);
            //this.telaMovimentoCheck.getjTextFieldValor().setEnabled(false);

        } else if (e.getSource() == this.telaMovimentoCheck.getjButtonGravar()) {
            OrdemServico os = new OrdemServico();
            os.setDataHoraCadastro(this.telaMovimentoCheck.getjFormattedTextFieldDataCadastro().getText());
            os.setObs(this.telaMovimentoCheck.getjTextFieldObsReserva().getText());
            Servico servico = service.ServicoService.Carregar(Integer.parseInt(this.telaMovimentoCheck.getjTextFieldIDOs().getText()));
            Quarto quarto = service.QuartoService.Carregar(Integer.parseInt(this.telaMovimentoCheck.getjTextFieldIDQuarto().getText()));
        
            
            /*if (this.telaMovimentoCheck.getjTextFieldDescricao().getText().trim().equalsIgnoreCase("")) {
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
            }*/
        } else if (e.getSource() == this.telaMovimentoCheck.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), false);
        } else if (e.getSource() == this.telaMovimentoCheck.getjButtonSair()) {
            this.telaMovimentoCheck.dispose();
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddCopaProduto()) {
            this.telaMovimentoCheck.getjTextFieldCopaValor().setText("");
            this.telaMovimentoCheck.getjTextFieldCopaDescricao().setText("");
            this.telaMovimentoCheck.getjTextFieldCopaQuantidade().setText("");
            this.telaMovimentoCheck.getjTextFieldIDCopa().setText("");
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddQuarto()) {
            this.telaMovimentoCheck.getjTextFieldQuarto1Valor().setText("");
            this.telaMovimentoCheck.getjTextFieldQuarto1Capacidade().setText("");
            this.telaMovimentoCheck.getjTextFieldQuarto1Descricao().setText("");
            this.telaMovimentoCheck.getjTextFieldQuarto1Obs().setText("");
            this.telaMovimentoCheck.getjTextFieldQuarto1Andar().setText("");
            this.telaMovimentoCheck.getjTextFieldIDQuarto().setText("");
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddHospede()) {
            this.telaMovimentoCheck.getjTextFieldQuarto1Obs().setText("");
            this.telaMovimentoCheck.getjTextFieldIDQuarto().setText("");
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddOS()) {
            this.telaMovimentoCheck.getjTextFieldOSDescricao().setText("");
            this.telaMovimentoCheck.getjTextFieldOSObs().setText("");
            this.telaMovimentoCheck.getjTextFieldOSValor().setText("");
            this.telaMovimentoCheck.getjTextFieldIDOs().setText("");
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
            if (this.telaMovimentoCheck.getjTextFieldIDHospede().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                // Sua lógica de busca aqui
                
                codigo = 0;
                
                BuscaHospede telaBuscaHospede = new BuscaHospede(null, true);
                ControllerBuscaHospede2 controllerBuscaHospede = new ControllerBuscaHospede2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                
                //System.out.println("Clique Duplo Detectado no MousePressed!");
                
                if (codigo != 0) {
                    //utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), false);
                    //utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), true);

                    this.telaMovimentoCheck.getjTextFieldIDHospede().setText(codigo + "");
                    //this.telaMovimentoCheck.getjTextFieldIDHospede().setEnabled(false);

                    Hospede hospede = new Hospede();
                    hospede = service.HospedeService.Carregar(codigo);
                    
                    this.telaMovimentoCheck.getjTextFieldNome().setText(hospede.getNome());
                    this.telaMovimentoCheck.getjTextFieldNome().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjFormattedTextFieldFone1().setText(hospede.getFone1());
                    this.telaMovimentoCheck.getjFormattedTextFieldFone1().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjFormattedTextFieldFone2().setText(hospede.getFone2());
                    this.telaMovimentoCheck.getjFormattedTextFieldFone2().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldEmail1().setText(hospede.getEmail());
                    this.telaMovimentoCheck.getjTextFieldEmail1().setEnabled(false);
                    
                    if(this.telaMovimentoCheck.getjCheckBoxPresenca().isEnabled()){
                        this.telaMovimentoCheck.getjTextFieldNome().setText(hospede.getNome());
                        this.telaMovimentoCheck.getjTextFieldNome().setEnabled(false);

                        this.telaMovimentoCheck.getjFormattedTextFieldFone1().setText(hospede.getFone1());
                        this.telaMovimentoCheck.getjFormattedTextFieldFone1().setEnabled(false);

                        this.telaMovimentoCheck.getjFormattedTextFieldFone2().setText(hospede.getFone2());
                        this.telaMovimentoCheck.getjFormattedTextFieldFone2().setEnabled(false);

                        this.telaMovimentoCheck.getjTextFieldEmail1().setText(hospede.getEmail());
                        this.telaMovimentoCheck.getjTextFieldEmail1().setEnabled(false);
                        
                        this.telaMovimentoCheck.getjFormattedTextFieldCpfCnpj().setText(hospede.getCpf());
                        this.telaMovimentoCheck.getjFormattedTextFieldCpfCnpj().setEnabled(false);
                        
                        //this.telaMovimentoCheck.getjFormattedTextFieldDataNascimento().setText(hospede.getna());
                        //this.telaMovimentoCheck.getjFormattedTextFieldDataNascimento().setEnabled(false);
                    }
                }
            }
        } else if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDQuarto()) {
            if (this.telaMovimentoCheck.getjTextFieldIDQuarto().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                //System.out.println("Clique Duplo Detectado no MousePressed!-quarto");
                
                codigo = 0;
                
                BuscaQuarto telaBuscaHospede = new BuscaQuarto(null, true);
                ControllerBuscaQuarto2 controllerBuscaHospede = new ControllerBuscaQuarto2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                //JOptionPane.showMessageDialog(null, "clique duplo quarto");
                        
                if (codigo != 0) {
                    //utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), false);
                    //utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), true);

                    this.telaMovimentoCheck.getjTextFieldIDQuarto().setText(codigo + "");
                    //this.telaMovimentoCheck.getjTextFieldIDQuarto().setEnabled(false);

                    Quarto hospede = new Quarto();
                    hospede = service.QuartoService.Carregar(codigo);
                    
                    this.telaMovimentoCheck.getjTextFieldQuarto1Descricao().setText(hospede.getDescricao());
                    this.telaMovimentoCheck.getjTextFieldQuarto1Descricao().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldQuarto1Obs().setText(hospede.getObs());
                    this.telaMovimentoCheck.getjTextFieldQuarto1Obs().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldQuarto1Capacidade().setText(hospede.getCapacidadeHospedes() + "");
                    this.telaMovimentoCheck.getjTextFieldQuarto1Capacidade().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldQuarto1Andar().setText(hospede.getAndar()+"");
                    this.telaMovimentoCheck.getjTextFieldQuarto1Andar().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjCheckBoxAnimais().setSelected(hospede.isFlagAnimais());
                    this.telaMovimentoCheck.getjCheckBoxAnimais().setEnabled(false);
                    this.telaMovimentoCheck.getjCheckBoxBebes().setSelected(hospede.isFlagBebe());
                    this.telaMovimentoCheck.getjCheckBoxBebes().setEnabled(false);
                    this.telaMovimentoCheck.getjCheckBoxFumante().setSelected(hospede.isFlagFumante());
                    this.telaMovimentoCheck.getjCheckBoxFumante().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldQuarto1Valor().setText("R$ 130.00");
                    this.telaMovimentoCheck.getjTextFieldQuarto1Valor().setEnabled(false);
                    total += 130;
                    this.telaMovimentoCheck.getjTextFieldValorReserva().setText("R$ 130.00");
                    this.telaMovimentoCheck.getjTextFieldValorDespesas().setText(String.valueOf("R$ " + String.format("%.2f", total)));
                    
                }
            }
        }else if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDOs()) {
            if (this.telaMovimentoCheck.getjTextFieldIDOs().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                //System.out.println("Clique Duplo Detectado no MousePressed!-quarto");
                
                codigo = 0;
                
                BuscaServico telaBuscaHospede = new BuscaServico(null, true);
                ControllerBuscaServico2 controllerBuscaHospede = new ControllerBuscaServico2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                //JOptionPane.showMessageDialog(null, "clique duplo quarto");
                        
                if (codigo != 0) {
                    //utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), false);
                    //utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), true);

                    this.telaMovimentoCheck.getjTextFieldIDOs().setText(codigo + "");
                    //this.telaMovimentoCheck.getjTextFieldIDOs().setEnabled(false);

                    Servico hospede = new Servico();
                    hospede = service.ServicoService.Carregar(codigo);
                    
                    this.telaMovimentoCheck.getjTextFieldOSDescricao().setText(hospede.getDescricao());
                    this.telaMovimentoCheck.getjTextFieldOSDescricao().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldOSObs().setText(hospede.getObs());
                    this.telaMovimentoCheck.getjTextFieldOSObs().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldOSValor().setText("R$ 35,00");                    
                    total += 35;
                    this.telaMovimentoCheck.getjTextFieldValorServicos().setText("R$ 35,00");
                    this.telaMovimentoCheck.getjTextFieldValorDespesas().setText(String.valueOf("R$ " + String.format("%.2f", total)));
                }
            }
        }else if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDCopa()) {
            if (this.telaMovimentoCheck.getjTextFieldIDCopa().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                codigo = 0;

                BuscaProdutoCopa telaBuscaHospede = new BuscaProdutoCopa(null, true);
                ControllerBuscaProdutoCopa2 controllerBuscaHospede = new ControllerBuscaProdutoCopa2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);

                if (codigo != 0) {
                    this.telaMovimentoCheck.getjTextFieldIDCopa().setText(codigo + "");

                    ProdutoCopa hospede = new ProdutoCopa();
                    hospede = service.ProdutoCopaService.Carregar(codigo);

                    this.telaMovimentoCheck.getjTextFieldCopaDescricao().setText(hospede.getDescricao());
                    this.telaMovimentoCheck.getjTextFieldCopaDescricao().setEnabled(false);

                    //this.telaMovimentoCheck.getjTextFieldCopaValor().setText(hospede.getObs());
                    //this.telaMovimentoCheck.getjTextFieldCopaValor().setEnabled(false);

                    Date hoje = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String data = sdf.format(hoje);
                }
            }
        } else if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDVaga()) {
            if (this.telaMovimentoCheck.getjTextFieldIDVaga().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                //System.out.println("Clique Duplo Detectado no MousePressed!-vaga");
                
                codigo = 0;
                
                CadastroVagaEstacionamento telaBuscaHospede = new CadastroVagaEstacionamento(null, true);
                ControllerCadVagaEstacionamento2 controllerBuscaHospede = new ControllerCadVagaEstacionamento2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                
                if (codigo != 0) {
                    //this.telaMovimentoCheck.getjTextFieldIDVaga().setText(codigo + "");

                    VagaEstacionamento vaga = new VagaEstacionamento();
                    vaga = service.VagaEstacionamentoService.Carregar(codigo);
                    
                    this.telaMovimentoCheck.getjTextFieldIDVaga().setText(vaga.getDescricao().substring(0, 6));
                    this.telaMovimentoCheck.getjTextFieldIDVaga().setEnabled(false);

                    
                }
            }
        }else if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDVeiculo()) {
            if (this.telaMovimentoCheck.getjTextFieldIDVeiculo().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                //System.out.println("Clique Duplo Detectado no MousePressed!-quarto");
                
                codigo = 0;
                
                CadastroVeiculo telaBuscaHospede = new CadastroVeiculo(null, true);
                ControllerCadVeiculo2 controllerBuscaHospede = new ControllerCadVeiculo2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                //JOptionPane.showMessageDialog(null, "clique duplo quarto");
                        
                if (codigo != 0) {
                    //utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), false);
                    //utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), true);

                    this.telaMovimentoCheck.getjTextFieldIDOs().setText(codigo + "");
                    //this.telaMovimentoCheck.getjTextFieldIDOs().setEnabled(false);

                    Servico hospede = new Servico();
                    hospede = service.ServicoService.Carregar(codigo);
                    
                    this.telaMovimentoCheck.getjTextFieldOSDescricao().setText(hospede.getDescricao());
                    this.telaMovimentoCheck.getjTextFieldOSDescricao().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldOSObs().setText(hospede.getObs());
                    this.telaMovimentoCheck.getjTextFieldOSObs().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldOSValor().setText("R$ 35,00");                    
                    total += 35;
                    this.telaMovimentoCheck.getjTextFieldValorServicos().setText("R$ 35,00");
                    this.telaMovimentoCheck.getjTextFieldValorDespesas().setText(String.valueOf("R$ " + String.format("%.2f", total)));
                }
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

    @Override
    public void keyTyped(KeyEvent evt) {/*
        if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldCopaQuantidade() && 
            evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                // 1. Pega a quantidade digitada
                String textoQtd = this.telaMovimentoCheck.getjTextFieldCopaQuantidade().getText();
                float quantidade = Float.parseFloat(textoQtd);

                // 2. Garante que temos o produto correto (usando o código que foi selecionado no clique)
                ProdutoCopa produto = service.ProdutoCopaService.Carregar(codigo);

                if (produto != null) {
                    // 3. Calcula
                    float total = quantidade * produto.getValor();

                    // 4. Atualiza o campo (formatado)
                    this.telaMovimentoCheck.getjTextFieldCopaValor().setEnabled(true);
                    this.telaMovimentoCheck.getjTextFieldCopaValor().setText(String.format("%.2f", total));
                    this.telaMovimentoCheck.getjTextFieldCopaValor().setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um produto primeiro!");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Quantidade inválida! Digite apenas números.");
            }
        }
    */}

    /*@Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldCopaQuantidade()) {
            float total = Float.parseFloat(this.telaMovimentoCheck.getjTextFieldCopaQuantidade().getText()) * service.ProdutoCopaService.Carregar(codigo).getValor();
            JOptionPane.showConfirmDialog(null, "1 - " + total);
            
            if (this.telaMovimentoCheck.getjTextFieldCopaQuantidade().isEnabled() && evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
                total = Float.parseFloat(this.telaMovimentoCheck.getjTextFieldCopaQuantidade().getText()) * service.ProdutoCopaService.Carregar(codigo).getValor();
                JOptionPane.showConfirmDialog(null, "2 - " + total);
                this.telaMovimentoCheck.getjTextFieldCopaValor().setText("R$ " + total);
            }
        }
    }*/
    
    @Override
    public void keyPressed(KeyEvent evt) {
        // Verifica se o evento veio do campo de quantidade E se a tecla foi ENTER
        if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldCopaQuantidade() && 
            evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                // 1. Pega a quantidade digitada
                String textoQtd = this.telaMovimentoCheck.getjTextFieldCopaQuantidade().getText();
                float quantidade = Float.parseFloat(textoQtd);

                // 2. Garante que temos o produto correto (usando o código que foi selecionado no clique)
                ProdutoCopa produto = service.ProdutoCopaService.Carregar(codigo);

                if (produto != null) {
                    // 3. Calcula
                    float produtos = quantidade * produto.getValor();
                    JOptionPane.showMessageDialog(null, produto);
                    
                    total -= Float.parseFloat(this.telaMovimentoCheck.getjTextFieldCopaValor().getText());

                    // 4. Atualiza o campo (formatado)
                    this.telaMovimentoCheck.getjTextFieldCopaValor().setEnabled(true);
                    this.telaMovimentoCheck.getjTextFieldCopaValor().setText(String.format("%.2f", produtos));
                    this.telaMovimentoCheck.getjTextFieldCopaValor().setEnabled(false);
                    
                    total += Float.parseFloat(this.telaMovimentoCheck.getjTextFieldCopaValor().getText());
                    this.telaMovimentoCheck.getjTextFieldValorProduto().setText(String.format("%.2f", produtos));
                    //this.telaMovimentoCheck.getjTextFieldValorProduto().setText(String.format("%.2f", Float.parseFloat(this.telaMovimentoCheck.getjTextFieldCopaValor().getText())));
                    this.telaMovimentoCheck.getjTextFieldValorDespesas().setText(String.valueOf("R$ " + String.format("%.2f", total)));
                } else {
                    JOptionPane.showMessageDialog(null, "Selecione um produto primeiro!");
                }

            } catch (NumberFormatException e) {//estoura execption
                JOptionPane.showMessageDialog(null, "Quantidade inválida! Digite apenas números.");
            }
        } else if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldOSValor()&& 
            evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                /*/ 1. Pega a quantidade digitada
                String textoQtd = this.telaMovimentoCheck.getjTextFieldCopaQuantidade().getText();
                float quantidade = Float.parseFloat(textoQtd);

                // 2. Garante que temos o produto correto (usando o código que foi selecionado no clique)
                ProdutoCopa produto = service.ProdutoCopaService.Carregar(codigo);

                if (produto != null) {*/
                    //JOptionPane.showMessageDialog(null, produto);
                    total -= 35;
                    total += Float.parseFloat(this.telaMovimentoCheck.getjTextFieldOSValor().getText());
                    this.telaMovimentoCheck.getjTextFieldValorServicos().setText(String.format("%.2f", Float.parseFloat(this.telaMovimentoCheck.getjTextFieldOSValor().getText())));
                    this.telaMovimentoCheck.getjTextFieldValorDespesas().setText(String.valueOf("R$ " + String.format("%.2f", total)));
                    
                /*} else {
                    JOptionPane.showMessageDialog(null, "Selecione um produto primeiro!");
                }*/

            } catch (NumberFormatException e) {//estoura execption
                JOptionPane.showMessageDialog(null, "Valor inválido!");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
