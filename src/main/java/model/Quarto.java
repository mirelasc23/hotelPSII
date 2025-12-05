package model;

public class Quarto {
    private int id, capacidadeHospedes, andar;
    private float metragem;
    private String descricao, identificacao, obs;//
    private boolean flagAnimais, flagFumante, flagBebe;//
    private char status;//

    public Quarto() {
    }

    public Quarto(int id, int capacidadeHospedes, int andar, float metragem, String descricao, String identificacao, String obs, boolean flagAnimais, boolean flagFumante, boolean flagBebe, char status) {
        this.id = id;
        this.capacidadeHospedes = capacidadeHospedes;
        this.andar = andar;
        this.metragem = metragem;
        this.descricao = descricao;
        this.identificacao = identificacao;
        this.obs = obs;
        this.flagAnimais = flagAnimais;
        this.flagFumante = flagFumante;
        this.flagBebe = flagBebe;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Quarto{" + "id=" + id + ", capacidadeHospedes=" + capacidadeHospedes + ", andar=" + andar + ", metragem=" + metragem + ", descricao=" + descricao + ", identificacao=" + identificacao + ", obs=" + obs + ", flagAnimais=" + flagAnimais + ", flagFumante=" + flagFumante + ", flagBebe=" + flagBebe + ", status=" + status + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidadeHospedes() {
        return capacidadeHospedes;
    }

    public void setCapacidadeHospedes(int capacidadeHospedes) {
        this.capacidadeHospedes = capacidadeHospedes;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public float getMetragem() {
        return metragem;
    }

    public void setMetragem(float metragem) {
        this.metragem = metragem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public boolean isFlagAnimais() {
        return flagAnimais;
    }

    public void setFlagAnimais(boolean flagAnimais) {
        this.flagAnimais = flagAnimais;
    }

    public boolean isFlagFumante() {
        return flagFumante;
    }

    public void setFlagFumante(boolean flagFumante) {
        this.flagFumante = flagFumante;
    }

    public boolean isFlagBebe() {
        return flagBebe;
    }

    public void setFlagBebe(boolean flagBebe) {
        this.flagBebe = flagBebe;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    
}
