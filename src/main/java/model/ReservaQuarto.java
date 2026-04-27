package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="reserva_quarto")
public class ReservaQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_inicio")
    private Date dataHoraInicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_hora_fim")
    private Date dataHoraFim;
    @Column
    private String obs;
    @Column
    private char status;
    
    
    /*@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quarto_id")/
    @JoinTable(
        name = "reserva_quarto_quarto", // Nome da tabela auxiliar
        joinColumns = @JoinColumn(name = "id"), // Coluna desta entidade
        inverseJoinColumns = @JoinColumn(name = "id") // Coluna da outra entidade
    )*/
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quarto_id") // Deve ser exatamente o nome da coluna no seu DB
    private Quarto quarto;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    public ReservaQuarto() {
    }

    public ReservaQuarto(int id, Date dataHoraInicio, Date dataHoraFim, String obs, char status, Quarto quarto, Reserva reserva) {
        this.id = id;
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.obs = obs;
        this.status = status;
        this.quarto = quarto;
        this.reserva = reserva;
    }

    @Override
    public String toString() {
        return "Reserva: " + id + " -> " + status
                + "\nInicio: " + dataHoraInicio 
                + "\nFim: " + dataHoraFim
                + "\nObs.: " + obs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataHoraInicio() {
        return dataHoraInicio;
    }

    public void setDataHoraInicio(Date dataHoraInicio) {
        this.dataHoraInicio = dataHoraInicio;
    }

    public Date getDataHoraFim() {
        return dataHoraFim;
    }

    public void setDataHoraFim(Date dataHoraFim) {
        this.dataHoraFim = dataHoraFim;
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

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
    
    
}
