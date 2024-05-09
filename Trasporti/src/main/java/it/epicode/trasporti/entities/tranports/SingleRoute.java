package it.epicode.trasporti.entities.tranports;

import it.epicode.trasporti.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "single_routes", schema = "transport")
public class SingleRoute extends BaseEntity {

@ManyToOne
private Vehicle vehicle;

@ManyToOne
private Route route;


@Column(name = "travel_time")
private int travelTime;


    public SingleRoute(){}
    public SingleRoute(Vehicle vehicle, Route route, int travelTime) {
        this.vehicle = vehicle;
        this.route = route;
        this.travelTime = travelTime;


    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public it.epicode.trasporti.entities.tranports.Route getRoute() {
        return route;
    }

    public void setRoute(it.epicode.trasporti.entities.tranports.Route route) {
        this.route = route;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    @Override
    public String toString() {
        return "Single route{" +
                " Vehicle = " + vehicle.getId() +
                ", Starting zone = " + route.getStartingZone() +
                ", Last stop = " + route.getEndOfLine() +
                ", Travel time = " + travelTime + " minutes" +
                " }";
    }
}
