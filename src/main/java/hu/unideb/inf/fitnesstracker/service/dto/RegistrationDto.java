package hu.unideb.inf.fitnesstracker.service.dto;

import java.util.Date;
import java.util.Objects;

public class RegistrationDto {

    private String name;
    private String emailAddress;
    private String password;
    private Date birthDate;
    private String phone;

    public RegistrationDto() {
    }

    public RegistrationDto(String name, String emailAddress, String password, Date birthDate, String phone) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistrationDto that = (RegistrationDto) o;
        return Objects.equals(emailAddress, that.emailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emailAddress);
    }
}