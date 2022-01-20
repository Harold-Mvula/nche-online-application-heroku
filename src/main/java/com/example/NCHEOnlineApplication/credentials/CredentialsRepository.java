package com.example.NCHEOnlineApplication.credentials;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CredentialsRepository extends JpaRepository <Credentials, Long> {

    @Query("SELECT s FROM Credentials s WHERE s.email = ?1 ")
    Optional<Credentials> findCredentialsByEmail(String email);

}

