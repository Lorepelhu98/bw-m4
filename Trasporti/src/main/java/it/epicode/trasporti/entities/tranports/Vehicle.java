package it.epicode.trasporti.entities.tranports;

import it.epicode.trasporti.entities.BaseEntity;
import it.epicode.trasporti.entities.travel_documents.Ticket;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "transport_type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle extends BaseEntity {

    @OneToMany(mappedBy = "validationPlace")
    private List<Ticket> ticket;

    @OneToMany(mappedBy = "vehicle")
    private List<Maintenance> maintenance;

    @OneToMany(mappedBy = "vehicle")
    private List<SingleRoute> singleRoute;

    private int capacity;

    public Vehicle(){}

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
