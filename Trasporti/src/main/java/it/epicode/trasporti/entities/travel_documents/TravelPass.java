package it.epicode.trasporti.entities.travel_documents;

import it.epicode.trasporti.entities.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(name = "travel_pass", schema = "transport")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TravelPass extends TravelDocument{


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "duration")
    int duration;

    public TravelPass(){}

    public TravelPass(Date date, Long place , User user) {
    this.setUser(user);
    super.setIssuingDate(date);
    super.setIssuingPlace(place);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
