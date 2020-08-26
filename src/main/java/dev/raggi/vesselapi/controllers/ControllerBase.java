package dev.raggi.vesselapi.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

public class ControllerBase {

    public ResponseEntity exceptionToResultModel(Exception e) {
        if(e instanceof HttpClientErrorException) {
            HttpClientErrorException ex = (HttpClientErrorException)e;

            return new ResponseEntity(ex.getMessage(), null, ex.getStatusCode());
        }
        return new ResponseEntity("", null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public static ResponseEntity nullRequest() {
        return new ResponseEntity("Input cannot be null", null, HttpStatus.BAD_REQUEST);
    }
}
