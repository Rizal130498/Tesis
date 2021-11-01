import java.util.LinkedList;

public class CSE1 {
    int min;
    int penalty;
    LinkedList<Integer> teams;

    public CSE1(int mini, int pen, LinkedList<Integer> team)
    {
        min = mini;  penalty = pen; teams = team;
    }

    public int getMin() {
        return min;
    }

    public int getPenalty() {
        return penalty;
    }

    public LinkedList<Integer> getTeams() {
        return teams;
    }
}
