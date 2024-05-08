package it.epicode.trasporti.entities.travel_documents;

import it.epicode.trasporti.entities.constants.TravelDocumentsTables;
import it.epicode.trasporti.entities.tranports.Vehicle;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;


@Entity
//@Table(name = TravelDocumentsTables.Names.TICKETS)
@DiscriminatorValue(TravelDocumentsTables.Discriminators.TICKETS)
public class Ticket extends TravelDocument{


    private boolean valid;

    @Column(name = "validation_time")
    private Date validationTime;

    @ManyToOne
    @JoinColumn(name = "validation_place")
    public Vehicle validationPlace;

    public Ticket() {
    }

    public Ticket(LocalDate issuingDate, Long issuingPlace) {
        super(issuingDate, issuingPlace);
        this.valid = true;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }


    public Date getValidationTime() {
        return validationTime;
    }

    public void setValidationTime(Date validationTime) {
        this.validationTime = validationTime;
    }


    public Vehicle getValidationPlace() {
        return validationPlace;
    }

    public void setValidationPlace(Vehicle validationPlace) {
        this.validationPlace = validationPlace;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "valid=" + valid +
                ", validationTime=" + validationTime +
                ", validationPlace=" + validationPlace +
                '}';
    }
}
