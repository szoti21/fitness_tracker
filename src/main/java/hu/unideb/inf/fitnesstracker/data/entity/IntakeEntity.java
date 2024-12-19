package hu.unideb.inf.fitnesstracker.data.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "intake")
@IdClass(IntakeId.class)
public class IntakeEntity {
    @Id
    @Column(name="date")
    private Date date;
    @Id
    @Column(name="user_id")
    private int userId;
    @ManyToOne()
    @JoinColumn(name = "food_id", referencedColumnName = "id")
    private FoodEntity food;
    @Column(name="quantity")
    private int quantity;

    public IntakeEntity() {
    }

    public IntakeEntity(Date date, int userId, FoodEntity food, int quantity) {
        this.date = date;
        this.userId = userId;
        this.food = food;
        this.quantity = quantity;
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

    public FoodEntity getFood() {
        return food;
    }

    public void setFood(FoodEntity food) {
        this.food = food;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
