import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Meat extends Material implements Discount {
    private double weight;
    private LocalDate expiryDate;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
        this.expiryDate = manufacturingDate.plusDays(7);
    }

    @Override
    public double getAmount() {
        return getCost() * weight;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        int daysUntilExpiry = (int) ChronoUnit.DAYS.between(now, expiryDate);
        if (daysUntilExpiry <= 5) {
            return getAmount() * 0.7;
        } else {
            return getAmount() * 0.9;
        }
    }
}
