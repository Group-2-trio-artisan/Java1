package slot9;

public class PlayerIncome extends Player implements Tax {
    private double income;

    public PlayerIncome(String name, double income) {
        super(name);
        this.income = income;
    }

    @Override
    void displayDetails() {
        System.out.println("Player Name: " + super.getName());
        System.out.println("Player Income: $" + income);
        System.out.println("Tax Paid: $" + calculateTax(income));
    }
    @Override
    public double calculateTax(double income) {
        return income * TAX_PERCENT;
    }
}
