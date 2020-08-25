package dev.raggi.vesselapi.models.result;

import java.util.ArrayList;
import java.util.List;

public class AllPositionsResultModel {
    private List<VesselWithPositionsResultModel> vessels = new ArrayList<>();

    public List<VesselWithPositionsResultModel> getVessels() {
        return vessels;
    }

    public void setVessels(List<VesselWithPositionsResultModel> vessels) {
        this.vessels = vessels;
    }
}
