package it.epicode.trasporti.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "travel_document", schema = "transport")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "item_type", discriminatorType = DiscriminatorType.STRING)
public abstract class TravelDocument extends BaseEntity{

    @Column(name = "issuing_date")
    @Temporal(TemporalType.DATE)
    private Date issuingDate;

    @Column(name = "issuing_place")
    @Temporal(TemporalType.DATE)
    private Long issuingPlace;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public TravelDocument(){}
    public TravelDocument(Date issuingDate, Long issuingPlace) {
        this.issuingDate = issuingDate;
        this.issuingPlace = issuingPlace;
    }

    public Date getIssuingDate() {
        return issuingDate;
    }

    public Long getIssuingPlace() {
        return issuingPlace;
    }

    public User getUser() {
        return user;
    }

}
