public class BruteBalancer implements Balancer {

    @Override
    public Team[] balance(Player[] players) {

        Team team1 = new Team(players.length/2);
        Team team2 = new Team(players.length/2);

        Team t1;
        Team t2;

        int playersInT1;
        int playersInT2;

        int difference = 0;
        for(Player player : players) {
            difference += player.getScore();
        }

        BinaryWord binaryWord = new BinaryWord(players.length);
        do {
            if(binaryWord.bitsAtTrue() == players.length/2) {
                t1 = new Team(players.length/2);
                t2 = new Team(players.length/2);

                playersInT1 = 0;
                playersInT2 = 0;

                for(int i = 0; i < players.length; i++) {
                    if(binaryWord.bitAt(i)) {
                        t1.getPlayers()[playersInT1] = players[i];
                        playersInT1++;
                    }
                    else {
                        t2.getPlayers()[playersInT2] = players[i];
                        playersInT2++;
                    }
                }

                if(Math.abs(t1.score() - t2.score()) < difference) {
                    team1 = t1;
                    team2 = t2;
                    difference = Math.abs(t1.score() - t2.score());
                }
            }
            binaryWord.add(1);
        }
        while(binaryWord.toInteger() < Math.pow(2, players.length));


        return new Team[] {team1, team2};
    }
}
