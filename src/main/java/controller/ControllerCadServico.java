package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CadastroServico;

public class ControllerCadServico implements ActionListener{
        CadastroServico telaCadastroServico;

    public ControllerCadServico(CadastroServico telaCadastroServico) {
        this.telaCadastroServico = telaCadastroServico;
        this.telaCadastroServico.getjButtonNovo().addActionListener(this);
        this.telaCadastroServico.getjButtonGravar().addActionListener(this);
        this.telaCadastroServico.getjButtonBuscar().addActionListener(this);
        this.telaCadastroServico.getjButtonCancelar().addActionListener(this);
        this.telaCadastroServico.getjButtonSair().addActionListener(this);
        utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), true);
        utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);
        
        //Desenvolver as setagens de situação inicial dos componentes:  ||quais botões estarão ativos
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.telaCadastroServico.getjButtonNovo()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), false);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), true);
        }else if(e.getSource() == this.telaCadastroServico.getjButtonGravar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroServico.getjButtonBuscar()){
            /*BuscaHospede telaBuscaHospede= new BuscaHospede(null, true);
            ControllerBuscaHospede controllerBuscaHospedes = new ControllerBuscaHospede(telaBuscaHospede);
            telaBuscaHospede.setVisible(true);*/
        }else if(e.getSource() == this.telaCadastroServico.getjButtonCancelar()){
            utilities.Utilities.ativaDesativaBotoes(this.telaCadastroServico.getjPanelBotoes(), true);
            utilities.Utilities.limpaComponentes(this.telaCadastroServico.getjPanelDados(), false);
        }else if(e.getSource() == this.telaCadastroServico.getjButtonSair()){
           this.telaCadastroServico.dispose();
        }
        
    }
}