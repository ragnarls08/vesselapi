package dev.raggi.vesselapi.models.result;

public class VesselPositionResultModel
{
    private VesselResultModel vessel;

    private PositionResultModel position;


    public VesselResultModel getVessel() {
        return vessel;
    }

    public void setVessel(VesselResultModel vessel) {
        this.vessel = vessel;
    }

    public PositionResultModel getPosition() {
        return position;
    }

    public void setPosition(PositionResultModel position) {
        this.position = position;
    }
}
