package _0151_0200._170_Two_Sum_III_Data_structure_design;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    private final Map<Integer, Integer> elemToCounts;
    /** Initialize your data structure here. */
    public TwoSum() {
        elemToCounts = new HashMap<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        elemToCounts.put(number, elemToCounts.getOrDefault(number, 0) + 1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : elemToCounts.entrySet()) {
            int key = entry.getKey();
            int counts = entry.getValue();
            int tgt = value - key;
            if ((key == tgt && counts >= 2)
                    || (key != tgt && elemToCounts.keySet().contains(tgt))) {
                return true;
            }
        }
        return false;
    }
}
