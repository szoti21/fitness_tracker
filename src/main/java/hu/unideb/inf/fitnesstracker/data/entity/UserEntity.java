package hu.unideb.inf.fitnesstracker.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="email_address")
    private String emailAddress;
    @Column(name="address")
    private String address;
    @Column(name="phone")
    private String phone;
    @Column(name="role_id")
    private int roleId;


    public UserEntity() {
    }

    public UserEntity(int id, String name, String emailAddress, String address, String phone, int roleId) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.address = address;
        this.phone = phone;
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
