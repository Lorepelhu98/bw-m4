package it.epicode.trasporti.entities.travel_documents;

import it.epicode.trasporti.entities.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "travel_document", schema = "transport")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type", discriminatorType = DiscriminatorType.STRING)
public abstract class TravelDocument extends BaseEntity {

    @Column(name = "issuing_date")
    private LocalDate issuingDate;

    @Column(name = "issuing_place")
    private Long issuingPlace;




    public TravelDocument(){}
    public TravelDocument(LocalDate issuingDate, Long issuingPlace) {
        this.issuingDate = issuingDate;
        this.issuingPlace = issuingPlace;
    }

    public LocalDate getIssuingDate() {
        return issuingDate;
    }

    public Long getIssuingPlace() {
        return issuingPlace;
    }



    public void setIssuingDate(LocalDate issuingDate) {
        this.issuingDate = issuingDate;
    }

    public void setIssuingPlace(Long issuingPlace) {
        this.issuingPlace = issuingPlace;
    }

}
