package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AlocacaoVaga implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String obs;
    @Column
    private char status;

    public AlocacaoVaga() {
    }

    public AlocacaoVaga(int id, String obs, char status) {
        this.id = id;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Alocação: " + id + " -> " + status +
                "\nObs.: " + obs ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
