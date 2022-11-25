import java.util.ArrayList;
import java.util.Collections;

public class Leaque <T extends Team>{
    public String name;
    private final ArrayList<T> leaque = new ArrayList<>();

    public Leaque(String name) {
        this.name = name;
    }
    public boolean add(T team){
        if (leaque.contains(team)){
            // already contains team no doubles
            return false;
        }
        leaque.add(team);
        return true;
    }
    public void ShowLeaqueTables(){
        System.out.println("ranking from 1 - " + leaque.size());
        Collections.sort(leaque);
        int count = 1;
        for (T t : leaque){
            System.out.println( count + ". " + t.getName() + " : " + t.ranking() + " P");
            count++;
        }
    }
}

