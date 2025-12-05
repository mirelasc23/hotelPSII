package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
        
        //Desenvolver as setagens de situação inicial dos componentes:  ||quais botões estarão ativos
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroVeiculo.getjButtonNovo()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), true);
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonGravar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonBuscar()){
            /*BuscaHospede telaBuscaHospede= new BuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospedes = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);*/
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroVeiculo.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroVeiculo.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroVeiculo.getjButtonSair()){
           this.telaCadastroVeiculo.dispose();
        }
        
    }
}