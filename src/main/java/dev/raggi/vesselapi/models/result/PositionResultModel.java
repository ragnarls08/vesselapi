package dev.raggi.vesselapi.models.result;

import java.time.LocalDateTime;

public class PositionResultModel
{
    private LocalDateTime date;

    private LocalDateTime receivedDate;

    private double latitude;

    private double longitude;

    private double speedMetersPerSecond;


    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate = receivedDate;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getSpeedMetersPerSecond() {
        return speedMetersPerSecond;
    }

    public void setSpeedMetersPerSecond(double speedMetersPerSecond) {
        this.speedMetersPerSecond = speedMetersPerSecond;
    }
}
