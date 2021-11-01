import java.util.LinkedList;

public class CCA4 {
    int max;
    int min;
    String mode1;
    String mode2;
    int penalty;
    LinkedList<Integer> slots;
    LinkedList<Integer> teams1;
    LinkedList<Integer> teams2;

    public CCA4(int maxi, int mini, String homemode1, String homemode2, int pen, LinkedList<Integer> slot, LinkedList<Integer> team1, LinkedList<Integer> team2)
    {
        max = maxi; min = mini; mode1 = homemode1; mode2 = homemode2; penalty = pen; slots = slot; teams1 = team1; teams2 = team2;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public String getMode1() {
        return mode1;
    }

    public String getMode2() {
        return mode2;
    }

    public int getPenalty() {
        return penalty;
    }

    public LinkedList<Integer> getSlots() {
        return slots;
    }

    public LinkedList<Integer> getTeams1() {
        return teams1;
    }

    public LinkedList<Integer> getTeams2() {
        return teams2;
    }
}
