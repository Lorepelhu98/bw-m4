package it.epicode.trasporti.entities.tranports;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("tram")
public class Tram extends Transport{

    public Tram() {
        super.setCapacity(170);
    }
}
