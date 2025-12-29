package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class VagaEstacionamento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "metragem_vaga")
    private float metragemVaga;
    @Column
    private String obs;
    @Column
    private String descricao;
    @Column
    private char status;

    public VagaEstacionamento(){
    }

    public VagaEstacionamento(int id, float metragemVaga, String obs, String descricao){
        this.id = id;
        this.metragemVaga = metragemVaga;
        this.obs = obs;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Vaga " + id + " -> metragem:" + metragemVaga + " -> " + status + ".";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMetragemVaga() {
        return metragemVaga;
    }

    public void setMetragemVaga(float metragemVaga) {
        this.metragemVaga = metragemVaga;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    
}