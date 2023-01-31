import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class CrispyFlour extends Material implements Discount {
    private int quantity;
    private LocalDate expiryDate;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
        this.expiryDate = manufacturingDate.plusYears(1);
    }

    @Override
    public double getAmount() {
        return getCost() * quantity;
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public double getRealMoney() {
        LocalDate now = LocalDate.now();
        int monthsUntilExpiry = (int) ChronoUnit.MONTHS.between(now, expiryDate);
        if (monthsUntilExpiry <= 2) {
            return getAmount() * 0.6;
        } else if (monthsUntilExpiry <= 4) {
            return getAmount() * 0.8;
        } else {
            return getAmount() * 0.95;
        }
    }
}
