/**
 * Interface to balance a collection of players into two teams
 * who should have the same number of players and
 * should be as balance as possible (balance depend on the players' score)
 * in a fairly amount of time
 */
public interface Balancer {

    /**
     * Balance a collection of players into two teams
     *
     * @param players an array of players who should be attributed into two teams
     * @return two teams who should be as balance as possible
     */
    public Team[] balance(Player[] players);
}
