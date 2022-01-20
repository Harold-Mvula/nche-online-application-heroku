package com.example.NCHEOnlineApplication.credentials;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
@RequestMapping(path = "api/v1/credentials")
public class CredentialsController {

    private final CredentialsService credentialsService;

    @Autowired
    public CredentialsController(CredentialsService credentialsService) {
        this.credentialsService = credentialsService;
    }

    ConcurrentMap<String, Credentials> credentials = new ConcurrentHashMap<>();

    @GetMapping("/AllStudentsCredentials")
    @ApiOperation("show all the students credentials")
    public List<Credentials> getCredentials(){
       return credentialsService.getCredentials();
    }

    @PostMapping("/Create")
    public void registerNewCredentials(@RequestBody Credentials credentials){
        credentialsService.addNewCredentials(credentials);
    }

    @DeleteMapping(path = "{credentialsStudentId}")
    public void deleteCredentials(@PathVariable("credentialsStudentId") Long credentialsStudentId){
        credentialsService.deleteCredentials(credentialsStudentId);
    }

    @PutMapping(path = "{credentialsStudentId}")

    public void updateCredentials(
            @PathVariable("credentialsStudentId") Long credentialsStudentId,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String surName,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String birthday,
            @RequestParam(required = false) String password){
        credentialsService.updateCredentials(credentialsStudentId, firstName, surName, email, birthday, password);
    }
}
