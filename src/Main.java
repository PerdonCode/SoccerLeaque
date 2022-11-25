public class Main {
    public static void main(String[] args) {

        SoccerPlayer beckham = new SoccerPlayer("Beckham");

        Team<SoccerPlayer> psv = new Team<>("PSV");
        Team<SoccerPlayer> ajax = new Team<>("ajax");
        Team<SoccerPlayer> feyenoord = new Team<>("feyenoord");
        feyenoord.addPlayer(beckham);

        psv.matchResult(ajax, 1, 1);
        psv.matchResult(feyenoord, 0 ,1);
        ajax.matchResult(feyenoord, 0 ,0);
        ajax.matchResult(psv, 1,1);
        feyenoord.matchResult(psv, 2,1);
        feyenoord.matchResult(ajax, 4 ,1);

        Leaque<Team<SoccerPlayer>> soccerLeaque = new Leaque<>("Eredivisie");
        soccerLeaque.add(feyenoord);
        soccerLeaque.add(psv);
        soccerLeaque.add(ajax);

        soccerLeaque.ShowLeaqueTables();

    }


}