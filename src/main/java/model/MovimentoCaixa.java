package model;

public class MovimentoCaixa {
    private int id;
    private float valor;
    private String dataHoraMovimento, descricao, obs;
    private char status;

    public MovimentoCaixa() {
    }

    public MovimentoCaixa(int id, float valor, String dataHoraMovimento, String descricao, String obs, char status) {
        this.id = id;
        this.valor = valor;
        this.dataHoraMovimento = dataHoraMovimento;
        this.descricao = descricao;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Valor do Movimento: R$ " + valor + ", " + dataHoraMovimento
                + "\nDescrição do Movimento: " + descricao
                + "\nObs.: " + obs + ", status=" + status + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDataHoraMovimento() {
        return dataHoraMovimento;
    }

    public void setDataHoraMovimento(String dataHoraMovimento) {
        this.dataHoraMovimento = dataHoraMovimento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
