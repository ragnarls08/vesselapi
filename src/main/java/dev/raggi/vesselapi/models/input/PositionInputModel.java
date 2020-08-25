package dev.raggi.vesselapi.models.input;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PositionInputModel
{
    @JsonProperty("date")
    private LocalDateTime positionDate;

    @JsonProperty("latitude")
    private int latDegree;

    @JsonProperty("longitude")
    private int longDegree;

    @JsonProperty("speed")
    private int knots;


    public LocalDateTime getPositionDate() {
        return positionDate;
    }

    public void setPositionDate(LocalDateTime positionDate) {
        this.positionDate = positionDate;
    }

    public int getLatDegree() {
        return latDegree;
    }

    public void setLatDegree(int latDegree) {
        this.latDegree = latDegree;
    }

    public int getLongDegree() {
        return longDegree;
    }

    public void setLongDegree(int longDegree) {
        this.longDegree = longDegree;
    }

    public int getKnots() {
        return knots;
    }

    public void setKnots(int knots) {
        this.knots = knots;
    }
}
