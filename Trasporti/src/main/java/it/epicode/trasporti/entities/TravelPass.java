package it.epicode.trasporti.entities;

import it.epicode.trasporti.entities.constants.TravelDocumentsTables;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "travel_pass", schema = "transport")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TravelPass extends TravelDocument{


    @ManyToOne
    @JoinColumn(name = "card_id")
    private Card card;

    @Column(name = "duration")
    int duration;

    public TravelPass(){}

    public TravelPass(Date date, Long place , Card card) {
    this.setCard(card);
    super.setIssuingDate(date);
    super.setIssuingPlace(place);
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
