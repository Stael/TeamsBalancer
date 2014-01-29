import java.util.Random;

public class Main {

    public static int playersByTeam = 20;

    public static void main(String[] args) {
        Random random = new Random();

        Player[] players = new Player[playersByTeam];
        for (int i = 0; i < playersByTeam; i++) {
            players[i] = new Player(random.nextInt(2000));
        }

        BalancerTester.test(new ImprovedBalancer(), players);
        BalancerTester.test(new BruteBalancer(), players);
    }
}
