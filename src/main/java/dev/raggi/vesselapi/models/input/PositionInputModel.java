package dev.raggi.vesselapi.models.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PositionInputModel
{
    @JsonProperty("date")
    private LocalDateTime positionDate;

    @JsonProperty("latitude")
    private double latDegree;

    @JsonProperty("longitude")
    private double longDegree;

    @JsonProperty("speed")
    private double knots;

    public LocalDateTime getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(LocalDateTime positionDate) {
        this.positionDate = positionDate;
    }

    public double getLatDegree() {
        return latDegree;
    }

    public void setLatDegree(double latDegree) {
        this.latDegree = latDegree;
    }

    public double getLongDegree() {
        return longDegree;
    }

    public void setLongDegree(double longDegree) {
        this.longDegree = longDegree;
    }

    public double getKnots() {
        return knots;
    }

    public void setKnots(double knots) {
        this.knots = knots;
    }
}
