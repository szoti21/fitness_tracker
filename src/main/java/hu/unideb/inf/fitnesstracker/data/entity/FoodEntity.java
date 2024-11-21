package hu.unideb.inf.fitnesstracker.data.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "food")
public class FoodEntity {

    @Id
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
}
