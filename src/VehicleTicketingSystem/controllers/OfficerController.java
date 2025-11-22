package controllers;

import dtos.reponses.RegisterOfficerResponse;
import dtos.requests.RegisterOfficerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import services.IOfficerServices;

@RestController
public class OfficerController {

    @Autowired
    private IOfficerServices officerServices;

    @PostMapping("/officers/register")
    public RegisterOfficerResponse officerResponse(@RequestBody RegisterOfficerRequest request){
        return officerServices.registerOfficer(request);
    }
}
