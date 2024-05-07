package it.epicode.trasporti.entities;

import it.epicode.trasporti.entities.constants.TravelDocumentsTables;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;


@Entity
//@Table(name = TravelDocumentsTables.Names.TICKETS)
@DiscriminatorValue(TravelDocumentsTables.Discriminators.TICKETS)
public class Ticket extends TravelDocument{

    private boolean validation;

    public Ticket() {
    }

    public Ticket(Date issuingDate, Long issuingPlace) {
        super(issuingDate, issuingPlace);
        this.validation = false;
    }

    public boolean isValidation() {
        return validation;
    }

    public void setValidation(boolean validation) {
        this.validation = validation;
    }
}
