package it.epicode.trasporti.entities.stores;


import it.epicode.trasporti.entities.constants.StoreTables;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = StoreTables.Names.TICKET_MACHINES)
@DiscriminatorValue(StoreTables.Discriminators.TICKET_MACHINES)
public class TicketMachine extends Store{

    //Attributo che indica se il distributore è in servizio oppure no
    public boolean status;

    public TicketMachine(){}
    public TicketMachine(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
