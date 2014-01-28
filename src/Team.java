public class Team implements Comparable<Team> {
    private Player[] players;

    public Team(int playersByTeam) {
        this.players = new Player[playersByTeam];
    }

    public int score() {
        int score = 0;
        for (Player player : players) {
            score += player.getScore();
        }
        return score;
    }

    public boolean shouldPermutPlayers(int playerIndex, Team opponentTeam, int opponentPlayerIndex) {
        return Math.abs(score() - opponentTeam.score()) > Math.abs((score() - players[playerIndex].getScore() + opponentTeam.getPlayers()[opponentPlayerIndex].getScore()) - (opponentTeam.score() + players[playerIndex].getScore() - opponentTeam.getPlayers()[opponentPlayerIndex].getScore()));
    }

    public Player[] getPlayers() {
        return players;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for(Player player : players) {
            stringBuilder.append(player.getScore());
            stringBuilder.append('\n');
        }

        stringBuilder.append("Total : ");
        stringBuilder.append(score());
        return stringBuilder.toString();
    }

    @Override
    public int compareTo(Team team) {
        return score() - team.score();
    }
}
