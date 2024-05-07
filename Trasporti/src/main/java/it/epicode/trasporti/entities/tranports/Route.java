package it.epicode.trasporti.entities.tranports;

import it.epicode.trasporti.entities.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "routes", schema = "transport")
public class Route extends BaseEntity {

    @OneToMany(mappedBy = "route")
    private List<SingleRoute> singleRoute;

    @Column(name = "starting_zone", nullable = false, length = 50)
    private String startingZone;

    @Column(name = "end_of_line", nullable = false, length = 50)
    private String endOfLine;

    @Column(name = "average_time", nullable = false)
    private int avgTime;

    public Route(){}
    public Route(String startingZone, String endOfLine) {
        this.startingZone = startingZone;
        this.endOfLine = endOfLine;
    }

    public String getStartingZone() {
        return startingZone;
    }

    public void setStartingZone(String startingZone) {
        this.startingZone = startingZone;
    }

    public String getEndOfLine() {
        return endOfLine;
    }

    public void setEndOfLine(String endOfLine) {
        this.endOfLine = endOfLine;
    }

    public int getAvgTime() {
        return avgTime;
    }

    public void setAvgTime(int avgTime) {
        this.avgTime = avgTime;
    }

    @Override
    public String toString() {
        return "Route{" +
                "startingZone='" + startingZone + '\'' +
                ", endOfLine='" + endOfLine + '\'' +
                ", avgTime=" + avgTime +
                '}';
    }
}
