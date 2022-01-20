package com.example.NCHEOnlineApplication.credentials;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CredentialsService {

    private final CredentialsRepository credentialsRepository;

    @Autowired
    public CredentialsService(CredentialsRepository credentialsRepository) {
        this.credentialsRepository = credentialsRepository;
    }

    public List<Credentials> getCredentials() {
        return credentialsRepository.findAll();
    }


    public void addNewCredentials(Credentials credentials) {

        Optional<Credentials> credentialsOptional = credentialsRepository.findCredentialsByEmail(credentials.getEmail());
        if(credentialsOptional.isPresent()){
       throw new IllegalStateException("email already used");
    }
        credentialsRepository.save(credentials);
}

    public void deleteCredentials(Long credentialsStudentId) {
        boolean exists = credentialsRepository.existsById(credentialsStudentId);
        if(!exists){
            throw new IllegalStateException("Credentials with studentId " + credentialsStudentId + "doesn't exist");
        }
        credentialsRepository.deleteById(credentialsStudentId);
    }

    @Transactional
    public void updateCredentials(Long credentialsStudentId, String firstName, String surName, String email, String birthday, String password) {

        Credentials credentials = credentialsRepository.findById(credentialsStudentId)
                .orElseThrow(() -> new IllegalStateException(
                        "credentials with studentId " + credentialsStudentId + "does not exist"));

                        if(firstName != null && firstName.length() > 0 &&
                                !Objects.equals(credentials.getFirstName(), firstName)){
                            credentials.setFirstName(firstName);
                        }

        if(surName != null && surName.length() > 0 &&
                !Objects.equals(credentials.getSurname(), surName)){
            credentials.setSurname(surName);
        }

        if(email != null && email.length() > 0 &&
                !Objects.equals(credentials.getEmail(), email)){
            Optional<Credentials> credentialsOptional = credentialsRepository.findCredentialsByEmail(email);

            if(credentialsOptional.isPresent()){
                throw new IllegalStateException("Email already used");
            }
            credentials.setEmail(email);
        }

        if(birthday != null && birthday.length() > 0 &&
                !Objects.equals(credentials.getBirthday(), birthday)){
            credentials.setBirthday(LocalDate.parse(birthday));
        }

        if(password != null && password.length() > 0 &&
                !Objects.equals(credentials.getPassword(), password)){
            credentials.setPassword(password);
        }
    }
}
