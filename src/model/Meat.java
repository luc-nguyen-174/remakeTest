package model;

import model.Material;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Meat extends Material{
    private double weight;


    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusDays(7);
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        int daysUntilExpiry = (int) ChronoUnit.DAYS.between(now, getExpiryDate());
        if (daysUntilExpiry <= 5) {
            return getAmount() * 0.7;
        } else {
            return getAmount() * 0.9;
        }
    }

    @Override
    public String toString() {
        return "Meat{" +
                "weight=" + weight +
                "} " + super.toString();
    }
}
