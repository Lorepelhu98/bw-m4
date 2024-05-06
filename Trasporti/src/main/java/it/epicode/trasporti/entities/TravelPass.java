package it.epicode.trasporti.entities;

public abstract class TravelPass extends TravelDocument{

        private User user;

    private int duration;

    public TravelPass(){}

    public TravelPass(User user) {
    this.user = user;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
