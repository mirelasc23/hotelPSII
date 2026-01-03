package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String placa; 
    @Column
    private String cor;
    @Column
    private char status;

    public Veiculo() {
    }

    public Veiculo(int id, String placa, String cor, char status) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Placa: " + placa 
                + "\nCor: " + cor 
                + "\n"+ status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    
}
