package model;

public class Caixa {
    private int id;
    private float valorDeAbertura, valorDeFechamento;
    private String dataHoraAbertura, dataHoraFechamento;
    private String obs;
    private char status;

    public Caixa() {
    }

    public Caixa(int id, float valorDeAbertura, float valorDeFechamento, String dataHoraAbertura, String dataHoraFechamento, String obs, char status) {
        this.id = id;
        this.valorDeAbertura = valorDeAbertura;
        this.valorDeFechamento = valorDeFechamento;
        this.dataHoraAbertura = dataHoraAbertura;
        this.dataHoraFechamento = dataHoraFechamento;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Abertura de caixa: R$ " + valorDeAbertura + ", " + dataHoraAbertura + " "
                + "\nFechamento de Caixa: R$ " + valorDeFechamento + ", " + dataHoraFechamento + " "
                + "\nobs=" + obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValorDeAbertura() {
        return valorDeAbertura;
    }

    public void setValorDeAbertura(float valorDeAbertura) {
        this.valorDeAbertura = valorDeAbertura;
    }

    public float getValorDeFechamento() {
        return valorDeFechamento;
    }

    public void setValorDeFechamento(float valorDeFechamento) {
        this.valorDeFechamento = valorDeFechamento;
    }

    public String getDataHoraAbertura() {
        return dataHoraAbertura;
    }

    public void setDataHoraAbertura(String dataHoraAbertura) {
        this.dataHoraAbertura = dataHoraAbertura;
    }

    public String getDataHoraFechamento() {
        return dataHoraFechamento;
    }

    public void setDataHoraFechamento(String dataHoraFechamento) {
        this.dataHoraFechamento = dataHoraFechamento;
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
