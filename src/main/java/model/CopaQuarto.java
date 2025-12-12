package model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CopaQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private float quantidade;
    @Column
    private String dataHoraPedido;
    @Column
    private String obs;
    @Column
    private char status;

    public CopaQuarto() {
    }

    public CopaQuarto(int id, float quantidade, String dataHoraPedido, String obs, char status) {
        this.id = id;
        this.quantidade = quantidade;
        this.dataHoraPedido = dataHoraPedido;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return id + ": " + dataHoraPedido
                + "\nQuantidade: " + quantidade
                + "\nObs.: " + obs
                + "\nStatus: " + status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(String dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
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
