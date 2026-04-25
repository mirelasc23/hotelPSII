/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author aluno
 */
public class MovimentoCheck extends javax.swing.JDialog {

    /**
     * Creates new form MovimentoCheck
     */
    public MovimentoCheck(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        // Remove as bordas e barra de título (opcional, para visual limpo)
        //this.setUndecorated(true);;

        // Maximiza o JDialog
        java.awt.GraphicsEnvironment env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
        this.setBounds(env.getMaximumWindowBounds());
        //setMaximizedBounds(env.getMaximumWindowBounds());
        this.setSize(env.getMaximumWindowBounds().width, env.getMaximumWindowBounds().height);
        //this.setExtendedState(this.getExtendedState() | javax.swing.JFrame.MAXIMIZED_BOTH); // Funciona no Dialog também
        setTitle("Check");
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagens/OK.png")));

    }
    
    public JButton getjButtonSair() {
        return jButtonSair;
    }

    public JButton getjButtonBuscar() {
        return jButtonBuscar;
    }

    public JButton getjButtonCancelar() {
        return jButtonCancelar;
    }

    public JButton getjButtonGravar() {
        return jButtonGravar;
    }

    public JButton getjButtonNovo() {
        return jButtonNovo;
    }

    public JPanel getjPanelBotoes() {
        return jPanelBotoes;
    }

    public JPanel getjPanelDados() {
        return jPanelDados;
    }

    public JCheckBox getjCheckBoxAnimais() {
        return jCheckBoxAnimais;
    }

    public void setjCheckBoxAnimais(JCheckBox jCheckBoxAnimais) {
        this.jCheckBoxAnimais = jCheckBoxAnimais;
    }

    public JCheckBox getjCheckBoxBebes() {
        return jCheckBoxBebes;
    }

    public void setjCheckBoxBebes(JCheckBox jCheckBoxBebes) {
        this.jCheckBoxBebes = jCheckBoxBebes;
    }

    public JCheckBox getjCheckBoxFumante() {
        return jCheckBoxFumante;
    }

    public void setjCheckBoxFumante(JCheckBox jCheckBoxFumante) {
        this.jCheckBoxFumante = jCheckBoxFumante;
    }

    public JComboBox<String> getjComboBoxVeiculoStatus() {
        return jComboBoxVeiculoStatus;
    }

    public void setjComboBoxVeiculoStatus(JComboBox<String> jComboBoxSexoStatus1) {
        this.jComboBoxVeiculoStatus = jComboBoxSexoStatus1;
    }

    public JComboBox<String> getjComboBoxVeiculoMarca() {
        return jComboBoxVeiculoMarca;
    }

    public void setjComboBoxVeiculoMarca(JComboBox<String> jComboBoxSexoStatus2) {
        this.jComboBoxVeiculoMarca = jComboBoxSexoStatus2;
    }

    public JComboBox<String> getjComboBoxVeiculoModelo() {
        return jComboBoxVeiculoModelo;
    }

    public void setjComboBoxVeiculoModelo(JComboBox<String> jComboBoxSexoStatus3) {
        this.jComboBoxVeiculoModelo = jComboBoxSexoStatus3;
    }

    public JComboBox<String> getjComboBoxSexoStatus6() {
        return jComboBoxSexoStatus6;
    }

    public void setjComboBoxSexoStatus6(JComboBox<String> jComboBoxSexoStatus6) {
        this.jComboBoxSexoStatus6 = jComboBoxSexoStatus6;
    }

    public JComboBox<String> getjComboBoxStatusReserva() {
        return jComboBoxStatusReserva;
    }

    public void setjComboBoxStatusReserva(JComboBox<String> jComboBoxStatusReserva) {
        this.jComboBoxStatusReserva = jComboBoxStatusReserva;
    }

    public JFormattedTextField getjFormattedTextFieldCnpj3() {
        return jFormattedTextFieldHospede1Cpf;
    }

    public void setjFormattedTextFieldCnpj3(JFormattedTextField jFormattedTextFieldCnpj3) {
        this.jFormattedTextFieldHospede1Cpf = jFormattedTextFieldCnpj3;
    }

    public JFormattedTextField getjFormattedTextFieldCpfCnpj() {
        return jFormattedTextFieldCpfCnpj;
    }

    public void setjFormattedTextFieldCpfCnpj(JFormattedTextField jFormattedTextFieldCpfCnpj) {
        this.jFormattedTextFieldCpfCnpj = jFormattedTextFieldCpfCnpj;
    }

    public JFormattedTextField getjFormattedTextFieldDataCadastro() {
        return jFormattedTextFieldDataCadastro;
    }

    public void setjFormattedTextFieldDataCadastro(JFormattedTextField jFormattedTextFieldDataCadastro) {
        this.jFormattedTextFieldDataCadastro = jFormattedTextFieldDataCadastro;
    }

    public JFormattedTextField getjFormattedTextFieldDataCadastro10() {
        return jFormattedTextFieldDataCadastro10;
    }

    public void setjFormattedTextFieldDataCadastro10(JFormattedTextField jFormattedTextFieldDataCadastro10) {
        this.jFormattedTextFieldDataCadastro10 = jFormattedTextFieldDataCadastro10;
    }

    public JFormattedTextField getjFormattedTextFieldDataCadastro11() {
        return jFormattedTextFieldCopaData;
    }

    public void setjFormattedTextFieldDataCadastro11(JFormattedTextField jFormattedTextFieldDataCadastro11) {
        this.jFormattedTextFieldCopaData = jFormattedTextFieldDataCadastro11;
    }

    public JFormattedTextField getjFormattedTextFieldDataCadastro12() {
        return jFormattedTextFieldHospede1DataNascimento;
    }

    public void setjFormattedTextFieldDataCadastro12(JFormattedTextField jFormattedTextFieldDataCadastro12) {
        this.jFormattedTextFieldHospede1DataNascimento = jFormattedTextFieldDataCadastro12;
    }

    public JFormattedTextField getjFormattedTextFieldDataCadastro6() {
        return jFormattedTextFieldDataCadastro6;
    }

    public void setjFormattedTextFieldDataCadastro6(JFormattedTextField jFormattedTextFieldDataCadastro6) {
        this.jFormattedTextFieldDataCadastro6 = jFormattedTextFieldDataCadastro6;
    }

    public JFormattedTextField getjFormattedTextFieldDataCheckIn() {
        return jFormattedTextFieldDataCheckIn;
    }

    public void setjFormattedTextFieldDataCheckIn(JFormattedTextField jFormattedTextFieldDataCheckIn) {
        this.jFormattedTextFieldDataCheckIn = jFormattedTextFieldDataCheckIn;
    }

    public JFormattedTextField getjFormattedTextFieldDataCheckOut() {
        return jFormattedTextFieldDataCheckOut;
    }

    public void setjFormattedTextFieldDataCheckOut(JFormattedTextField jFormattedTextFieldDataCheckOut) {
        this.jFormattedTextFieldDataCheckOut = jFormattedTextFieldDataCheckOut;
    }

    public JFormattedTextField getjFormattedTextFieldDataNascimento() {
        return jFormattedTextFieldDataNascimento;
    }

    public void setjFormattedTextFieldDataNascimento(JFormattedTextField jFormattedTextFieldDataNascimento) {
        this.jFormattedTextFieldDataNascimento = jFormattedTextFieldDataNascimento;
    }

    public JFormattedTextField getjFormattedTextFieldFone1() {
        return jFormattedTextFieldFone1;
    }

    public void setjFormattedTextFieldFone1(JFormattedTextField jFormattedTextFieldFone1) {
        this.jFormattedTextFieldFone1 = jFormattedTextFieldFone1;
    }

    public JFormattedTextField getjFormattedTextFieldFone2() {
        return jFormattedTextFieldFone2;
    }

    public void setjFormattedTextFieldFone2(JFormattedTextField jFormattedTextFieldFone2) {
        this.jFormattedTextFieldFone2 = jFormattedTextFieldFone2;
    }

