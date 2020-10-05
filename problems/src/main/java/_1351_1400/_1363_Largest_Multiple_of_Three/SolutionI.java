package _1351_1400._1363_Largest_Multiple_of_Three;

/**
 * @author jacka
 * @version 1.0 on 4/25/2020
 */
public final class SolutionI implements Solution {
  private int sum = 0;
  private final int[] counts = new int[10];

  public String largestMultipleOfThree(int[] digits) {
    for (final int d : digits) {
      counts[d]++;
      sum += d;
    }

    boolean ignore = false;
    if (sum % 3 == 0) {
      // no action
    } else if (sum % 3 == 1 && counts[1] + counts[4] + counts[7] > 0) {
      // remove one 1, 4, 7
      ignore = updateCount(1) || updateCount(4) || updateCount(7);
      assert ignore;
    } else if (sum % 3 == 2 && counts[2] + counts[5] + counts[8] > 0) {
      // remove one 2, 5, 8
      ignore = updateCount(2) || updateCount(5) || updateCount(8);
      assert ignore;
    } else if (sum % 3 == 2) {
      // remove two 1, 4, 7
      ignore = updateCount(1) || updateCount(1) ||
          updateCount(4) || updateCount(4)
          || updateCount(7) || updateCount(7);
      assert ignore;
    } else if (sum % 3 == 1) {
      ignore = updateCount(2) || updateCount(5) || updateCount(8);
      assert ignore;
      ignore = updateCount(2) || updateCount(5) || updateCount(8);
      assert ignore;
    }
    if (sum % 3 != 0) {
      return "";
    }
    final StringBuilder sb = new StringBuilder();
    for (int i = 9; i >= 0; --i) {
      if (i == 0) {
        if (sb.length() == 0 && counts[i] > 0) {
          return "0";
        } else if (counts[i] > 0) {
          while (counts[i] > 0) {
            sb.append((char) ('0' + i));
            counts[i]--;
          }
        }
      } else {
        while (counts[i] > 0) {
          sb.append((char) ('0' + i));
          counts[i]--;
        }
      }
    }
    return sb.toString();
  }

  private boolean updateCount(int i) {
    if (counts[i] > 0) {
      counts[i]--;
      sum -= i;
      return true;
    }
    return false;
  }
}
