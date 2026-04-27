package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
import model.Reserva;
import model.ReservaQuarto;
import model.Servico;
import model.VagaEstacionamento;
import model.Veiculo;
import org.w3c.dom.events.MouseEvent;
import view.BuscaHospede;
import view.BuscaProdutoCopa;
import view.BuscaQuarto;
import view.BuscaServico;
import view.CadastroServico;
import view.CadastroVagaEstacionamento;
import view.CadastroVeiculo;
import view.MovimentoCheck;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        this.telaMovimentoCheck.getjTextFieldIDVeiculo().addMouseListener(this);
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

        } else if (e.getSource() == this.telaMovimentoCheck.getjButtonGravar()) {
            if(!this.telaMovimentoCheck.getjTextFieldIDHospede().getText().trim().equalsIgnoreCase("") &&
                    !this.telaMovimentoCheck.getjTextFieldIDQuarto().getText().trim().equalsIgnoreCase(""))
            try {
                salvarPorEtapa();
               
            } catch (ParseException ex) {
                Logger.getLogger(ControllerMovimentoCheck.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (e.getSource() == this.telaMovimentoCheck.getjButtonCancelar()) {
            utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), true);
            utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelDados(), true);
            utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), false);
        } else if (e.getSource() == this.telaMovimentoCheck.getjButtonSair()) {
            this.telaMovimentoCheck.dispose();
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddCopaProduto()) {
            this.telaMovimentoCheck.getjTextFieldCopaValor().setText("");
            this.telaMovimentoCheck.getjTextFieldCopaDescricao().setText("");
            this.telaMovimentoCheck.getjTextFieldCopaQuantidade().setText("");
            this.telaMovimentoCheck.getjTextFieldIDCopa().setText("");
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddQuarto()) {
            this.telaMovimentoCheck.getjTextFieldQuarto1Valor().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldQuarto1Valor().setText("");
            this.telaMovimentoCheck.getjTextFieldQuarto1Capacidade().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldQuarto1Capacidade().setText("");
            this.telaMovimentoCheck.getjTextFieldQuarto1Descricao().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldQuarto1Descricao().setText("");
            this.telaMovimentoCheck.getjTextFieldQuarto1Obs().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldQuarto1Obs().setText("");
            this.telaMovimentoCheck.getjTextFieldQuarto1Andar().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldQuarto1Andar().setText("");
            this.telaMovimentoCheck.getjTextFieldIDQuarto().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldIDQuarto().setText("");
            
            this.telaMovimentoCheck.getjCheckBoxAnimais().setEnabled(true);
            this.telaMovimentoCheck.getjCheckBoxAnimais().setText("");
            this.telaMovimentoCheck.getjCheckBoxFumante().setEnabled(true);
            this.telaMovimentoCheck.getjCheckBoxFumante().setText("");
            this.telaMovimentoCheck.getjCheckBoxBebes().setEnabled(true);
            this.telaMovimentoCheck.getjCheckBoxBebes().setText("");
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddHospede()) {
            this.telaMovimentoCheck.getjTextFieldQuarto1Obs().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldQuarto1Obs().setText("");
            this.telaMovimentoCheck.getjTextFieldIDQuarto().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldIDQuarto().setText("");
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddOS()) {
            this.telaMovimentoCheck.getjTextFieldOSDescricao().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldOSDescricao().setText("");
            this.telaMovimentoCheck.getjTextFieldOSObs().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldOSObs().setText("");
            this.telaMovimentoCheck.getjTextFieldOSValor().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldOSValor().setText("");
            this.telaMovimentoCheck.getjTextFieldIDOs().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldIDOs().setText("");
        }else if (e.getSource() == this.telaMovimentoCheck.getjButtonAddVaga()) {
            this.telaMovimentoCheck.getjTextFieldVeiculoCor().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldVeiculoCor().setText("");
            this.telaMovimentoCheck.getjTextFieldVeiculoPlaca().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldVeiculoPlaca().setText("");
            this.telaMovimentoCheck.getjTextFieldVeiculoObs().setEnabled(true);
            this.telaMovimentoCheck.getjTextFieldVeiculoObs().setText("");
            this.telaMovimentoCheck.getjComboBoxVeiculoModelo().setEnabled(true);
            this.telaMovimentoCheck.getjComboBoxVeiculoModelo().setText("");
            this.telaMovimentoCheck.getjComboBoxVeiculoMarca().setEnabled(true);
            this.telaMovimentoCheck.getjComboBoxVeiculoMarca().setText("");
        }
    }
    
    @Override
    public void mouseClicked(java.awt.event.MouseEvent evt) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent evt) {
        if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDHospede()) {
            if (this.telaMovimentoCheck.getjTextFieldIDHospede().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                
                codigo = 0;
                
                BuscaHospede telaBuscaHospede = new BuscaHospede(null, true);
                ControllerBuscaHospede2 controllerBuscaHospede = new ControllerBuscaHospede2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                
                
                if (codigo != 0) {
                    this.telaMovimentoCheck.getjTextFieldIDHospede().setText(codigo + "");

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
                
                codigo = 0;
                
                BuscaQuarto telaBuscaHospede = new BuscaQuarto(null, true);
                ControllerBuscaQuarto2 controllerBuscaHospede = new ControllerBuscaQuarto2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                        
                if (codigo != 0) {

                    this.telaMovimentoCheck.getjTextFieldIDQuarto().setText(codigo + "");

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
                
                codigo = 0;
                
                BuscaServico telaBuscaHospede = new BuscaServico(null, true);
                ControllerBuscaServico2 controllerBuscaHospede = new ControllerBuscaServico2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                //JOptionPane.showMessageDialog(null, "clique duplo quarto");
                        
                if (codigo != 0) {

                    this.telaMovimentoCheck.getjTextFieldIDOs().setText(codigo + "");

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

                    Date hoje = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                    String data = sdf.format(hoje);
                }
            }
        } else if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDVaga()) {
            if (this.telaMovimentoCheck.getjTextFieldIDVaga().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                
                codigo = 0;
                
                CadastroVagaEstacionamento telaBuscaHospede = new CadastroVagaEstacionamento(null, true);
                ControllerCadVagaEstacionamento2 controllerBuscaHospede = new ControllerCadVagaEstacionamento2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                
                if (codigo != 0) {

                    VagaEstacionamento vaga = new VagaEstacionamento();
                    vaga = service.VagaEstacionamentoService.Carregar(codigo);
                    
                    this.telaMovimentoCheck.getjTextFieldIDVaga().setText(vaga.getDescricao().substring(0, 6));
                    this.telaMovimentoCheck.getjTextFieldIDVaga().setEnabled(false);
                }
            }
        }else if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldIDVeiculo()) {
            if (this.telaMovimentoCheck.getjTextFieldIDVeiculo().isEnabled() && evt.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(evt)) {
                
                codigo = 0;
                
                CadastroVeiculo telaBuscaHospede = new CadastroVeiculo(null, true);
                ControllerCadVeiculo2 controllerBuscaHospede = new ControllerCadVeiculo2(telaBuscaHospede);
                telaBuscaHospede.setVisible(true);
                        
                if (codigo != 0) {
                    this.telaMovimentoCheck.getjTextFieldIDVeiculo().setText(codigo + "");
 
                    Veiculo veiculo = new Veiculo();
                    veiculo = service.VeiculoService.Carregar(codigo);
                    
                    this.telaMovimentoCheck.getjTextFieldVeiculoPlaca().setText(veiculo.getPlaca());
                    this.telaMovimentoCheck.getjTextFieldVeiculoPlaca().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldVeiculoCor().setText(veiculo.getCor());
                    this.telaMovimentoCheck.getjTextFieldVeiculoCor().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjComboBoxVeiculoMarca().setText(veiculo.getModelo().getMarca().toString());
                    this.telaMovimentoCheck.getjComboBoxVeiculoMarca().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjComboBoxVeiculoModelo().setText(veiculo.getModelo().toString());
                    this.telaMovimentoCheck.getjComboBoxVeiculoModelo().setEnabled(false);
                    
                    this.telaMovimentoCheck.getjTextFieldVeiculoObs().setText("obs_veiculo => fora do BD");
                    this.telaMovimentoCheck.getjTextFieldVeiculoObs().setEnabled(false);
                    
                    int index_status;
                    if(veiculo.getStatus()== 'A' || veiculo.getStatus()== 'a'){
                        index_status = 0;
                    }else if(veiculo.getStatus()== 'E' || veiculo.getStatus()== 'e'){
                        index_status = 1;
                    }else{
                        index_status = 2;
                    }
                    this.telaMovimentoCheck.getjComboBoxVeiculoStatus().setSelectedIndex(index_status);
                }
            }
        }
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {}

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {}

    @Override
    public void keyTyped(KeyEvent evt) {}

    @Override
    public void keyPressed(KeyEvent evt) {
        if (evt.getSource() == this.telaMovimentoCheck.getjTextFieldCopaQuantidade() && 
            evt.getKeyCode() == KeyEvent.VK_ENTER) {

            try {
                String textoQtd = this.telaMovimentoCheck.getjTextFieldCopaQuantidade().getText();
                float quantidade = Float.parseFloat(textoQtd);

                ProdutoCopa produto = service.ProdutoCopaService.Carregar(codigo);

                if (produto != null) {
                    float produtos = quantidade * produto.getValor();
                    JOptionPane.showMessageDialog(null, produto);
                    
                    total -= Float.parseFloat(this.telaMovimentoCheck.getjTextFieldCopaValor().getText());

                    this.telaMovimentoCheck.getjTextFieldCopaValor().setEnabled(true);
                    this.telaMovimentoCheck.getjTextFieldCopaValor().setText(String.format("%.2f", produtos));
                    this.telaMovimentoCheck.getjTextFieldCopaValor().setEnabled(false);
                    
                    total += Float.parseFloat(this.telaMovimentoCheck.getjTextFieldCopaValor().getText());
                    this.telaMovimentoCheck.getjTextFieldValorProduto().setText(String.format("%.2f", produtos));
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
                total -= 35;
                total += Float.parseFloat(this.telaMovimentoCheck.getjTextFieldOSValor().getText());
                this.telaMovimentoCheck.getjTextFieldValorServicos().setText(String.format("%.2f", Float.parseFloat(this.telaMovimentoCheck.getjTextFieldOSValor().getText())));
                this.telaMovimentoCheck.getjTextFieldValorDespesas().setText(String.valueOf("R$ " + String.format("%.2f", total)));
            } catch (NumberFormatException e) {//estoura execption
                JOptionPane.showMessageDialog(null, "Valor inválido!");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    private void salvarPorEtapa() throws ParseException {        
            //VALIDAÇÕES DE ETAPA:
            if(!this.telaMovimentoCheck.getjFormattedTextFieldPrevisaoEntrada().getText().contains("  /  /    ")&&
                    !this.telaMovimentoCheck.getjFormattedTextFieldPrevisaoSaida().getText().contains("  /  /    ")){

                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

                    Date dataEntrada = sdf.parse(this.telaMovimentoCheck.getjFormattedTextFieldPrevisaoEntrada().getText());
                    Date dataSaida = sdf.parse(this.telaMovimentoCheck.getjFormattedTextFieldPrevisaoSaida().getText());


                } catch (Exception e) {
                    e.printStackTrace(); 
                }
                
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                Reserva reserva = new Reserva();
                ReservaQuarto reservaQuarto = new ReservaQuarto();
                
                char status;
                if(this.telaMovimentoCheck.getjComboBoxStatusReserva().getSelectedIndex() == 0){
                    status = 'A';
                }else{
                    status = 'I';
                }

                reservaQuarto.setDataHoraInicio(sdf.parse(this.telaMovimentoCheck.getjFormattedTextFieldPrevisaoEntrada().getText()));
                reservaQuarto.setDataHoraFim(sdf.parse(this.telaMovimentoCheck.getjFormattedTextFieldPrevisaoSaida().getText()));
                reservaQuarto.setStatus(status);
                reservaQuarto.setObs(this.telaMovimentoCheck.getjTextFieldObsReserva().getText());
                
                reserva.setDataPrevistaEntrada(reservaQuarto.getDataHoraInicio());
                reserva.setDataPrevistaSaida(reservaQuarto.getDataHoraFim());
                reserva.setObs(this.telaMovimentoCheck.getjTextFieldObsReserva().getText());
                Date hoje = new Date();
                reserva.setDataHoraReserva(hoje);
                
                reservaQuarto.setQuarto(service.QuartoService.Carregar(Integer.parseInt(this.telaMovimentoCheck.getjTextFieldIDQuarto().getText())));

                if(this.telaMovimentoCheck.getjTextFieldIDReserva().getText().equals("")){
                    service.ReservaService.Criar(reserva);
                }else{
                    reserva.setId(Integer.parseInt(this.telaMovimentoCheck.getjTextFieldIDReserva().getText()));
                }
                    
                reservaQuarto.setReserva(reserva);
                service.ReservaQuartoService.Criar(reservaQuarto);
                
                JOptionPane.showMessageDialog(null, "ReservaQuarto: " + reservaQuarto);
                
                if(this.telaMovimentoCheck.getjTextFieldIDReserva().getText().trim().equalsIgnoreCase("")){
//                    Date hoje = new Date();
                    //SimpleDateFormat sdfDataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                    String data = sdf.format(hoje);
                    this.telaMovimentoCheck.getjFormattedTextFieldDataCheckIn().setText(data);
                    JOptionPane.showMessageDialog(null, "Salva Reserva");
                }else{
                    JOptionPane.showMessageDialog(null, "Atualiza Reserva");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Faltou Atributos obrigatórios!!!");
            }

            utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelBotoes(), true);
            utilities.Utilities.ativaDesativaBotoes(this.telaMovimentoCheck.getjPanelDados(), true);
            utilities.Utilities.limpaComponentes(this.telaMovimentoCheck.getjPanelDados(), false);
    }
}
