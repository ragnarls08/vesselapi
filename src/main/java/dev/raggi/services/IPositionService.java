package dev.raggi.services;

import dev.raggi.vesselapi.models.input.VesselPositionInputModel;
import dev.raggi.vesselapi.models.result.AllPositionsResultModel;
import dev.raggi.vesselapi.models.result.VesselPositionResultModel;
import org.springframework.stereotype.Component;

@Component
public interface IPositionService {
    VesselPositionResultModel AddVesselPosition(VesselPositionInputModel model);
    AllPositionsResultModel GetAllVesselPositions();
}
