package it.epicode.trasporti.entities.tranports;

import it.epicode.trasporti.entities.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Maintenance extends BaseEntity {

    @OneToOne
    private Transport transport;

    @Temporal(TemporalType.DATE)
    private LocalDate start;

    @Temporal(TemporalType.DATE)
    private LocalDate end;


    public Maintenance(Transport transport, LocalDate start) {
        this.transport = transport;
        this.start = start;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Maintenance{" +
                "transport=" + transport +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
