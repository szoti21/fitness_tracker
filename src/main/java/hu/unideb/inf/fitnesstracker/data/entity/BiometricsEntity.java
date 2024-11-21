package hu.unideb.inf.fitnesstracker.data.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "biometrics")
@IdClass(BiometricsId.class)
public class BiometricsEntity {

    @Id
    @Column(name = "date")
    private Date date;
    @Id
    @Column(name = "user_id")
    private int userId;

    @Column(name="height")
    private int height;

    @Column(name="weight")
    private int weight;

    @Column(name="body_fat")
    private int bodyFat;

    public BiometricsEntity() {
    }

    public BiometricsEntity(Date date, int userId, int height, int weight, int bodyFat) {
        this.date = date;
        this.userId = userId;
        this.height = height;
        this.weight = weight;
        this.bodyFat = bodyFat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(int bodyFat) {
        this.bodyFat = bodyFat;
    }
}
