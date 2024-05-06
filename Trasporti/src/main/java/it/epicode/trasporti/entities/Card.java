package it.epicode.trasporti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Card extends BaseEntity{

    @OneToOne
    private User user;

    @Column(name = "renewal_date")
    @Temporal(TemporalType.DATE)
    private LocalDate renewalDate;

    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private LocalDate expirationDate;

    public Card(){}
    public Card(User user) {
        this.user = user;
        this.renewalDate = LocalDate.now();
        this.expirationDate = renewalDate.plusYears(1L);
    }
}