    public JFormattedTextField getjFormattedTextFieldFone1Hospede2() {
        return jFormattedTextFieldFone1Hospede2;
    }

    public void setjFormattedTextFieldFone1Hospede2(JFormattedTextField jFormattedTextFieldFone3) {
        this.jFormattedTextFieldFone1Hospede2 = jFormattedTextFieldFone3;
    }

    public JFormattedTextField getjFormattedTextFieldFone2Hospede2() {
        return jFormattedTextFieldFone2Hospede2;
    }

    public void setjFormattedTextFieldFone2Hospede2(JFormattedTextField jFormattedTextFieldFone4) {
        this.jFormattedTextFieldFone2Hospede2 = jFormattedTextFieldFone4;
    }

    public JFormattedTextField getjFormattedTextFieldFone2Hospede1() {
        return jFormattedTextFieldFone2Hospede1;
    }

    public void setjFormattedTextFieldFone2Hospede1(JFormattedTextField jFormattedTextFieldFone5) {
        this.jFormattedTextFieldFone2Hospede1 = jFormattedTextFieldFone5;
    }

    public JFormattedTextField getjFormattedTextFieldFone6() {
        return jFormattedTextFieldFone1Hospede1;
    }

    public void setjFormattedTextFieldFone6(JFormattedTextField jFormattedTextFieldFone6) {
        this.jFormattedTextFieldFone1Hospede1 = jFormattedTextFieldFone6;
    }

    public JTextField getjTextFieldValorReserva() {
        return jTextFieldValorReserva;
    }

    public void setjTextFieldValorReserva(JTextField jTextField1) {
        this.jTextFieldValorReserva = jTextField1;
    }

    public JTextField getjTextFieldValorServicos() {
        return jTextFieldValorServiços;
    }

    public void setjTextFieldValorServicos(JTextField jTextField2) {
        this.jTextFieldValorServiços = jTextField2;
    }

    public JTextField getjTextFieldValorProduto() {
        return jTextFieldValorProduto;
    }

    public void setjTextFieldValorProduto(JTextField jTextField3) {
        this.jTextFieldValorProduto = jTextField3;
    }

    public JTextField getjTextField4() {
        return jTextField4;
    }

    public void setjTextField4(JTextField jTextField4) {
        this.jTextField4 = jTextField4;
    }

    public JTextField getjTextField5() {
        return jTextField5;
    }

    public void setjTextField5(JTextField jTextField5) {
        this.jTextField5 = jTextField5;
    }

    public JTextField getjTextField6() {
        return jTextField6;
    }

    public void setjTextField6(JTextField jTextField6) {
        this.jTextField6 = jTextField6;
    }

    public JTextField getjTextFieldValorDespesas() {
        return jTextFieldValorDespesas;
    }

    public void setjTextFieldValorDespesas(JTextField jTextField7) {
        this.jTextFieldValorDespesas = jTextField7;
    }

    public JTextField getjTextField8() {
        return jTextField8;
    }

    public void setjTextField8(JTextField jTextField8) {
        this.jTextField8 = jTextField8;
    }

    public JTextField getjTextField9() {
        return jTextField9;
    }

    public void setjTextField9(JTextField jTextField9) {
        this.jTextField9 = jTextField9;
    }

    public JTextField getjTextFieldEmail1() {
        return jTextFieldEmail1;
    }

    public void setjTextFieldEmail1(JTextField jTextFieldEmail1) {
        this.jTextFieldEmail1 = jTextFieldEmail1;
    }

    public JTextField getjTextFieldEmailHospede2() {
        return jTextFieldEmailHospede2;
    }

    public void setjTextFieldEmailHospede2(JTextField jTextFieldEmail2) {
        this.jTextFieldEmailHospede2 = jTextFieldEmail2;
    }

    public JTextField getjTextFieldEmailHospede1() {
        return jTextFieldEmailHospede1;
    }

    public void setjTextFieldEmail3(JTextField jTextFieldEmail3) {
        this.jTextFieldEmailHospede1 = jTextFieldEmail3;
    }

    public JTextField getjTextFieldIDHospede() {
        return jTextFieldIDHospede;
    }

    public void setjTextFieldIDHospede(JTextField jTextFieldIDHospede) {
        this.jTextFieldIDHospede = jTextFieldIDHospede;
    }

    public JTextField getjTextFieldQuarto1Andar() {
        return jTextFieldQuarto1Andar;
    }

    public void setjTextFieldQuarto1Andar(JTextField jTextFieldIDHospede1) {
        this.jTextFieldQuarto1Andar = jTextFieldIDHospede1;
    }

    public JTextField getjTextFieldVeiculoPlaca() {
        return jTextFieldVeiculoPlaca;
    }

    public void setjTextFieldVeiculoPlaca(JTextField jTextFieldIDHospede2) {
        this.jTextFieldVeiculoPlaca = jTextFieldIDHospede2;
    }

    public JTextField getjTextFieldIDQuartos() {
        return jTextFieldIDQuartos;
    }

    public void setjTextFieldIDQuartos(JTextField jTextFieldIDQuartos) {
        this.jTextFieldIDQuartos = jTextFieldIDQuartos;
    }

    public JTextField getjTextFieldQuarto1Capacidade() {
        return jTextFieldQuarto1Capacidade;
    }

    public void setjTextFieldQuarto1Capacidade(JTextField jTextFieldIDQuartos1) {
        this.jTextFieldQuarto1Capacidade = jTextFieldIDQuartos1;
    }

    public JTextField getjTextFieldVeiculoCor() {
        return jTextFieldVeiculoCor;
    }

    public void setjTextFieldVeiculoCor(JTextField jTextFieldIDQuartos2) {
        this.jTextFieldVeiculoCor = jTextFieldIDQuartos2;
    }

    public JTextField getjTextFieldIDReserva() {
        return jTextFieldIDReserva;
    }

    public void setjTextFieldIDReserva(JTextField jTextFieldIDReserva) {
        this.jTextFieldIDReserva = jTextFieldIDReserva;
    }

    public JTextField getjTextFieldIDQuarto() {
        return jTextFieldIDQuarto;
    }

    public void setjTextFieldIDQuarto(JTextField jTextFieldIDReserva1) {
        this.jTextFieldIDQuarto = jTextFieldIDReserva1;
    }

    public JTextField getjTextFieldIDVaga() {
        return jTextFieldIDVaga;
    }

    public void setjTextFieldIDVaga(JTextField jTextFieldIDReserva2) {
        this.jTextFieldIDVaga = jTextFieldIDReserva2;
    }

    public JTextField getjTextFieldIDOs() {
        return jTextFieldIDOs;
    }

    public void setjTextFieldIDOs(JTextField jTextFieldIDReserva3) {
        this.jTextFieldIDOs = jTextFieldIDReserva3;
    }

    public JTextField getjTextFieldIDCopa() {
        return jTextFieldIDCopa;
    }

    public void setjTextFieldIDCopa(JTextField jTextFieldIDReserva4) {
        this.jTextFieldIDCopa = jTextFieldIDReserva4;
    }

    public JTextField getjTextFieldIDVagas() {
        return jTextFieldIDVagas;
    }

    public void setjTextFieldIDVagas(JTextField jTextFieldIDVaga) {
        this.jTextFieldIDVagas = jTextFieldIDVaga;
    }

    public JTextField getjTextFieldQuarto1Valor() {
        return jTextFieldQuarto1Valor;
    }

    public void setjTextFieldQuarto1Valor(JTextField jTextFieldIDVaga1) {
        this.jTextFieldQuarto1Valor = jTextFieldIDVaga1;
    }

    public JTextField getjTextFieldNome() {
        return jTextFieldNome;
    }

    public void setjTextFieldNome(JTextField jTextFieldNome) {
        this.jTextFieldNome = jTextFieldNome;
    }

