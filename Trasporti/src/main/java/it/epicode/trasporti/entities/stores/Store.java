package it.epicode.trasporti.entities.stores;

import it.epicode.trasporti.entities.BaseEntity;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Store extends BaseEntity {

    public Store() {
    }
}
