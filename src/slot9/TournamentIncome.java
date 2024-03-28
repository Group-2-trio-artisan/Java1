package slot9;

public class TournamentIncome extends Player implements GradeBonus{
    private String grade;
    private double rate;
    public TournamentIncome(String name, String grade, double rate) {
        super(name);
        this.grade = grade;
        this.rate = rate;
    }

    @Override
    void displayDetails() {
        double income = calculateIncome();
        double bonus = calculateGradeBonus(grade);
        System.out.println("Player Name: " + super.getName());
        System.out.println("Player Grade: " + grade);
        System.out.println("Rate per match: $" + rate);
        System.out.println("Income from tournament: $" + income);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Income: $" + (income + bonus));
    }

    private double calculateIncome() {
        return rate * 10;
    }

    @Override
    public double calculateGradeBonus(String grade) {
        if (grade.equals("A")) {
            return calculateIncome() * GradeBonus.GRADE_BONUS_PERCENT;
        } else if (grade.equals("B")) {
            return calculateIncome() * (GradeBonus.GRADE_BONUS_PERCENT / 2);
        } else {
            return 0;
        }
    }
}
