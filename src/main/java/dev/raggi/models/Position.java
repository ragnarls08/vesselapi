package dev.raggi.models;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private LocalDateTime positionDate;
    private LocalDateTime receivedDate;
    private double latitudeDecimal;
    private double longitudeDecimal;
    private double speed;

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public LocalDateTime getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(LocalDateTime positionDate) {
        this.positionDate = positionDate;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }

    public double getLatitudeDecimal() {
        return latitudeDecimal;
    }

    public void setLatitudeDecimal(double latitudeDecimal) {
        this.latitudeDecimal = latitudeDecimal;
    }

    public double getLongitudeDecimal() {
        return longitudeDecimal;
    }

    public void setLongitudeDecimal(double longitudeDecimal) {
        this.longitudeDecimal = longitudeDecimal;
    }
}
