package model;

public class OrdemServico {
    private int id;
    private String dataHoraCadastro, dataHoraPrevisaoInicio, dataHoraPrevisaoFim, obs;
    private char status;

    public OrdemServico() {
    }

    public OrdemServico(int id, String dataHoraCadastro, String dataHoraPrevisaoInicio, String dataHoraPrevisaoFim, String obs, char status) {
        this.id = id;
        this.dataHoraCadastro = dataHoraCadastro;
        this.dataHoraPrevisaoInicio = dataHoraPrevisaoInicio;
        this.dataHoraPrevisaoFim = dataHoraPrevisaoFim;
        this.obs = obs;
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrdemServico{" + "id=" + id + ", dataHoraCadastro=" + dataHoraCadastro + ", dataHoraPrevisaoInicio=" + dataHoraPrevisaoInicio + ", dataHoraPrevisaoFim=" + dataHoraPrevisaoFim + ", obs=" + obs + ", status=" + status + '}';
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

    public String getDataHoraPrevisaoInicio() {
        return dataHoraPrevisaoInicio;
    }

    public void setDataHoraPrevisaoInicio(String dataHoraPrevisaoInicio) {
        this.dataHoraPrevisaoInicio = dataHoraPrevisaoInicio;
    }

    public String getDataHoraPrevisaoFim() {
        return dataHoraPrevisaoFim;
    }

    public void setDataHoraPrevisaoFim(String dataHoraPrevisaoFim) {
        this.dataHoraPrevisaoFim = dataHoraPrevisaoFim;
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
