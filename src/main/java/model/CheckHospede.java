package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CheckHospede implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String tipoHospede;
    @Column
    private String obs;
    @Column
    private char status;

    public CheckHospede() {
    }

    public CheckHospede(int id, String tipoHospede, String obs, char status) {
        this.id = id;
        this.tipoHospede = tipoHospede;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Check: " + id + " -> " + status
                + "\nObs.:" + obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoHospede() {
        return tipoHospede;
    }

    public void setTipoHospede(String tipoHospede) {
        this.tipoHospede = tipoHospede;
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
