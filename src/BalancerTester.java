/**
 * Simple way to execute and print the result of a balancer
 */
public class BalancerTester {

    public static void test(Balancer balancer, Player[] players) {
        long initialTime = System.currentTimeMillis();

        Team[] teams = balancer.balance(players);

        long finalTime = System.currentTimeMillis();

        System.out.println("Team 1 --> " + teams[0].toString());
        System.out.println("Team 1 --> " + teams[1].toString());
        System.out.println("Difference : " + Math.abs(teams[0].getScore() - teams[1].getScore()));
        System.out.println("Exec Time : " + (finalTime - initialTime) + " ms \n");
    }

}
