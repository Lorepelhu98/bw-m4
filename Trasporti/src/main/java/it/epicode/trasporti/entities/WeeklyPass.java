package it.epicode.trasporti.entities;


import it.epicode.trasporti.entities.constants.TravelDocumentsTables;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
//@DiscriminatorValue(TravelDocumentsTables.Discriminators.TRAVEL_PASS)
public class WeeklyPass extends TravelPass{




    public WeeklyPass(Date date, Long place, User user) {
        super.setDuration(7);
        super.setUser(user);
        super.setIssuingDate(date);
        super.setIssuingPlace(place);
    }


}
