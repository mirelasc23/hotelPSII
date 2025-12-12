package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Check implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String dataHoraCadastro; 
    @Column
    private String dataHoraEntrada;
    @Column
    private String dataHoraSaida;
    @Column
    private String obs;
    @Column
    private char status;

    public Check() {
    }

    public Check(int id, String dataHoraCadastro, String dataHoraEntrada, String dataHoraSaida, String obs, char status) {
        this.id = id;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Check{" + "id=" + id + ", dataHoraCadastro=" + dataHoraCadastro + ", dataHoraEntrada=" + dataHoraEntrada + ", dataHoraSaida=" + dataHoraSaida + ", obs=" + obs + ", status=" + status + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataHoraCadastro() {
        return dataHoraCadastro;
    }

    public void setDataHoraCadastro(String dataHoraCadastro) {
        this.dataHoraCadastro = dataHoraCadastro;
    }

    public String getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public void setDataHoraEntrada(String dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public String getDataHoraSaida() {
        return dataHoraSaida;
    }

    public void setDataHoraSaida(String dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
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
