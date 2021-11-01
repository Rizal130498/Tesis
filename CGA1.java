import java.util.LinkedList;

public class CGA1 {
    int max;
    LinkedList<Integer[]> meetings;
    int min;
    int penalty;
    LinkedList<Integer> slots;

    public CGA1(int maxi, LinkedList<Integer[]> meet, int mini, int pen, LinkedList<Integer> slot)
    {
        max = maxi; meetings = meet; min = mini; penalty = pen; slots = slot;
    }

    public int getMax() {
        return max;
    }

    public LinkedList<Integer[]> getMeetings() {
        return meetings;
    }

    public int getMin() {
        return min;
    }

    public int getPenalty() {
        return penalty;
    }

    public LinkedList<Integer> getSlots() {
        return slots;
    }
}
