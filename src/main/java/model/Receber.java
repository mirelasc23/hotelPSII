package model;

public class Receber {
    private int id;
    private String dataHoraCadastro, obs;
    private float valorOriginal, desconto, acrescimo, valorPago;
    private char status;

    public Receber() {
    }

    public Receber(int id, String dataHoraCadastro, String obs, float valorOriginal, float desconto, float acrescimo, float valorPago, char status) {
        this.id = id;
        this.dataHoraCadastro = dataHoraCadastro;
        this.obs = obs;
        this.valorOriginal = valorOriginal;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
        this.valorPago = valorPago;
        this.status = status;
    }

    @Override
    public String toString() {
        return dataHoraCadastro 
                + "\nValor Original: " + valorOriginal
                + "\nDesconto: " + desconto 
                + "\nAcréscimo: " + acrescimo 
                + "\nValor Pago: " + valorPago 
                + "\nObs.:" + obs 
                + "\nStatus: " + status;
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

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public float getValorOriginal() {
        return valorOriginal;
    }

    public void setValorOriginal(float valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public float getAcrescimo() {
        return acrescimo;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public float getValorPago() {
        return valorPago;
    }

    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    
}
