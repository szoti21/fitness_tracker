package hu.unideb.inf.fitnesstracker.data.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="food_name")
    private String foodName;

    @Column(name="kcal")
    private int kcal;

    @Column(name="protein")
    private int protein;

    @Column(name="fat")
    private int fat;

    @Column(name="carbohydrates")
    private int carbohydrates;

    public FoodEntity() {
    }

    public FoodEntity(String foodName, int kcal, int protein, int fat, int carbohydrates) {
        this.foodName = foodName;
        this.kcal = kcal;
        this.protein = protein;
        this.fat = fat;
        this.carbohydrates = carbohydrates;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodEntity that = (FoodEntity) o;
        return Objects.equals(foodName, that.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName);
    }
}
