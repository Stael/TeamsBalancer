/**
 * Team Class
 * Contains all players and cache the team's score
 */
public class Team implements Comparable<Team> {
    private Player[] players;
    private int      score;

    public Team(int playersByTeam) {
        this.players = new Player[playersByTeam];
        this.score = 0;
    }

    private void updateScore() {
        score = 0;
        for (Player player : players) {
            if (player != null) {
                score += player.getScore();
            }
        }
    }

    /**
     * Check if we should permute two players
     * by comparing the difference between teams' score before and after the permutation
     *
     * @param playerIndex index of the player in the current team we might want to permute
     * @param opponentTeam the opponent team
     * @param opponentPlayerIndex index of the player in the opponent team we might want to permute
     * @return true if we should permute the players in order to improve the team's balance
     */
    public boolean shouldPermutePlayers(int playerIndex, Team opponentTeam, int opponentPlayerIndex) {
        return Math.abs(score - opponentTeam.score) > Math.abs((score - players[playerIndex].getScore() + opponentTeam.players[opponentPlayerIndex].getScore()) - (opponentTeam.score + players[playerIndex].getScore() - opponentTeam.players[opponentPlayerIndex].getScore()));
    }

    public void setPlayerAt(int index, Player player) {
        players[index] = player;
        updateScore();
    }

    public Player getPlayerAt(int index) {
        return players[index];
    }

    @Override
    public String toString() {
        return "Total : " + score;
    }

    @Override
    public int compareTo(Team team) {
        return score - team.score;
    }

    public int getScore() {
        return score;
    }
}
