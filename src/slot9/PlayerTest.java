package slot9;

public class PlayerTest {
    public static void main(String[] args) {
        PlayerIncome playerIncome = new PlayerIncome("John", 5000);
        TournamentIncome tournamentIncome = new TournamentIncome("Michael", "A", 1000);

        playerIncome.displayDetails();
        System.out.println();
        tournamentIncome.displayDetails();
    }
}
