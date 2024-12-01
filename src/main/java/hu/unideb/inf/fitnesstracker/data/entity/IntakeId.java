package hu.unideb.inf.fitnesstracker.data.entity;

import java.util.Date;

public class IntakeId {
    private Date date;
    private int userId;

    public IntakeId() {
    }

    public IntakeId(Date date, int userId) {
        this.date = date;
        this.userId = userId;
    }
}
