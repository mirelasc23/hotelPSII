package model;

public class ProdutoCopa {
    private int id;
    private String descricao, obs;
    private float valor;
    private char status;

    public ProdutoCopa() {
    }

    public ProdutoCopa(int id, String descricao, String obs, float valor, char status) {
        this.id = id;
        this.descricao = descricao;
        this.obs = obs;
        this.valor = valor;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProdutoCopa{" + "id=" + id + ", descricao=" + descricao + ", obs=" + obs + ", valor=" + valor + ", status=" + status + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    
}
