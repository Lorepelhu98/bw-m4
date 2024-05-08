package it.epicode.trasporti.entities.travel_documents;

import it.epicode.trasporti.entities.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
//@Table(name = "travel_pass", schema = "transport")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class TravelPass extends TravelDocument{


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "duration")
    private int duration;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    public TravelPass(){}

   // public TravelPass(LocalDate date, Long place , User user) {
   // this.setUser(user);
   // super.setIssuingPlace(place);
   // super.setIssuingDate(date);
   // this.expirationDate = date.plusDays(duration);
   // }



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

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
