package com.example.NCHEOnlineApplication.credentials;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table


public class Credentials {
    @Id
    @SequenceGenerator(
             name = "credentials_sequence",
            sequenceName = "credentials_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "credentials_sequence"
    )
    private Long studentId;
    private String firstName;
    private  String surname;
    private String email;
    private LocalDate birthday;
    private String password;

   public Credentials(){}
    public Credentials(Long studentId,
                       String firstName,
                       String surname,
                       String email,
                       LocalDate birthday,
                       String password) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
    }

    public Credentials(String firstName,
                       String surname,
                       String email,
                       LocalDate birthday,
                       String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Credentials{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                '}';
    }
}
