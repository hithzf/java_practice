package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 */
public class Solution380 {
    private ArrayList<Integer> list;

    private HashMap<Integer, Integer> map;

    public Solution380() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int lastValue = list.get(list.size() - 1);

        list.set(index, lastValue);
        list.remove(list.size() - 1);

        map.put(lastValue, index);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        return list.get(new Random().nextInt(list.size()));
    }
}
