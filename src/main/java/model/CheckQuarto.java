package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CheckQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String dataHoraInicio;
    @Column
    private String dataHoraFim;
    @Column
    private String obs;
    @Column
    private char status;

    public CheckQuarto() {
    }

    public CheckQuarto(int id, String dataHoraInicio, String dataHoraFim, String obs, char status) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return "CheckQuarto{" + "id=" + id + ", dataHoraInicio=" + dataHoraInicio + ", dataHoraFim=" + dataHoraFim + ", obs=" + obs + ", status=" + status + '}';
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
