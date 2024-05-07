package it.epicode.trasporti.entities.tranports;


import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("bus")
public class Bus extends Transport {


    public Bus(){
        super.setCapacity(70);
    }

}
