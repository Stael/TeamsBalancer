import java.util.Arrays;

/**
 * Another implementation of Balancer
 * Doesn't guaranty to find the best solution
 *
 * May looks like a bubble sort
 */
public class ImprovedBalancer implements Balancer {

    @Override
    public Team[] balance(Player[] players) {
        int playersByTeam = players.length / 2;

        Team team1 = new Team(playersByTeam);
        Team team2 = new Team(playersByTeam);

        Arrays.sort(players);
        int index = 0;
        int indexT1 = 0;
        int indexT2 = 0;
        for (Player player : players) {
            if (index % 2 == 0) {
                team1.setPlayerAt(indexT1, player);
                indexT1++;
            } else {
                team2.setPlayerAt(indexT2, player);
                indexT2++;
            }
            index++;
        }

        Player tempPlayer;
        int permutations;
        do {
            permutations = 0;
            for (int i = 0; i < playersByTeam; i++) {
                for (int j = 0; j < playersByTeam; j++) {
                    if (team1.shouldPermutePlayers(i, team2, j)) {
                        tempPlayer = team1.getPlayerAt(i);
                        team1.setPlayerAt(i, team2.getPlayerAt(j));
                        team2.setPlayerAt(j, tempPlayer);
                        permutations++;
                    }
                }
            }
        } while (permutations != 0);

        return new Team[]{team1, team2};
    }
}
