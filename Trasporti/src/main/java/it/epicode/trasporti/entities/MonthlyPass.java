package it.epicode.trasporti.entities;


import it.epicode.trasporti.entities.constants.TravelDocumentsTables;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = TravelDocumentsTables.Names.MONTHLY_PASS)
@DiscriminatorValue(TravelDocumentsTables.Discriminators.MONTHLY_PASS)
public class MonthlyPass extends TravelPass{

    public MonthlyPass(User user) {
    super.setDuration(30);
    super.setUser(user);
    }
}
