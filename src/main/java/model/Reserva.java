package model;

import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int id;
    private String dataHoraReserva, dataPrevistaEntrada, dataPrevistaSaida, obs;
    private char status;
    private List<ReservaQuarto> reservaQuartos;

    public Reserva() {
        this.reservaQuartos = new ArrayList<>();
    }

    public Reserva(int id, String dataHoraReserva, String dataPrevistaEntrada, String dataPrevistaSaida, String obs, char status) {
        this.id = id;
        this.dataHoraReserva = dataHoraReserva;
        this.dataPrevistaEntrada = dataPrevistaEntrada;
        this.dataPrevistaSaida = dataPrevistaSaida;
        this.obs = obs;
        this.status = status;
        this.reservaQuartos = new ArrayList<>();
        
    }

    @Override
    public String toString() {
        return "Reserva " + id + ": " + status
                + "\n DataHora Reserva: " + dataHoraReserva + " "
                + "\n Data Prevista de Entrada: " + dataPrevistaEntrada + " "
                + "\n Data Prevista de Saída: " + dataPrevistaSaida + " "
                + "\n Obs.: " + obs ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(String dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public String getDataPrevistaEntrada() {
        return dataPrevistaEntrada;
    }

    public void setDataPrevistaEntrada(String dataPrevistaEntrada) {
        this.dataPrevistaEntrada = dataPrevistaEntrada;
    }

    public String getDataPrevistaSaida() {
        return dataPrevistaSaida;
    }

    public void setDataPrevistaSaida(String dataPrevistaSaida) {
        this.dataPrevistaSaida = dataPrevistaSaida;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public List<ReservaQuarto> getReservaQuartos() {
        return reservaQuartos;
    }

    public void setReservaQuartos(List<ReservaQuarto> reservaQuartos) {
        this.reservaQuartos = reservaQuartos;
    }
    
    public void addQuartoComReserva(ReservaQuarto reservaQuarto){
        this.reservaQuartos.add(reservaQuarto);
        reservaQuarto.setReserva(this);
        
    }
}
