/**
 * Simple way to execute and print the result of a balancer
 */
public class BalancerTester {

	public static void test(Balancer balancer, Player[] players) {
		final Timer timer = new Timer().start();
		Team[] teams = balancer.balance(players);
		timer.stop();

		System.out.println("Team 1 --> " + teams[0].toString());
		System.out.println("Team 2 --> " + teams[1].toString());
		System.out.println("Difference : " + Math.abs(teams[0].getScore() - teams[1].getScore()));
		System.out.println("Exec Time : " + timer.diffString() + "\n");
	}

}
