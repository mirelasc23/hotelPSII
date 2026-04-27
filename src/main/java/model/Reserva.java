package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_reserva")
    private Date dataHoraReserva;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_prevista_entrada")
    private Date dataPrevistaEntrada;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_prevista_saida")
    private Date dataPrevistaSaida;
    @Column
    private String obs;
    @Column
    private char status;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "reserva_reserva_quarto", // Nome da tabela auxiliar
        joinColumns = @JoinColumn(name = "id"), // Coluna desta entidade
        inverseJoinColumns = @JoinColumn(name = "id") // Coluna da outra entidade
    )
    private List<ReservaQuarto> reservaQuartos;

    public Reserva() {
        this.reservaQuartos = new ArrayList<>();
    }

    public Reserva(int id, Date dataHoraReserva, Date dataPrevistaEntrada, Date dataPrevistaSaida, String obs, char status) {
        this.id = id;
        this.dataHoraReserva = dataHoraReserva;
        this.dataPrevistaEntrada = dataPrevistaEntrada;
        this.dataPrevistaSaida = dataPrevistaSaida;
        this.obs = obs;
        this.status = status;
        this.reservaQuartos = new ArrayList<>();
        
    }

    @Override
    public String toString() {
        return "Reserva " + id + ": " + status
                + "\n DataHora Reserva: " + dataHoraReserva + " "
                + "\n Data Prevista de Entrada: " + dataPrevistaEntrada + " "
                + "\n Data Prevista de Saída: " + dataPrevistaSaida + " "
                + "\n Obs.: " + obs ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraReserva() {
        return dataHoraReserva;
    }

    public void setDataHoraReserva(Date dataHoraReserva) {
        this.dataHoraReserva = dataHoraReserva;
    }

    public Date getDataPrevistaEntrada() {
        return dataPrevistaEntrada;
    }

    public void setDataPrevistaEntrada(Date dataPrevistaEntrada) {
        this.dataPrevistaEntrada = dataPrevistaEntrada;
    }

    public Date getDataPrevistaSaida() {
        return dataPrevistaSaida;
    }

    public void setDataPrevistaSaida(Date dataPrevistaSaida) {
        this.dataPrevistaSaida = dataPrevistaSaida;
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

    public List<ReservaQuarto> getReservaQuartos() {
        return reservaQuartos;
    }

    public void setReservaQuartos(List<ReservaQuarto> reservaQuartos) {
        this.reservaQuartos = reservaQuartos;
    }
    
    public void addQuartoComReserva(ReservaQuarto reservaQuarto){
        this.reservaQuartos.add(reservaQuarto);
        reservaQuarto.setReserva(this);
        
    }
}
