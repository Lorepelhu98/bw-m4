package it.epicode.trasporti.entities;


import it.epicode.trasporti.entities.constants.TravelDocumentsTables;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@DiscriminatorValue(TravelDocumentsTables.Discriminators.TRAVEL_PASS)
public class MonthlyPass extends TravelPass{



    public MonthlyPass(Date date, Long place, Card card) {
    super.setDuration(30);
    super.setCard(card);
    super.setIssuingDate(date);
    super.setIssuingPlace(place);
    }


}
