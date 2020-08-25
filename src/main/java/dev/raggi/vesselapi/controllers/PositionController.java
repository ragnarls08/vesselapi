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
    public ResponseEntity<AllPositionsResultModel> GetAllPositionsByName() {

        AllPositionsResultModel result = null;

        try
        {
            result = _positionService.GetAllVesselPositions();
        }
        catch (Exception e)
        {
            return ExceptionToResultModel(e);
        }

        return new ResponseEntity<AllPositionsResultModel>(result, null, HttpStatus.OK);
    }

    @PostMapping("/vesselPosition")
    public ResponseEntity<VesselPositionResultModel> Position(@RequestBody VesselPositionInputModel data)
    {
        VesselPositionResultModel result = null;

        if(data == null) {
            return NullRequest();
        }

        try
        {
            result = _positionService.AddVesselPosition(data);
        }
        catch (Exception e)
        {
            return ExceptionToResultModel(e);
        }

        return new ResponseEntity<VesselPositionResultModel>(result, null, HttpStatus.OK);
    }
}

