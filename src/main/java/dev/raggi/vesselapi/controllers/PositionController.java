package dev.raggi.vesselapi.controllers;

import dev.raggi.services.IPositionService;
import dev.raggi.vesselapi.models.input.VesselPositionInputModel;
import dev.raggi.vesselapi.models.result.AllPositionsResultModel;
import dev.raggi.vesselapi.models.result.VesselPositionResultModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PositionController extends ControllerBase {

    private IPositionService _positionService;

    @Autowired
    public PositionController(IPositionService positionService) {
        _positionService = positionService;
    }

    @GetMapping("/getAllPositionsByName")
    public ResponseEntity<AllPositionsResultModel> getAllPositionsByName() {

        AllPositionsResultModel result = null;

        try
        {
            result = _positionService.getAllVesselPositions();
        }
        catch (Exception e)
        {
            return exceptionToResultModel(e);
        }

        return new ResponseEntity<AllPositionsResultModel>(result, null, HttpStatus.OK);
    }

    @PostMapping("/vesselPosition")
    public ResponseEntity<VesselPositionResultModel> position(@RequestBody VesselPositionInputModel data)
    {
        VesselPositionResultModel result = null;

        if(data == null) {
            return nullRequest();
        }

        try
        {
            result = _positionService.addVesselPosition(data);
        }
        catch (Exception e)
        {
            return exceptionToResultModel(e);
        }

        return new ResponseEntity<VesselPositionResultModel>(result, null, HttpStatus.OK);
    }
}

