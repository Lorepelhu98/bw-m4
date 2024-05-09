package it.epicode.trasporti.entities.travel_documents;


import it.epicode.trasporti.entities.User;
import it.epicode.trasporti.entities.constants.TravelDocumentsTables;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDate;
import java.util.Date;

@Entity
@DiscriminatorValue(TravelDocumentsTables.Discriminators.MONTHLY_PASS)
public class MonthlyPass extends TravelPass{

    public MonthlyPass(LocalDate date, Long place, User user) {
        super.setDuration(30);
        super.setUser(user);
        super.setIssuingDate(date);
        super.setIssuingPlace(place);
        super.setExpirationDate(date.plusDays(super.getDuration()));
    }

    @Override
    public String toString(){
        return "Monthly pass{" +
                " Duration = " + super.getDuration() + " days" +
                ", Issuing date = " + super.getIssuingDate() +
                ", Expiration date = " + super.getExpirationDate() +
                ", Issuing place = " + super.getIssuingPlace() +
                ", " + super.getUser() +
                " }";
    }

}
