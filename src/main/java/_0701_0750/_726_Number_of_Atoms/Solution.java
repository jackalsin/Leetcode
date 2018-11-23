package _0701_0750._726_Number_of_Atoms;

import java.util.*;

public class Solution {
  public String countOfAtoms(String formula) {
    final Deque<String> stack = new ArrayDeque<>();
    final char[] chars = formula.toCharArray();
    for (int i = 0; i < chars.length; ) {
      char chr = chars[i];
      if (Character.isLetterOrDigit(chr)) {
        final StringBuilder sb = new StringBuilder().append(chr);
        i++;
        while (i < chars.length && Character.isLowerCase(chars[i])) {
          sb.append(chars[i++]);
        }
        int start = i;
        String count = getFollowingCount(formula, start);
        if (!count.equals("1")) {
          i += count.length();
        }
        stack.addLast(sb.toString());
        stack.addLast(count);

//        System.out.println("Elem = " + sb.toString() + " count = " + count);

      } else if (chr == '(') {
        stack.addLast("(");
        i++;
      } else if (chr == ')') {
        int start = ++i;
        String count = getFollowingCount(formula, start);
        int countInt = Integer.parseInt(count);
        // double the child component
        final Deque<String> temp = new ArrayDeque<>();
        while (!stack.peekLast().equals("(")) {
          int curCount = Integer.parseInt(stack.removeLast());
          temp.addLast(String.valueOf(curCount * countInt));
          temp.addLast(stack.removeLast());
        }
        stack.removeLast();
        while (!temp.isEmpty()) {
          stack.addLast(temp.removeLast());
        }
        i += count.length();
      }
    }

    final Map<String, Integer> counts = new HashMap<>();
    while (!stack.isEmpty()) {
      int curCount = Integer.parseInt(stack.removeLast());
      String str = stack.removeLast();
      counts.put(str, counts.getOrDefault(str, 0) + curCount);
    }

    final List<Map.Entry<String, Integer>> result = new ArrayList<>(counts.entrySet());
    result.sort(new Comparator<Map.Entry<String, Integer>>() {
      @Override
      public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return o1.getKey().compareTo(o2.getKey());
      }
    });

    final StringBuilder sb = new StringBuilder();
    for (Map.Entry<String, Integer> entry : result) {
      final int val = entry.getValue();
      sb.append(entry.getKey()).append(val == 1 ? "" : val);
    }
    return sb.toString();
  }

  /**
   * Return the following count
   *
   * @param formula
   * @param start
   * @return
   */
  private static String getFollowingCount(final String formula, int start) {
    /*
     *  if there is a number, return the number; otherwise, returns 1 since it's default
     */
    int i = start;
    for (; i < formula.length() && Character.isDigit(formula.charAt(i)); i++) ;
    return i == start ? "1" : formula.substring(start, i);
  }


}
