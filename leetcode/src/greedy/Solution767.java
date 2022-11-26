package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution767 {

    public String reorganizeString(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((a, b) -> b.getValue() - a.getValue());

        if (list.get(0).getValue() > (s.length() + 1) / 2) {
            return "";
        }

        char[] res = new char[s.length()];
        int index = 0;
        for (Map.Entry<Character, Integer> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                if (index >= s.length()) {
                    index = 1;
                }
                res[index] = entry.getKey();
                index += 2;
            }
        }
        return String.valueOf(res);
    }
}
