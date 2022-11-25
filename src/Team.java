import java.util.ArrayList;

public class Team<T extends Player> implements Comparable <Team<T>>{
    private final String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tied = 0;

    private final ArrayList<T> members = new ArrayList<>();
    private final ArrayList<Team> teams = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (members.contains(player)) {
            System.out.println(player.getName() + " Already on the team");
            return false;
        } else {
            members.add(player);
            System.out.println(player.getName() + " picked for team " + this.name);
            return true;
        }
    }

    public int numPlayers(){
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore){
        String message;
        String stand =" With " +  ourScore + " - " + theirScore;
        if (ourScore > theirScore){
            won++;
            message = " Beats ";
        } else if (ourScore == theirScore){
            tied++;
            message = " drew with ";
        }else {
            message = " lost to ";
            lost++;
        }
        played++;
        if (opponent != null){
            System.out.println(this.getName() + message + opponent.getName() + stand);
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (won * 3) + tied;
    }

    @Override
    public int compareTo(Team<T> team) {
        if (this.ranking() > team.ranking()){
            return -1;
        } else if (this.ranking()< team.ranking()){
            return 1;
        } else {
            return 0;
        }
    }
}