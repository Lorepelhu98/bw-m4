package it.epicode.trasporti.entities.tranports;

import it.epicode.trasporti.entities.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "maintenance", schema = "transport")
public class Maintenance extends BaseEntity {

    @ManyToOne
    private Vehicle vehicle;

    @Column(name="maintenance_start",nullable = false)
    private LocalDate start;

    @Column(name="maintenance_end",nullable = true)
    private LocalDate end;

    public Maintenance(){}
    public Maintenance(Vehicle vehicle, LocalDate start) {
        this.vehicle = vehicle;
        this.start = start;
    }

    public Vehicle getTransport() {
        return vehicle;
    }

    public void setTransport(Vehicle vehicle) {
        this.vehicle = vehicle;
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
                "vehicle=" + vehicle +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
