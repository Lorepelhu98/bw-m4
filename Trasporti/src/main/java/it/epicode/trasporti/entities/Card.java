package it.epicode.trasporti.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Card extends BaseEntity{

    @OneToOne
    private User user;

    @Column(name = "renewal_date")
    private LocalDate renewalDate;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    public Card(){}
    public Card(User user) {
        this.user = user;
        this.renewalDate = LocalDate.now();
        this.expirationDate = renewalDate.plusYears(1L);
    }

    @Override
    public String toString() {
        return "Card{" +
                "user=" + user +
                ", renewalDate=" + renewalDate +
                ", expirationDate=" + expirationDate +
                '}';
    }

    public LocalDate getRenewalDate() {
        return renewalDate;
    }

    public void setRenewalDate(LocalDate renewalDate) {
        this.renewalDate = renewalDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}
