package model;

public class Reserva {
    private int id;
    private String dataHoraInicio, dataPrevistaEntrada, dataPrevistaSaida, obs;
    private char status;

    public Reserva() {
    }

    public Reserva(int id, String dataHoraInicio, String dataPrevistaEntrada, String dataPrevistaSaida, String obs, char status) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataPrevistaEntrada = dataPrevistaEntrada;
        this.dataPrevistaSaida = dataPrevistaSaida;
        this.obs = obs;
        this.status = status;
        
    }

    @Override
    public String toString() {
        return "Reserva " + id + ": " + status
                + "\n DataHora Inicio: " + dataHoraInicio + " "
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

    public String getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(String dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
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
    
    
}