    public JTextField getjTextFieldNomeHospede2() {
        return jTextFieldNomeHospede2;
    }

    public void setjTextFieldNomeHospede2(JTextField jTextFieldNomeFantasia1) {
        this.jTextFieldNomeHospede2 = jTextFieldNomeFantasia1;
    }

    public JTextField getjTextFieldNomeHospede1() {
        return jTextFieldNomeHospede1;
    }

    public void setjTextFieldNomeFantasia2(JTextField jTextFieldNomeFantasia2) {
        this.jTextFieldNomeHospede1 = jTextFieldNomeFantasia2;
    }

    public JTextField getjTextFieldQuarto1Obs() {
        return jTextFieldQuarto1Obs;
    }

    public void setjTextFieldQuarto1Obs(JTextField jTextFieldObs2) {
        this.jTextFieldQuarto1Obs = jTextFieldObs2;
    }

    public JTextField getjTextFieldQuarto1Descricao() {
        return jTextFieldQuarto1Descricao;
    }

    public void setjTextFieldQuarto1Descricao(JTextField jTextFieldObs3) {
        this.jTextFieldQuarto1Descricao = jTextFieldObs3;
    }

    public JTextField getjTextFieldVeiculoObs() {
        return jTextFieldVeiculoObs;
    }

    public void setjTextFieldVeiculoObs(JTextField jTextFieldObs4) {
        this.jTextFieldVeiculoObs = jTextFieldObs4;
    }

    public JTextField getjTextFieldOSDescricao() {
        return jTextFieldOSDescricao;
    }

    public void setjTextFieldOSDescricao(JTextField jTextFieldObs5) {
        this.jTextFieldOSDescricao = jTextFieldObs5;
    }

    public JTextField getjTextFieldOSObs() {
        return jTextFieldOSObs;
    }

    public void setjTextFieldOSObs(JTextField jTextFieldObs6) {
        this.jTextFieldOSObs = jTextFieldObs6;
    }

    public JTextField getjTextFieldOSValor() {
        return jTextFieldOSValor;
    }

    public void setjTextFieldOSValor(JTextField jTextFieldObs7) {
        this.jTextFieldOSValor = jTextFieldObs7;
    }

    public JTextField getjTextFieldCopaValor() {
        return jTextFieldCopaValor;
    }

    public void setjTextFieldCopaValor(JTextField jTextFieldObs8) {
        this.jTextFieldCopaValor = jTextFieldObs8;
    }

    public JTextField getjTextFieldCopaQuantidade() {
        return jTextFieldCopaQuantidade;
    }

    public void setjTextFieldCopaQuantidade(JTextField jTextFieldObs9) {
        this.jTextFieldCopaQuantidade = jTextFieldObs9;
    }

    public JFormattedTextField getjFormattedTextFieldCopaData() {
        return jFormattedTextFieldCopaData;
    }

    public void setjFormattedTextFieldCopaData(JFormattedTextField jFormattedTextFieldCopaData) {
        this.jFormattedTextFieldCopaData = jFormattedTextFieldCopaData;
    }

    public JFormattedTextField getjFormattedTextFieldFone1Hospede1() {
        return jFormattedTextFieldFone1Hospede1;
    }

    public void setjFormattedTextFieldFone1Hospede1(JFormattedTextField jFormattedTextFieldFone1Hospede1) {
        this.jFormattedTextFieldFone1Hospede1 = jFormattedTextFieldFone1Hospede1;
    }

    public JFormattedTextField getjFormattedTextFieldHospede1Cpf() {
        return jFormattedTextFieldHospede1Cpf;
    }

    public void setjFormattedTextFieldHospede1Cpf(JFormattedTextField jFormattedTextFieldHospede1Cpf) {
        this.jFormattedTextFieldHospede1Cpf = jFormattedTextFieldHospede1Cpf;
    }

    public JFormattedTextField getjFormattedTextFieldHospede1DataNascimento() {
        return jFormattedTextFieldHospede1DataNascimento;
    }

    public void setjFormattedTextFieldHospede1DataNascimento(JFormattedTextField jFormattedTextFieldHospede1DataNascimento) {
        this.jFormattedTextFieldHospede1DataNascimento = jFormattedTextFieldHospede1DataNascimento;
    }

    public JFormattedTextField getjFormattedTextFieldHospede2Cpf() {
        return jFormattedTextFieldHospede2Cpf;
    }

    public void setjFormattedTextFieldHospede2Cpf(JFormattedTextField jFormattedTextFieldHospede2Cpf) {
        this.jFormattedTextFieldHospede2Cpf = jFormattedTextFieldHospede2Cpf;
    }

    public JTextField getjTextFieldCopaDescricao() {
        return jTextFieldCopaDescricao;
    }

    public void setjTextFieldCopaDescricao(JTextField jTextFieldCopaDescricao) {
        this.jTextFieldCopaDescricao = jTextFieldCopaDescricao;
    }

    public JTextField getjTextFieldObsReserva() {
        return jTextFieldObsReserva;
    }

