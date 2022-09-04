package hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class Solution76 {

    public String minWindow(String s, String t) {
        Map<Character, LinkedList<Integer>> position = new HashMap<>();
        // init position
        for (char ch : t.toCharArray()) {
            position.put(ch, new LinkedList<>());
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (position.get(ch) != null) {
                position.get(ch).add(i);
            }
        }
        // init TreeSet
        TreeSet<Integer> set = new TreeSet<>();
        for (char ch : t.toCharArray()) {
            Integer cur = position.get(ch).poll();
            if (cur == null) {
                return "";
            }
            set.add(cur);
        }
        // traverse
        int min = set.last() - set.first();
        int[] res = new int[2];
        res[0] = set.first();
        res[1] = set.last();
        while (!set.isEmpty()) {
            int index = set.pollFirst();
            Integer next = position.get(s.charAt(index)).poll();
            if (next == null) {
                break;
            }
            set.add(next);

            if (set.last() - set.first() < min) {
                min = set.last() - set.first();
                res[0] = set.first();
                res[1] = set.last();
            }
        }
        // result
        return s.substring(res[0], res[1] + 1);
    }

    public String minWindowBetter(String s, String t) {
        int[] base = new int['z' - 'A' + 1];
        for (char ch : t.toCharArray()) {
            base[ch - 'A']++;
        }

        int i = 0, min = Integer.MAX_VALUE;
        String res = "";
        int[] cur = new int[base.length];
        for (int j = 0; j < s.length(); j++) {
            cur[s.charAt(j) - 'A']++;
            while (cover(cur, base)) {
                if (j - i + 1 < min) {
                    min = j - i + 1;
                    res = s.substring(i, j + 1);
                }
                cur[s.charAt(i++) - 'A']--;
            }
        }
        return res;
    }

    private boolean cover(int[] cur, int[] base) {
        for (int i = 0; i < cur.length; i++) {
            if (cur[i] < base[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution76 solution = new Solution76();
        System.out.println(solution.minWindow("ADOBECODEBANC",
                "EBOO"));
        System.out.println(solution.minWindowBetter("ADOBECODEBANC",
                "EBOO"));
    }
}
