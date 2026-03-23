import java.util.ArrayList;
import java.util.List;

public class Nmeetings {
    int start;
    int end;
    int id;

    Nmeetings(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public static void main(String[] args) {
        List<Nmeetings> n = new ArrayList<Nmeetings>();
        n.add(new Nmeetings(0, 5, 1));
        n.add(new Nmeetings(3, 4, 2));
        n.add(new Nmeetings(1, 2, 3));
        n.add(new Nmeetings(5, 9, 4));
        n.add(new Nmeetings(5, 7, 5));
        n.add(new Nmeetings(8, 9, 6));
        n.sort((o1, o2) -> {
            return o1.getEnd() - o2.getEnd();
        });
        for(int i=0;i<n.size();i++){
            System.out.println(n.get(i).getStart()+" "+n.get(i).getEnd());
        }
        int noM = 1;
        int prev = n.get(0).getEnd();
        System.out.println("All meetings are:");
        System.out.println(n.get(0).getStart()+" "+n.get(0).getEnd());
        for (int i = 1; i < n.size(); i++) {
            if (n.get(i).getStart() > prev) {
                prev = n.get(i).getEnd();
                noM++;
                System.out.println(n.get(i).getStart()+" "+n.get(i).getEnd());
            }
        }
        System.out.println(noM);

    }
}