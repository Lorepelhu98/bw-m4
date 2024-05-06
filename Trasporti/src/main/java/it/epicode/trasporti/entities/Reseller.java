package it.epicode.trasporti.entities;


import it.epicode.trasporti.entities.constants.StoreTables;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = StoreTables.Names.RESELLERS)
@DiscriminatorValue(StoreTables.Discriminators.RESELLERS)
public class Reseller extends Store{

    public Reseller() {
    }
}
