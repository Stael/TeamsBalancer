public class Groups {
    private Player[] team1;
    private Player[] team2;

    public Groups(int length) {
        team1 = new Player[length/2];
        team2 = new Player[length/2];
    }

    public Player[] getTeam1() {
        return team1;
    }

    public Player[] getTeam2() {
        return team2;
    }
}
