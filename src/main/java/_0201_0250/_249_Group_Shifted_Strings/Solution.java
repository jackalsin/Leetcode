package _0201_0250._249_Group_Shifted_Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 8/23/2017.
 */
public class Solution {
  private static final int AZ_BIAS = 26;

  public List<List<String>> groupStrings(String[] strings) {
    Map<String, List<String>> base = new HashMap<>();
    for(String child : strings) {
      String childBase = child.length() == 0 ? "" : getBase(child);
      List<String> prev = base.getOrDefault(childBase, new ArrayList<>());
      prev.add(child);
      base.put(childBase, prev);
    }
    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<String, List<String>> child : base.entrySet()) {
      result.add(child.getValue());
    }
    return result;
  }

  /**
   * Shift to a word start with 'a'.
   * @param child a String whose length is longer than 1.
   * @return
   */
  private String getBase(String child) {
    assert child.length() != 0;
    int bias = child.charAt(0) - 'a';
    char[] childArray = child.toCharArray();
    for (int i = 0; i < childArray.length; ++i) {
      childArray[i] -= bias;
      if (childArray[i] < 'a') {
        childArray[i] += AZ_BIAS;
      } else if (childArray[i] > 'z') {
        childArray[i] -= AZ_BIAS;
      }
    }
    return new String(childArray);
  }
}
