package model;

public class ReservaQuarto {
    private int id;
    private String dataHoraInicio, dataHoraFim, obs;
    private char status;

    public ReservaQuarto() {
    }

    public ReservaQuarto(int id, String dataHoraInicio, String dataHoraFim, String obs, char status) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reserva: " + id + " -> " + status
                + "\nInicio: " + dataHoraInicio 
                + "\nFim: " + dataHoraFim
                + "\nObs.: " + obs;
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

    public String getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(String dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
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