    public void setjTextFieldObsReserva(JTextField jTextFieldObsReserva) {
        this.jTextFieldObsReserva = jTextFieldObsReserva;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelConteudo = new javax.swing.JPanel();
        jPanelTitulo = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelDados = new javax.swing.JPanel();
        jTextFieldNome = new javax.swing.JTextField();
        jTextFieldIDReserva = new javax.swing.JTextField();
        jLabelIdReserva = new javax.swing.JLabel();
        jLabelNome = new javax.swing.JLabel();
        jLabelFone1 = new javax.swing.JLabel();
        jLabelFone2 = new javax.swing.JLabel();
        jFormattedTextFieldFone2 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldFone1 = new javax.swing.JFormattedTextField();
        jComboBoxStatusReserva = new javax.swing.JComboBox<>();
        jLabelStatusReserva = new javax.swing.JLabel();
        jLabelIdHospede = new javax.swing.JLabel();
        jCheckBoxBebes = new javax.swing.JCheckBox();
        jCheckBoxAnimais = new javax.swing.JCheckBox();
        jCheckBoxFumante = new javax.swing.JCheckBox();
        jTextFieldIDHospede = new javax.swing.JTextField();
        jTextFieldIDQuartos = new javax.swing.JTextField();
        jLabelIdQuartos = new javax.swing.JLabel();
        jTextFieldIDVagas = new javax.swing.JTextField();
        jLabelIdVaga = new javax.swing.JLabel();
        jLabelDataCadastro = new javax.swing.JLabel();
        jLabelDataCheckIn = new javax.swing.JLabel();
        jLabelDataCheckOut = new javax.swing.JLabel();
        jTextFieldObsReserva = new javax.swing.JTextField();
        jLabelObsReserva = new javax.swing.JLabel();
        jFormattedTextFieldCpfCnpj = new javax.swing.JFormattedTextField();
        jLabelCpfCnpj = new javax.swing.JLabel();
        jFormattedTextFieldDataNascimento = new javax.swing.JFormattedTextField();
        jLabelDataNascimento = new javax.swing.JLabel();
        jLabelEmail1 = new javax.swing.JLabel();
        jTextFieldEmail1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jFormattedTextFieldDataCadastro = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataCadastro6 = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataCheckOut = new javax.swing.JFormattedTextField();
        jLabelNomeFantasia1 = new javax.swing.JLabel();
        jTextFieldNomeHospede2 = new javax.swing.JTextField();
        jLabelFone3 = new javax.swing.JLabel();
        jFormattedTextFieldFone1Hospede2 = new javax.swing.JFormattedTextField();
        jLabelFone4 = new javax.swing.JLabel();
        jFormattedTextFieldFone2Hospede2 = new javax.swing.JFormattedTextField();
        jLabelEmail2 = new javax.swing.JLabel();
        jTextFieldEmailHospede2 = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jTextFieldQuarto1Obs = new javax.swing.JTextField();
        jLabelObs2 = new javax.swing.JLabel();
        jLabelIdHospede1 = new javax.swing.JLabel();
        jTextFieldQuarto1Andar = new javax.swing.JTextField();
        jLabelIdQuartos1 = new javax.swing.JLabel();
        jTextFieldQuarto1Capacidade = new javax.swing.JTextField();
        jLabelIdReserva1 = new javax.swing.JLabel();
        jLabelIdVaga1 = new javax.swing.JLabel();
        jTextFieldQuarto1Valor = new javax.swing.JTextField();
        jLabelObs3 = new javax.swing.JLabel();
        jTextFieldQuarto1Descricao = new javax.swing.JTextField();
        jTextFieldVeiculoObs = new javax.swing.JTextField();
        jLabelObs4 = new javax.swing.JLabel();
        jTextFieldVeiculoCor = new javax.swing.JTextField();
        jTextFieldVeiculoPlaca = new javax.swing.JTextField();
        jTextFieldIDVaga = new javax.swing.JTextField();
        jLabelIdReserva2 = new javax.swing.JLabel();
        jLabelIdHospede2 = new javax.swing.JLabel();
        jLabelIdQuartos2 = new javax.swing.JLabel();
        jLabelIdVaga2 = new javax.swing.JLabel();
        jLabelObs5 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabelSexo2 = new javax.swing.JLabel();
        jComboBoxVeiculoStatus = new javax.swing.JComboBox<>();
        jComboBoxVeiculoMarca = new javax.swing.JComboBox<>();
        jComboBoxVeiculoModelo = new javax.swing.JComboBox<>();
        jLabelIdReserva3 = new javax.swing.JLabel();
        jTextFieldIDOs = new javax.swing.JTextField();
        jLabelIdHospede3 = new javax.swing.JLabel();
        jLabelIdQuartos3 = new javax.swing.JLabel();
        jLabelIdVaga3 = new javax.swing.JLabel();
        jLabelObs6 = new javax.swing.JLabel();
        jLabelObs7 = new javax.swing.JLabel();
        jTextFieldOSDescricao = new javax.swing.JTextField();
        jLabelSexo3 = new javax.swing.JLabel();
        jComboBoxSexoStatus6 = new javax.swing.JComboBox<>();
        jSeparator4 = new javax.swing.JSeparator();
        jTextFieldOSObs = new javax.swing.JTextField();
        jTextFieldOSValor = new javax.swing.JTextField();
        jFormattedTextFieldDataCheckIn = new javax.swing.JFormattedTextField();
        jFormattedTextFieldDataCadastro10 = new javax.swing.JFormattedTextField();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldValorReserva = new javax.swing.JTextField();
        jTextFieldValorServiços = new javax.swing.JTextField();
        jTextFieldValorProduto = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldValorDespesas = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabelIdReserva4 = new javax.swing.JLabel();
        jTextFieldIDCopa = new javax.swing.JTextField();
        jLabelIdHospede4 = new javax.swing.JLabel();
        jFormattedTextFieldCopaData = new javax.swing.JFormattedTextField();
        jLabelIdVaga4 = new javax.swing.JLabel();
        jTextFieldCopaValor = new javax.swing.JTextField();
        jLabelObs8 = new javax.swing.JLabel();
        jTextFieldCopaQuantidade = new javax.swing.JTextField();
        jButtonAddCopaProduto = new javax.swing.JButton();
        jButtonAddOS = new javax.swing.JButton();
        jButtonAddVaga = new javax.swing.JButton();
        jButtonAddQuarto = new javax.swing.JButton();
        jButtonRemHospede = new javax.swing.JButton();
        jLabelCNPJ3 = new javax.swing.JLabel();
        jFormattedTextFieldHospede1Cpf = new javax.swing.JFormattedTextField();
        jFormattedTextFieldHospede1DataNascimento = new javax.swing.JFormattedTextField();
        jLabelDataCadastro6 = new javax.swing.JLabel();
        jTextFieldEmailHospede1 = new javax.swing.JTextField();
        jLabelEmail3 = new javax.swing.JLabel();
        jFormattedTextFieldFone2Hospede1 = new javax.swing.JFormattedTextField();
        jLabelFone5 = new javax.swing.JLabel();
        jLabelFone6 = new javax.swing.JLabel();
        jFormattedTextFieldFone1Hospede1 = new javax.swing.JFormattedTextField();
        jLabelNomeFantasia2 = new javax.swing.JLabel();
        jTextFieldNomeHospede1 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jSeparator6 = new javax.swing.JSeparator();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 2), new java.awt.Dimension(0, 2), new java.awt.Dimension(32767, 2));
        jTextFieldIDQuarto = new javax.swing.JTextField();
        jCheckBoxPresenca = new javax.swing.JCheckBox();
        jFormattedTextFieldHospede2Cpf = new javax.swing.JFormattedTextField();
        jLabelDataCadastro7 = new javax.swing.JLabel();
        jFormattedTextFieldHospede2DataNascimento = new javax.swing.JFormattedTextField();
        jLabelCNPJ4 = new javax.swing.JLabel();
        jButtonAddHospede = new javax.swing.JButton();
        jTextFieldCopaDescricao = new javax.swing.JTextField();
        jLabelObs9 = new javax.swing.JLabel();
        jLabelIdReserva5 = new javax.swing.JLabel();
        jTextFieldIDVeiculo = new javax.swing.JTextField();
        jPanelBotoes = new javax.swing.JPanel();
        jButtonNovo = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGravar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jPanelConteudo.setLayout(new javax.swing.BoxLayout(jPanelConteudo, javax.swing.BoxLayout.Y_AXIS));

        jPanelTitulo.setBackground(new java.awt.Color(204, 204, 204));
        jPanelTitulo.setForeground(new java.awt.Color(204, 204, 204));

        jLabelTitulo.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(102, 102, 102));
        jLabelTitulo.setText("Check");

        javax.swing.GroupLayout jPanelTituloLayout = new javax.swing.GroupLayout(jPanelTitulo);
        jPanelTitulo.setLayout(jPanelTituloLayout);
        jPanelTituloLayout.setHorizontalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTituloLayout.createSequentialGroup()
                .addGap(314, 314, 314)
                .addComponent(jLabelTitulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelTituloLayout.setVerticalGroup(
            jPanelTituloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTituloLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addContainerGap())
        );

        jPanelConteudo.add(jPanelTitulo);

        jPanelDados.setBackground(new java.awt.Color(204, 204, 204));
        jPanelDados.setForeground(new java.awt.Color(204, 204, 204));

        jLabelIdReserva.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdReserva.setText("Reserva");

        jLabelNome.setForeground(new java.awt.Color(102, 102, 102));
        jLabelNome.setText("Nome");

        jLabelFone1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFone1.setText("Fone 1");

        jLabelFone2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFone2.setText("Fone 2");

        try {
            jFormattedTextFieldFone2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldFone1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jComboBoxStatusReserva.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo", "Cancelada", "Concluída" }));

        jLabelStatusReserva.setForeground(new java.awt.Color(102, 102, 102));
        jLabelStatusReserva.setText("Status");

        jLabelIdHospede.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdHospede.setText("Hóspede");

        jCheckBoxBebes.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCheckBoxBebes.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBoxBebes.setText("Bebê");

        jCheckBoxAnimais.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCheckBoxAnimais.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBoxAnimais.setText("Animal");

        jCheckBoxFumante.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jCheckBoxFumante.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBoxFumante.setText("Fumante");

        jTextFieldIDHospede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldIDHospedeKeyPressed(evt);
            }
        });

        jLabelIdQuartos.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdQuartos.setText("Quartos");

        jLabelIdVaga.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdVaga.setText("Vaga");

        jLabelDataCadastro.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDataCadastro.setText("Cadastro");

        jLabelDataCheckIn.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDataCheckIn.setText("Check-In");

        jLabelDataCheckOut.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDataCheckOut.setText("Check-Out");

        jLabelObsReserva.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObsReserva.setText("Obs");

        try {
            jFormattedTextFieldCpfCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelCpfCnpj.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCpfCnpj.setText("CPF/CNPJ");

        try {
            jFormattedTextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelDataNascimento.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDataNascimento.setText("Nascimento");

        jLabelEmail1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEmail1.setText("Email");

        try {
            jFormattedTextFieldDataCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDataCadastro6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDataCheckOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelNomeFantasia1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelNomeFantasia1.setText("Nome");

        jLabelFone3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFone3.setText("Fone 1");

        try {
            jFormattedTextFieldFone1Hospede2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelFone4.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFone4.setText("Fone 2");

        try {
            jFormattedTextFieldFone2Hospede2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelEmail2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEmail2.setText("Email");

        jLabelObs2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObs2.setText("Obs");

        jLabelIdHospede1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdHospede1.setText("Andar");

        jLabelIdQuartos1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdQuartos1.setText("Capacidade");

        jLabelIdReserva1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdReserva1.setText("Quarto");

        jLabelIdVaga1.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdVaga1.setText("Valor");

        jLabelObs3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObs3.setText("Descrição");

        jLabelObs4.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObs4.setText("Obs");

        jTextFieldIDVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDVagaActionPerformed(evt);
            }
        });

        jLabelIdReserva2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdReserva2.setText("Vaga");

        jLabelIdHospede2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdHospede2.setText("Placa");

        jLabelIdQuartos2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdQuartos2.setText("Cor");

        jLabelIdVaga2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdVaga2.setText("Marca");

        jLabelObs5.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObs5.setText("Modelo");

        jLabelSexo2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelSexo2.setText("Status");

        jComboBoxVeiculoStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jComboBoxVeiculoMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));

        jComboBoxVeiculoModelo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ativo", "Inativo" }));
        jComboBoxVeiculoModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxVeiculoModeloActionPerformed(evt);
            }
        });

        jLabelIdReserva3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdReserva3.setText("OS");

        jLabelIdHospede3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdHospede3.setText("Início");

        jLabelIdQuartos3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdQuartos3.setText("Fim");

        jLabelIdVaga3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdVaga3.setText("Valor");

        jLabelObs6.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObs6.setText("Descrição");

        jLabelObs7.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObs7.setText("Obs");

        jLabelSexo3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelSexo3.setText("Status");

        jComboBoxSexoStatus6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agendado", "Em Andamento", "Concluído", "Cancelado" }));
        jComboBoxSexoStatus6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSexoStatus6ActionPerformed(evt);
            }
        });

        try {
            jFormattedTextFieldDataCheckIn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldDataCadastro10.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/#### ##:##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("RESERVA");

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("SERVIÇOS ADICIONAIS");

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("PRODUTOS ADICIONAIS");

        jTextFieldValorReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldValorReservaActionPerformed(evt);
            }
        });

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("DESCONTO");

        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("ACRÉSCIMO");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("VALOR FINAL");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(90, 90, 90));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("DESPESAS");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Next.png"))); // NOI18N
        jButton1.setActionCommand("0");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabelIdReserva4.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdReserva4.setText("Copa");

        jTextFieldIDCopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDCopaActionPerformed(evt);
            }
        });

        jLabelIdHospede4.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdHospede4.setText("Data");

        try {
            jFormattedTextFieldCopaData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelIdVaga4.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdVaga4.setText("Valor");

        jLabelObs8.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObs8.setText("Quantidade");

        jTextFieldCopaQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCopaQuantidadeActionPerformed(evt);
            }
        });
        jTextFieldCopaQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldCopaQuantidadeKeyPressed(evt);
            }
        });

        jButtonAddCopaProduto.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAddCopaProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonAddCopaProduto.setActionCommand("0");
        jButtonAddCopaProduto.setBorderPainted(false);
        jButtonAddCopaProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddCopaProdutoActionPerformed(evt);
            }
        });

        jButtonAddOS.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAddOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonAddOS.setActionCommand("0");
        jButtonAddOS.setBorderPainted(false);
        jButtonAddOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddOSActionPerformed(evt);
            }
        });

        jButtonAddVaga.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAddVaga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonAddVaga.setActionCommand("0");
        jButtonAddVaga.setBorderPainted(false);
        jButtonAddVaga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddVagaActionPerformed(evt);
            }
        });

        jButtonAddQuarto.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAddQuarto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonAddQuarto.setActionCommand("0");
        jButtonAddQuarto.setBorderPainted(false);
        jButtonAddQuarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddQuartoActionPerformed(evt);
            }
        });

        jButtonRemHospede.setBackground(new java.awt.Color(204, 204, 204));
        jButtonRemHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        jButtonRemHospede.setActionCommand("0");
        jButtonRemHospede.setBorderPainted(false);
        jButtonRemHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRemHospedeActionPerformed(evt);
            }
        });

        jLabelCNPJ3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCNPJ3.setText("CPF");

        try {
            jFormattedTextFieldHospede1Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jFormattedTextFieldHospede1DataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelDataCadastro6.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDataCadastro6.setText("Nascimento");

        jLabelEmail3.setForeground(new java.awt.Color(102, 102, 102));
        jLabelEmail3.setText("Email");

        try {
            jFormattedTextFieldFone2Hospede1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelFone5.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFone5.setText("Fone 2");

        jLabelFone6.setForeground(new java.awt.Color(102, 102, 102));
        jLabelFone6.setText("Fone 1");

        try {
            jFormattedTextFieldFone1Hospede1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelNomeFantasia2.setForeground(new java.awt.Color(102, 102, 102));
        jLabelNomeFantasia2.setText("Nome");

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Hourglass.png"))); // NOI18N
        jButton8.setActionCommand("0");
        jButton8.setBorderPainted(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Hourglass.png"))); // NOI18N
        jButton9.setActionCommand("0");
        jButton9.setBorderPainted(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jSeparator6.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jCheckBoxPresenca.setForeground(new java.awt.Color(102, 102, 102));
        jCheckBoxPresenca.setText("Presente");

        try {
            jFormattedTextFieldHospede2Cpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelDataCadastro7.setForeground(new java.awt.Color(102, 102, 102));
        jLabelDataCadastro7.setText("Nascimento");

        try {
            jFormattedTextFieldHospede2DataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabelCNPJ4.setForeground(new java.awt.Color(102, 102, 102));
        jLabelCNPJ4.setText("CPF");

        jButtonAddHospede.setBackground(new java.awt.Color(204, 204, 204));
        jButtonAddHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonAddHospede.setActionCommand("0");
        jButtonAddHospede.setBorderPainted(false);
        jButtonAddHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddHospedeActionPerformed(evt);
            }
        });

        jLabelObs9.setForeground(new java.awt.Color(102, 102, 102));
        jLabelObs9.setText("Descrição");

        jLabelIdReserva5.setForeground(new java.awt.Color(102, 102, 102));
        jLabelIdReserva5.setText("Veículo");

        jTextFieldIDVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldIDVeiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDadosLayout = new javax.swing.GroupLayout(jPanelDados);
        jPanelDados.setLayout(jPanelDadosLayout);
        jPanelDadosLayout.setHorizontalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabelNomeFantasia1)
                                    .addGap(354, 354, 354))
                                .addComponent(jTextFieldNomeHospede2, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabelNomeFantasia2)
                                    .addGap(354, 354, 354))
                                .addComponent(jTextFieldNomeHospede1, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFone3)
                                    .addComponent(jFormattedTextFieldFone1Hospede2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldFone2Hospede2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelFone4)))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFone6)
                                    .addComponent(jFormattedTextFieldFone1Hospede1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelFone5)
                                    .addComponent(jFormattedTextFieldFone2Hospede1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelEmail3)
                            .addComponent(jLabelEmail2)
                            .addComponent(jTextFieldEmailHospede1, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                            .addComponent(jTextFieldEmailHospede2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelDataCadastro6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelCNPJ3))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldHospede1DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldHospede1Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRemHospede)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelDataCadastro7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelCNPJ4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jFormattedTextFieldHospede2DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jFormattedTextFieldHospede2Cpf, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddHospede)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelIdReserva4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldIDCopa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdHospede4)
                            .addComponent(jFormattedTextFieldCopaData, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(3, 3, 3)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabelObs8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldCopaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldCopaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelObs9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdVaga4)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jTextFieldCopaValor, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddCopaProduto)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextFieldValorReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jTextFieldValorServiços)
                            .addComponent(jTextFieldValorProduto)
                            .addComponent(jTextFieldValorDespesas))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField4, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(jTextField8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton8)
                            .addComponent(jButton9)
                            .addComponent(jButton1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelIdReserva2, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(jTextFieldIDVaga, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelIdReserva5, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(jTextFieldIDVeiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldVeiculoPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelIdHospede2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdQuartos2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldVeiculoCor, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdVaga2)
                                    .addComponent(jComboBoxVeiculoMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelObs5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jComboBoxVeiculoModelo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelObs4)
                                    .addComponent(jTextFieldVeiculoObs, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelSexo2)
                                    .addComponent(jComboBoxVeiculoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddVaga))
                            .addComponent(jSeparator2)
                            .addComponent(jSeparator3)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                        .addGap(29, 29, 29)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelIdReserva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabelIdHospede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jTextFieldIDHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelIdQuartos)
                                                    .addComponent(jTextFieldIDQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelIdVaga)
                                                    .addComponent(jTextFieldIDVagas, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelDataCadastro)
                                                    .addComponent(jFormattedTextFieldDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(jLabelNome)
                                            .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                        .addComponent(jLabelDataCheckIn)
                                                        .addGap(74, 74, 74))
                                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                        .addComponent(jFormattedTextFieldDataCheckIn)
                                                        .addGap(12, 12, 12)))
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jFormattedTextFieldDataCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelDataCheckOut)))
                                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelFone1)
                                                    .addComponent(jFormattedTextFieldFone1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jFormattedTextFieldFone2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelFone2))))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBoxStatusReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabelStatusReserva))
                                                .addGap(5, 5, 5)
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelObsReserva)
                                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                        .addComponent(jTextFieldObsReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jCheckBoxPresenca))))
                                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelEmail1)
                                                    .addComponent(jTextFieldEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabelCpfCnpj, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                                        .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jFormattedTextFieldCpfCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                                        .addComponent(jLabelDataNascimento)
                                                        .addGap(104, 104, 104)))))
                                        .addGap(41, 41, 41))
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelIdReserva1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                            .addComponent(jTextFieldIDQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelIdHospede1)
                                            .addComponent(jTextFieldQuarto1Andar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabelIdQuartos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jTextFieldQuarto1Capacidade, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                                .addComponent(jLabelIdVaga1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jTextFieldQuarto1Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelObs3)
                                            .addComponent(jTextFieldQuarto1Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(37, 37, 37)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldQuarto1Obs, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabelObs2))
                                        .addGap(34, 34, 34)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jCheckBoxFumante)
                                                    .addComponent(jCheckBoxAnimais))
                                                .addGap(42, 42, 42))
                                            .addComponent(jButtonAddQuarto, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jCheckBoxBebes, javax.swing.GroupLayout.Alignment.TRAILING))))))
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabelIdReserva3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextFieldIDOs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelIdHospede3)
                                    .addComponent(jFormattedTextFieldDataCadastro10, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabelIdQuartos3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(jLabelIdVaga3))
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jFormattedTextFieldDataCadastro6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldOSValor, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelObs6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jTextFieldOSDescricao))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelObs7)
                                    .addComponent(jTextFieldOSObs, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBoxSexoStatus6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSexo3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddOS)))
                        .addGap(259, 259, 259))))
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGap(405, 405, 405)
                .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelDadosLayout.setVerticalGroup(
            jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDadosLayout.createSequentialGroup()
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelIdReserva)
                                            .addComponent(jLabelIdHospede)
                                            .addComponent(jLabelIdQuartos))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jTextFieldIDReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldIDHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldIDQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelIdVaga)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldIDVagas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jFormattedTextFieldDataCadastro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jLabelDataCadastro)
                                        .addGap(28, 28, 28)))
                                .addComponent(jLabelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelDataNascimento)
                                    .addComponent(jLabelCpfCnpj))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jFormattedTextFieldCpfCnpj)
                                    .addComponent(jFormattedTextFieldDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelObsReserva, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabelStatusReserva))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jTextFieldObsReserva)
                                        .addComponent(jCheckBoxPresenca))
                                    .addComponent(jComboBoxStatusReserva))
                                .addComponent(jLabelEmail1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldEmail1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                        .addContainerGap(14, Short.MAX_VALUE)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jFormattedTextFieldDataCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDataCheckIn)
                                        .addComponent(jLabelDataCheckOut))
                                    .addGap(28, 28, 28)))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jFormattedTextFieldDataCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelFone1)
                                    .addComponent(jLabelFone2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jFormattedTextFieldFone1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldFone2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabelFone6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldFone1Hospede1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabelFone5)
                                .addGap(28, 28, 28))
                            .addComponent(jFormattedTextFieldFone2Hospede1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabelFone3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldFone1Hospede2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jFormattedTextFieldFone2Hospede2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabelFone4)
                                    .addGap(28, 28, 28)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jLabelEmail3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEmailHospede1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelEmail2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldEmailHospede2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabelDataCadastro6)
                                            .addComponent(jLabelCNPJ3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jFormattedTextFieldHospede1Cpf)
                                            .addComponent(jFormattedTextFieldHospede1DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                        .addComponent(jButtonRemHospede)
                                        .addGap(11, 11, 11)))
                                .addGap(12, 12, 12))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabelNomeFantasia2))
                                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jTextFieldNomeHospede1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)))
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelDadosLayout.createSequentialGroup()
                                    .addComponent(jLabelNomeFantasia1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldNomeHospede2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelDataCadastro7)
                                        .addComponent(jLabelCNPJ4))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jFormattedTextFieldHospede2Cpf)
                                        .addComponent(jFormattedTextFieldHospede2DataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jButtonAddHospede)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jCheckBoxAnimais)
                                    .addComponent(jLabelObs2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCheckBoxFumante))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jCheckBoxBebes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAddQuarto))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jTextFieldQuarto1Obs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelIdReserva1)
                                    .addComponent(jLabelIdHospede1)
                                    .addComponent(jLabelIdQuartos1)
                                    .addComponent(jLabelIdVaga1)
                                    .addComponent(jLabelObs3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldIDQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldQuarto1Andar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldQuarto1Capacidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextFieldQuarto1Descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jTextFieldQuarto1Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdReserva5)
                            .addComponent(jLabelObs5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxVeiculoMarca)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldIDVeiculo)
                                .addComponent(jTextFieldVeiculoPlaca)
                                .addComponent(jTextFieldVeiculoCor)
                                .addComponent(jComboBoxVeiculoModelo))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelIdVaga2)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelIdQuartos2)
                                .addComponent(jLabelIdHospede2)))
                        .addGap(28, 28, 28))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButtonAddVaga, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelObs4)
                                        .addComponent(jLabelIdReserva2))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jTextFieldIDVaga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addComponent(jLabelSexo2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBoxVeiculoStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldVeiculoObs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelIdReserva3)
                                .addComponent(jLabelIdHospede3)
                                .addComponent(jLabelIdQuartos3)
                                .addComponent(jLabelIdVaga3))
                            .addComponent(jLabelObs6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldIDOs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldOSDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldOSValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataCadastro6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jFormattedTextFieldDataCadastro10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabelObs7)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jLabelSexo3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxSexoStatus6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jButtonAddOS))
                    .addComponent(jTextFieldOSObs, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldValorReserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldValorServiços, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(jTextFieldValorProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextFieldValorDespesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelDadosLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7)))))
                    .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addComponent(jLabelIdVaga4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonAddCopaProduto)
                                .addComponent(jTextFieldCopaValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanelDadosLayout.createSequentialGroup()
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelIdReserva4)
                                .addComponent(jLabelIdHospede4)
                                .addComponent(jLabelObs8)
                                .addComponent(jLabelObs9))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldIDCopa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldCopaQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jFormattedTextFieldCopaData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jTextFieldCopaDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelDadosLayout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addGap(34, 34, 34)
                        .addComponent(jButton1)))
                .addContainerGap())
        );

        jPanelConteudo.add(jPanelDados);

        jPanelBotoes.setBackground(new java.awt.Color(204, 204, 204));

        jButtonNovo.setBackground(new java.awt.Color(204, 204, 204));
        jButtonNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Create.png"))); // NOI18N
        jButtonNovo.setMnemonic(KeyEvent.VK_N);
        jButtonNovo.setText("Novo");
        jButtonNovo.setActionCommand("1");
        jButtonNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNovoActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonNovo);

        jButtonCancelar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Delete.png"))); // NOI18N
        jButtonCancelar.setMnemonic(KeyEvent.VK_C);
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setActionCommand("0");
        jButtonCancelar.setEnabled(false);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonCancelar);

        jButtonGravar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonGravar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/OK.png"))); // NOI18N
        jButtonGravar.setMnemonic('K');
        jButtonGravar.setText("Gravar");
        jButtonGravar.setActionCommand("0");
        jButtonGravar.setEnabled(false);
        jButtonGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGravarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonGravar);

        jButtonBuscar.setBackground(new java.awt.Color(204, 204, 204));
        jButtonBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Find.png"))); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setActionCommand("1");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonBuscar);

        jButtonSair.setBackground(new java.awt.Color(204, 204, 204));
        jButtonSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Exit.png"))); // NOI18N
        jButtonSair.setText("Sair");
        jButtonSair.setActionCommand("1");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });
        jPanelBotoes.add(jButtonSair);

        jPanelConteudo.add(jPanelBotoes);

        jScrollPane1.setViewportView(jPanelConteudo);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1321, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JFormattedTextField getjFormattedTextFieldHospede2DataNascimento() {
        return jFormattedTextFieldHospede2DataNascimento;
    }

    public void setjFormattedTextFieldHospede2DataNascimento(JFormattedTextField jFormattedTextFieldHospede2DataNascimento) {
        this.jFormattedTextFieldHospede2DataNascimento = jFormattedTextFieldHospede2DataNascimento;
    }

    public JTextField getjTextFieldIDVeiculo() {
        return jTextFieldIDVeiculo;
    }

    public void setjTextFieldIDVeiculo(JTextField jTextFieldIDVeiculo) {
        this.jTextFieldIDVeiculo = jTextFieldIDVeiculo;
    }

    private void jButtonNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNovoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonNovoActionPerformed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGravarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonGravarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxSexoStatus6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSexoStatus6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSexoStatus6ActionPerformed

    private void jTextFieldValorReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldValorReservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldValorReservaActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Tela de Pagamento");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAddVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddVagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddVagaActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButtonAddQuartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddQuartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddQuartoActionPerformed

    private void jTextFieldIDVagaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDVagaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDVagaActionPerformed

    private void jComboBoxVeiculoModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxVeiculoModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxVeiculoModeloActionPerformed

    private void jTextFieldIDCopaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDCopaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDCopaActionPerformed

    private void jTextFieldIDHospedeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldIDHospedeKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextFieldIDHospedeKeyPressed

    private void jButtonAddHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddHospedeActionPerformed

    private void jTextFieldCopaQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCopaQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCopaQuantidadeActionPerformed

    private void jTextFieldCopaQuantidadeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldCopaQuantidadeKeyPressed
        // TODO add your handling code here:
        // Verifica se a tecla pressionada foi o Enter
        /*if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            // Chama o método de busca que você já tem no seu JButton
            //setjtextfiel;
        }*/
    }//GEN-LAST:event_jTextFieldCopaQuantidadeKeyPressed

    public JButton getjButtonAddCopaProduto() {
        return jButtonAddCopaProduto;
    }

    public void setjButtonAddCopaProduto(JButton jButtonAddCopaProduto) {
        this.jButtonAddCopaProduto = jButtonAddCopaProduto;
    }

    public JButton getjButtonAddHospede() {
        return jButtonAddHospede;
    }

    public void setjButtonAddHospede(JButton jButtonAddHospede) {
        this.jButtonAddHospede = jButtonAddHospede;
    }

    public JButton getjButtonAddOS() {
        return jButtonAddOS;
    }

    public void setjButtonAddOS(JButton jButtonAddOS) {
        this.jButtonAddOS = jButtonAddOS;
    }

    public JButton getjButtonAddQuarto() {
        return jButtonAddQuarto;
    }

    public void setjButtonAddQuarto(JButton jButtonAddQuarto) {
        this.jButtonAddQuarto = jButtonAddQuarto;
    }

    public JButton getjButtonAddVaga() {
        return jButtonAddVaga;
    }

    public void setjButtonAddVaga(JButton jButtonAddVaga) {
        this.jButtonAddVaga = jButtonAddVaga;
    }

    private void jTextFieldIDVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldIDVeiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldIDVeiculoActionPerformed

    private void jButtonRemHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRemHospedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRemHospedeActionPerformed

    private void jButtonAddOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddOSActionPerformed

    private void jButtonAddCopaProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddCopaProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddCopaProdutoActionPerformed

    public JCheckBox getjCheckBoxPresenca() {
        return jCheckBoxPresenca;
    }

    public void setjCheckBoxPresenca(JCheckBox jCheckBoxPresenca) {
        this.jCheckBoxPresenca = jCheckBoxPresenca;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MovimentoCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MovimentoCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MovimentoCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MovimentoCheck.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MovimentoCheck dialog = new MovimentoCheck(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButtonAddCopaProduto;
    private javax.swing.JButton jButtonAddHospede;
    private javax.swing.JButton jButtonAddOS;
    private javax.swing.JButton jButtonAddQuarto;
    private javax.swing.JButton jButtonAddVaga;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGravar;
    private javax.swing.JButton jButtonNovo;
    private javax.swing.JButton jButtonRemHospede;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JCheckBox jCheckBoxAnimais;
    private javax.swing.JCheckBox jCheckBoxBebes;
    private javax.swing.JCheckBox jCheckBoxFumante;
    private javax.swing.JCheckBox jCheckBoxPresenca;
    private javax.swing.JComboBox<String> jComboBoxSexoStatus6;
    private javax.swing.JComboBox<String> jComboBoxStatusReserva;
    private javax.swing.JComboBox<String> jComboBoxVeiculoMarca;
    private javax.swing.JComboBox<String> jComboBoxVeiculoModelo;
    private javax.swing.JComboBox<String> jComboBoxVeiculoStatus;
    private javax.swing.JFormattedTextField jFormattedTextFieldCopaData;
    private javax.swing.JFormattedTextField jFormattedTextFieldCpfCnpj;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCadastro;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCadastro10;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCadastro6;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCheckIn;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataCheckOut;
    private javax.swing.JFormattedTextField jFormattedTextFieldDataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone1;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone1Hospede1;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone1Hospede2;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone2;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone2Hospede1;
    private javax.swing.JFormattedTextField jFormattedTextFieldFone2Hospede2;
    private javax.swing.JFormattedTextField jFormattedTextFieldHospede1Cpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldHospede1DataNascimento;
    private javax.swing.JFormattedTextField jFormattedTextFieldHospede2Cpf;
    private javax.swing.JFormattedTextField jFormattedTextFieldHospede2DataNascimento;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelCNPJ3;
    private javax.swing.JLabel jLabelCNPJ4;
    private javax.swing.JLabel jLabelCpfCnpj;
    private javax.swing.JLabel jLabelDataCadastro;
    private javax.swing.JLabel jLabelDataCadastro6;
    private javax.swing.JLabel jLabelDataCadastro7;
    private javax.swing.JLabel jLabelDataCheckIn;
    private javax.swing.JLabel jLabelDataCheckOut;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelEmail1;
    private javax.swing.JLabel jLabelEmail2;
    private javax.swing.JLabel jLabelEmail3;
    private javax.swing.JLabel jLabelFone1;
    private javax.swing.JLabel jLabelFone2;
    private javax.swing.JLabel jLabelFone3;
    private javax.swing.JLabel jLabelFone4;
    private javax.swing.JLabel jLabelFone5;
    private javax.swing.JLabel jLabelFone6;
    private javax.swing.JLabel jLabelIdHospede;
    private javax.swing.JLabel jLabelIdHospede1;
    private javax.swing.JLabel jLabelIdHospede2;
    private javax.swing.JLabel jLabelIdHospede3;
    private javax.swing.JLabel jLabelIdHospede4;
    private javax.swing.JLabel jLabelIdQuartos;
    private javax.swing.JLabel jLabelIdQuartos1;
    private javax.swing.JLabel jLabelIdQuartos2;
    private javax.swing.JLabel jLabelIdQuartos3;
    private javax.swing.JLabel jLabelIdReserva;
    private javax.swing.JLabel jLabelIdReserva1;
    private javax.swing.JLabel jLabelIdReserva2;
    private javax.swing.JLabel jLabelIdReserva3;
    private javax.swing.JLabel jLabelIdReserva4;
    private javax.swing.JLabel jLabelIdReserva5;
    private javax.swing.JLabel jLabelIdVaga;
    private javax.swing.JLabel jLabelIdVaga1;
    private javax.swing.JLabel jLabelIdVaga2;
    private javax.swing.JLabel jLabelIdVaga3;
    private javax.swing.JLabel jLabelIdVaga4;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JLabel jLabelNomeFantasia1;
    private javax.swing.JLabel jLabelNomeFantasia2;
    private javax.swing.JLabel jLabelObs2;
    private javax.swing.JLabel jLabelObs3;
    private javax.swing.JLabel jLabelObs4;
    private javax.swing.JLabel jLabelObs5;
    private javax.swing.JLabel jLabelObs6;
    private javax.swing.JLabel jLabelObs7;
    private javax.swing.JLabel jLabelObs8;
    private javax.swing.JLabel jLabelObs9;
    private javax.swing.JLabel jLabelObsReserva;
    private javax.swing.JLabel jLabelSexo2;
    private javax.swing.JLabel jLabelSexo3;
    private javax.swing.JLabel jLabelStatusReserva;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelBotoes;
    private javax.swing.JPanel jPanelConteudo;
    private javax.swing.JPanel jPanelDados;
    private javax.swing.JPanel jPanelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jTextFieldCopaDescricao;
    private javax.swing.JTextField jTextFieldCopaQuantidade;
    private javax.swing.JTextField jTextFieldCopaValor;
    private javax.swing.JTextField jTextFieldEmail1;
    private javax.swing.JTextField jTextFieldEmailHospede1;
    private javax.swing.JTextField jTextFieldEmailHospede2;
    private javax.swing.JTextField jTextFieldIDCopa;
    private javax.swing.JTextField jTextFieldIDHospede;
    private javax.swing.JTextField jTextFieldIDOs;
    private javax.swing.JTextField jTextFieldIDQuarto;
    private javax.swing.JTextField jTextFieldIDQuartos;
    private javax.swing.JTextField jTextFieldIDReserva;
    private javax.swing.JTextField jTextFieldIDVaga;
    private javax.swing.JTextField jTextFieldIDVagas;
    private javax.swing.JTextField jTextFieldIDVeiculo;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldNomeHospede1;
    private javax.swing.JTextField jTextFieldNomeHospede2;
    private javax.swing.JTextField jTextFieldOSDescricao;
    private javax.swing.JTextField jTextFieldOSObs;
    private javax.swing.JTextField jTextFieldOSValor;
    private javax.swing.JTextField jTextFieldObsReserva;
    private javax.swing.JTextField jTextFieldQuarto1Andar;
    private javax.swing.JTextField jTextFieldQuarto1Capacidade;
    private javax.swing.JTextField jTextFieldQuarto1Descricao;
    private javax.swing.JTextField jTextFieldQuarto1Obs;
    private javax.swing.JTextField jTextFieldQuarto1Valor;
    private javax.swing.JTextField jTextFieldValorDespesas;
    private javax.swing.JTextField jTextFieldValorProduto;
    private javax.swing.JTextField jTextFieldValorReserva;
    private javax.swing.JTextField jTextFieldValorServiços;
    private javax.swing.JTextField jTextFieldVeiculoCor;
    private javax.swing.JTextField jTextFieldVeiculoObs;
    private javax.swing.JTextField jTextFieldVeiculoPlaca;
    // End of variables declaration//GEN-END:variables
}

/*      CRIANDO JLABEL PERSONALIZADO::
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import javax.swing.JLabel;

public class RotatedLabel extends JLabel {
    private double angle = 0;

    public RotatedLabel(String text) {
        super(text);
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        // Gira em torno do centro do label
        AffineTransform at = AffineTransform.getRotateInstance(
            Math.toRadians(angle), getWidth() / 2, getHeight() / 2);
        g2.setTransform(at);
        super.paintComponent(g2);
        g2.dispose();
    }
}




ATALHOS/FUNCOES
Definir atalhos de teclado para botões em Java, especificamente usando Swing, é geralmente feito através da API KeyBinding ou usando Mnemonics (mnemônicos). O uso de mnemônicos é a forma mais simples, vinculando uma letra sublinhada no texto do botão a uma ação (geralmente Alt + Letra). 
www.guj.com.br
www.guj.com.br
 +2
Aqui estão as formas de definir atalhos:
1. Usando Mnemônicos (setMnemonic)
Esta abordagem vincula uma tecla específica ao botão, ativando-o automaticamente ao pressionar Alt + [tecla].
java
JButton btnSalvar = new JButton("Salvar");
// Define o 'S' como tecla de atalho (Alt + S)
btnSalvar.setMnemonic(KeyEvent.VK_S);
Isso também sublinha a letra 'S' no texto do botão, indicando ao usuário que é um atalho. 
www.guj.com.br
www.guj.com.br
 +1
2. Usando KeyBindings (Mais Avançado/Flexível)
Para atalhos mais complexos (como Ctrl+S, F5, etc.), o KeyBinding é o ideal. Ele permite associar uma tecla a uma ação específica, mesmo que o botão não tenha o foco. 
java
// 1. Obter o mapa de entrada e o mapa de ação do componente
InputMap im = btnSalvar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
ActionMap am = btnSalvar.getActionMap();

// 2. Definir a tecla (Ctrl+S)
KeyStroke ctrlS = KeyStroke.getKeyStroke(KeyEvent.VK_S, Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());

// 3. Vincular a tecla a uma ação
im.put(ctrlS, "salvarAction");
am.put("salvarAction", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Código para salvar
        System.out.println("Salvo com sucesso!");
    }
});
Esta abordagem permite que o atalho funcione em toda a janela, independentemente de onde o foco esteja. 
Stack Overflow em Português
Stack Overflow em Português
 +1
3. Atalhos no JavaFX
No JavaFX, você pode adicionar atalhos de teclado à cena ou a componentes específicos.
java
button.setOnAction(e -> System.out.println("Botão pressionado"));
scene.getAccelerators().put(
    new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN),
    () -> button.fire()
);
Isso faz com que o Ctrl+S execute a mesma ação do botão. 

*/