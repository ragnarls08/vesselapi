package dev.raggi.vesselapi.models.result;

import java.util.List;

public class VesselWithPositionsResultModel {
    private String name;
    private String country;
    private List<PositionResultModel> positions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<PositionResultModel> getPositions() {
        return positions;
    }

    public void setPositions(List<PositionResultModel> positions) {
        this.positions = positions;
    }
}
