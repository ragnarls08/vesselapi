package dev.raggi.vesselapi.models.input;

public class VesselPositionInputModel
{
    private VesselInputModel vessel;

    private PositionInputModel position;


    public VesselInputModel getVessel() {
        return vessel;
    }

    public void setVessel(VesselInputModel vessel) {
        this.vessel = vessel;
    }

    public PositionInputModel getPosition() {
        return position;
    }

    public void setPosition(PositionInputModel position) {
        this.position = position;
    }
}
