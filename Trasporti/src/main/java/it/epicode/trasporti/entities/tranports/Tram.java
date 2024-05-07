package it.epicode.trasporti.entities.tranports;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("tram")
public class Tram extends Vehicle {

    public Tram() {
        super.setCapacity(170);
    }
}
