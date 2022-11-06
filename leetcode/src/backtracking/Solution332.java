package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法的应用
 */
public class Solution332 {

    private List<String> res;
    private LinkedList<String> track = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        Collections.sort(tickets, (a, b) -> a.get(1).compareTo(b.get(1)));
        boolean[] used = new boolean[tickets.size()];
        track.addLast("JFK");
        backtracking(tickets, used);
        return res;
    }

    private void backtracking(List<List<String>> tickets, boolean[] used) {
        if (res != null) {
            return;
        }
        if (track.size() == tickets.size() + 1) {
            res = new ArrayList<>(track);
            return;
        }
        for (int i = 0; i < tickets.size(); i++) {
            if (used[i] || !tickets.get(i).get(0).equals(track.getLast())) {
                continue;
            }
            track.addLast(tickets.get(i).get(1));
            used[i] = true;
            backtracking(tickets, used);
            used[i] = false;
            track.removeLast();
        }
    }
}
