import java.util.Random;

public class Main {

    public static int playersByTeam = 20;

    public static void main(String[] args) {
        long initialTime;
        long finalTime;
        Balancer balancer;
        Team[] teams;

        Random random = new Random();

        Player[] players = new Player[playersByTeam];
        for (int i = 0; i < playersByTeam; i++) {
            players[i] = new Player(random.nextInt(2000));
        }

        initialTime = System.currentTimeMillis();

        balancer = new ImprovedBalancer();
        teams = balancer.balance(players);

        finalTime = System.currentTimeMillis();

        System.out.println(teams[0].toString());
        System.out.println(teams[1].toString());
        System.out.println("Difference : " + Math.abs(teams[0].score() - teams[1].score()));
        System.out.println("Exec Time : " + (finalTime - initialTime) + " ms");

        initialTime = System.currentTimeMillis();

        balancer = new BruteBalancer();
        teams = balancer.balance(players);

        finalTime = System.currentTimeMillis();

        System.out.println(teams[0].toString());
        System.out.println(teams[1].toString());
        System.out.println("Difference : " + Math.abs(teams[0].score() - teams[1].score()));
        System.out.println("Exec Time : " + (finalTime - initialTime) + " ms");
    }
}
