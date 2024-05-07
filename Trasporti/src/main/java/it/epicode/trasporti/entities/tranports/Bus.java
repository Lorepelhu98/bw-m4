package it.epicode.trasporti.entities.tranports;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bus")
public class Bus extends Vehicle {



    public Bus(){
        super.setCapacity(70);
    }

}
