import java.util.LinkedList;

public class CBR1 {
    int intp;
    String mode2;
    int penalty;
    LinkedList<Integer> slots;
    LinkedList<Integer> teams;

    public CBR1(int itp, String homemode2, int pen, LinkedList<Integer> slot, LinkedList<Integer> team)
    {
        intp = itp; mode2 = homemode2; penalty = pen; slots = slot; teams = team;
    }

    public int getIntp() {
        return intp;
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

    public LinkedList<Integer> getTeams() {
        return teams;
    }
}
