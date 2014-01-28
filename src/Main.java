import java.util.Random;

public class Main {

    public static int playersByTeam = 10;

    public static void main(String[] args) {

        Random random = new Random();

        Player[] players = new Player[playersByTeam];
        for(int i = 0; i < playersByTeam; i++) {
            players[i] = new Player(random.nextInt(2000));
        }

        long initialTime = System.currentTimeMillis();

        Balancer balancer = new ImprovedBalancer();
        Team[] teams = balancer.balance(players);

        long finalTime = System.currentTimeMillis();

        System.out.println(teams[0].toString());
        System.out.println(teams[1].toString());
        System.out.println("Exec Time : " + (finalTime - initialTime) + " ms");
    }
}
