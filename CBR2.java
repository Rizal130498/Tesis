import java.util.LinkedList;

public class CBR2 {
    int intp;
    int penalty;
    LinkedList<Integer> slots;
    LinkedList<Integer> teams;

    public CBR2(int itp, int pen, LinkedList<Integer> slot, LinkedList<Integer> team)
    {
        intp = itp;  penalty = pen; slots = slot; teams = team;
    }

    public int getIntp() {
        return intp;
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
