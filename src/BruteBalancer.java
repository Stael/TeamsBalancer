/**
 * Basic implementation of a Teams Balancer
 * Simply test all cases
 * <p/>
 * Improvements : find an other way to attribute a player to a team
 * instead of using a binaryWord and check if we have the right number of players
 */
public class BruteBalancer implements Balancer {

	private final Class binaryWordClazz;

	public BruteBalancer(final Class binaryWordClazz) {
		this.binaryWordClazz = binaryWordClazz;
	}

	@Override
	public Team[] balance(Player[] players) {
		int playersByTeam = players.length / 2;

		Team team1 = new Team(playersByTeam);
		Team team2 = new Team(playersByTeam);

		Team t1;
		Team t2;

		int playersInT1;
		int playersInT2;

		int difference = 0;
		for (Player player : players) {
			difference += player.getScore();
		}

		final BinaryWordInterface binaryWord;
		if (binaryWordClazz == BinaryWord.class) {
			binaryWord = new BinaryWord(players.length);
		} else {
			binaryWord = new RealBinaryWord();
		}
		do {
			// In order to have the same number of players in both teams
			if (binaryWord.bitsAtTrue() == playersByTeam) {
				t1 = new Team(playersByTeam);
				t2 = new Team(playersByTeam);

				playersInT1 = 0;
				playersInT2 = 0;

				for (int i = 0; i < players.length; i++) {
					if (binaryWord.bitAt(i)) {
						t1.setPlayerAt(playersInT1, players[i]);
						playersInT1++;
					} else {
						t2.setPlayerAt(playersInT2, players[i]);
						playersInT2++;
					}
				}

				// Check if we find better balanced teams
				if (Math.abs(t1.getScore() - t2.getScore()) < difference) {
					team1 = t1;
					team2 = t2;
					difference = Math.abs(t1.getScore() - t2.getScore());
				}
			}
			binaryWord.increment();
		} while (binaryWord.toInteger() < Math.pow(2, players.length));

		return new Team[] {
				team1,
				team2
		};
	}
}
