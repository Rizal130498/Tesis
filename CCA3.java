import java.util.LinkedList;

public class CCA3 {
    int intp;
    int max;
    int min;
    String mode1;
    int penalty;
    LinkedList<Integer> teams1;
    LinkedList<Integer> teams2;

    public CCA3(int itp, int maxi, int mini, String homemode1, int pen, LinkedList<Integer> team1, LinkedList<Integer> team2)
    {
        intp = itp; max = maxi; min = mini; mode1 = homemode1; penalty = pen; teams1 = team1; teams2 = team2;
    }

    public int getIntp() {
        return intp;
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

    public int getPenalty() {
        return penalty;
    }

    public LinkedList<Integer> getTeams1() {
        return teams1;
    }

    public LinkedList<Integer> getTeams2() {
        return teams2;
    }
}
