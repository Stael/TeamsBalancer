import java.util.Arrays;

public class ImprovedBalancer implements Balancer {

    @Override
    public Team[] balance(Player[] players) {
        int playersByTeam = players.length/2;
        Team team1 = new Team(playersByTeam);
        Team team2 = new Team(playersByTeam);



        Arrays.sort(players);
        int index = 0;
        int indexT1 = 0;
        int indexT2 = 0;
        for(Player player : players) {
            if(index%2 == 0) {
                team1.getPlayers()[indexT1] = player;
                indexT1++;
            }
            else {
                team2.getPlayers()[indexT2] = player;
                indexT2++;
            }
            index++;
        }

        Player tempPlayer;
        int permutations;
        do {
            permutations = 0;
            for(int i = 0; i < playersByTeam; i++) {
                for(int j = 0; j < playersByTeam; j++) {
                    if(team1.shouldPermutPlayers(i, team2, j)) {
                        tempPlayer = team1.getPlayers()[i];
                        team1.getPlayers()[i] = team2.getPlayers()[j];
                        team2.getPlayers()[j] = tempPlayer;
                        permutations++;
                    }
                }
            }
        }
        while (permutations != 0);

        return new Team[]{team1, team2};
    }
}
