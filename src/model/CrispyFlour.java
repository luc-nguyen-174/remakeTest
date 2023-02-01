package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CrispyFlour extends Material{
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return getCost() * quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return getManufacturingDate().plusYears(1);
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        int monthsUntilExpiry = (int) ChronoUnit.MONTHS.between(now, getExpiryDate());
        if (monthsUntilExpiry <= 2) {
            return getAmount() * 0.6;
        } else if (monthsUntilExpiry <= 4) {
            return getAmount() * 0.8;
        } else {
            return getAmount() * 0.95;
        }
    }

    @Override
    public String toString() {
        return "CrispyFlour{" +
                "quantity=" + quantity +
                "} " + super.toString();
    }
}
