package dev.raggi.services;

import dev.raggi.models.Position;
import dev.raggi.models.Vessel;
import dev.raggi.repositories.IPositionRepository;
import dev.raggi.repositories.IVesselRepository;
import dev.raggi.vesselapi.models.input.VesselPositionInputModel;
import dev.raggi.vesselapi.models.result.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static dev.raggi.helpers.StringHelpers.IsNullOrEmpty;
import static dev.raggi.helpers.UnitHelpers.KnotsToMetersPerSecond;
import static dev.raggi.helpers.GPSHelpers.DecimalDegreeToRadians;

@Component
public class PositionService implements  IPositionService {

    @Autowired
    private IVesselRepository _vesselRepository;
    @Autowired
    private IPositionRepository _positionRepository;

    public PositionService() { }

    @Override
    public VesselPositionResultModel AddVesselPosition(VesselPositionInputModel model) {

        if(IsNullOrEmpty(model.getVessel().getName())) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Vessel name is null or empty");
        }
        if(IsNullOrEmpty(model.getVessel().getCountry())) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Vessel country is null or empty");
        }

        if(model.getPosition().getPositionDate() == null) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Position date cannot be null");
        }
        if(model.getPosition().getLatDegree() < -90 || model.getPosition().getLatDegree() > 90) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Latitude degree value has to be within the range -90 to 90");
        }
        if(model.getPosition().getLongDegree() < -180 || model.getPosition().getLongDegree() > 180) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Longitude degree value has to be within the range -180 to 180");
        }

        Vessel vessel = _vesselRepository.findByName(model.getVessel().getName());

        if(vessel == null)
        {
            vessel = new Vessel();
            vessel.setName(model.getVessel().getName());
            vessel.setCountry(model.getVessel().getCountry());
            _vesselRepository.save(vessel);
        }

        Position position = new Position();
        position.setReceivedDate(LocalDateTime.now());
        position.setPositionDate(model.getPosition().getPositionDate());
        position.setLatitudeDecimal(model.getPosition().getLatDegree());
        position.setLongitudeDecimal(model.getPosition().getLongDegree());
        position.setSpeed(KnotsToMetersPerSecond(model.getPosition().getKnots()));
        _positionRepository.save(position);
        vessel.getPositions().add(position);
        _vesselRepository.save(vessel);

        VesselResultModel vesselResultModel = new VesselResultModel();
        vesselResultModel.setName(vessel.getName());

        PositionResultModel positionResultModel = new PositionResultModel();
        positionResultModel.setDate(position.getPositionDate());
        positionResultModel.setReceivedDate(position.getReceivedDate());
        positionResultModel.setLatitude(DecimalDegreeToRadians(position.getLatitudeDecimal()));
        positionResultModel.setLongitude(DecimalDegreeToRadians(position.getLongitudeDecimal()));
        positionResultModel.setSpeedMetersPerSecond(position.getSpeed());

        VesselPositionResultModel resultModel = new VesselPositionResultModel();
        resultModel.setVessel(vesselResultModel);
        resultModel.setPosition(positionResultModel);

        return resultModel;
    }

    @Override
    public AllPositionsResultModel GetAllVesselPositions() {
        List<Vessel> vessels = _vesselRepository.findAll();
        AllPositionsResultModel result = new AllPositionsResultModel();


        for(Vessel v : vessels) {
            VesselWithPositionsResultModel vp = new VesselWithPositionsResultModel();
            vp.setName(v.getName());
            vp.setCountry(v.getCountry());

            vp.setPositions(PositionListToPositionResultModelList(v.getPositions()));

            result.getVessels().add(vp);
        }

        return result;
    }

    private List<PositionResultModel> PositionListToPositionResultModelList(List<Position> ps) {
        List<PositionResultModel> result = new ArrayList<>();

        for(Position p : ps) {
            PositionResultModel newP = new PositionResultModel();

            newP.setSpeedMetersPerSecond(p.getSpeed());
            newP.setLatitude(p.getLatitudeDecimal());
            newP.setLongitude(p.getLongitudeDecimal());
            newP.setDate(p.getPositionDate());
            newP.setReceivedDate(p.getReceivedDate());

            result.add(newP);
        }
        return result;
    }
}
