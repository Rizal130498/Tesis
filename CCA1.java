import java.util.LinkedList;

public class CCA1 {
    int max;
    int min;
    String mode;
    int penalty;
    LinkedList<Integer> slots;
    LinkedList<Integer> teams;

    public CCA1(int maxi, int mini, String homemode, int pen, LinkedList<Integer>slot, LinkedList<Integer>team)
    {
        max = maxi; min = mini; mode = homemode; penalty = pen; slots = slot; teams = team;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public String getMode() {
        return mode;
    }

    public int getPenalty() {
        return penalty;
    }

    public LinkedList<Integer> getSlots() {
        return slots;
    }

    public LinkedList<Integer> getTeams() {
        return teams;
    }
}
