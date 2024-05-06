package it.epicode.trasporti.entities;


import it.epicode.trasporti.entities.constants.TravelDocumentsTables;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = TravelDocumentsTables.Names.WEEKLY_PASS)
@DiscriminatorValue(TravelDocumentsTables.Discriminators.WEEKLY_PASS)
public class WeeklyPass extends TravelPass{

    public WeeklyPass(User user) {
        super.setDuration(7);
        super.setUser(user);
    }
}
