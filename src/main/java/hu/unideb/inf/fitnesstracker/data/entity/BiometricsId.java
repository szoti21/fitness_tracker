package hu.unideb.inf.fitnesstracker.data.entity;

import java.util.Date;

public class BiometricsId {
    private Date date;
    private int userId;

    public BiometricsId() {
    }

    public BiometricsId(Date date, int userId) {
        this.date = date;
        this.userId = userId;
    }
}
