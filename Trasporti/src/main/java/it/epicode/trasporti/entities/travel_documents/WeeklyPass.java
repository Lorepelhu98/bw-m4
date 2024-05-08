package it.epicode.trasporti.entities.travel_documents;


import it.epicode.trasporti.entities.User;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Date;

@Entity
//@DiscriminatorValue(TravelDocumentsTables.Discriminators.TRAVEL_PASS)
public class WeeklyPass extends TravelPass{




    public WeeklyPass(LocalDate date, Long place, User user) {
        super.setDuration(7);
        super.setUser(user);
        super.setIssuingDate(date);
        super.setIssuingPlace(place);
        super.setExpirationDate(date.plusDays(super.getDuration()));
    }


}
