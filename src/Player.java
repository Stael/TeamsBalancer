/**
 * Player class
 * Simply materialize a player and associate him to a score
 */
public class Player implements Comparable<Player> {
    private int score;

    public Player(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(Player p) {
        return score - p.score;
    }

    public int getScore() {
        return score;
    }
}
