package _0801_0850._825_Friends_Of_Appropriate_Ages;

public final class NLogNSolution implements Solution {

  public int numFriendRequests(int[] ages) {
    if (ages == null || ages.length == 0) {
      return 0;
    }
    final SegmentTree st = new SegmentTree(ages);
    int count = 0;
    for (int age = 1; age <= 120; age++) {
      final int aCount = st.get(age, age);
      if (aCount == 0) {
        continue;
      }
      int minB = age / 2 + 7; // exclusive
      int maxB = age; //inclusive
      if (age < 100) {
        maxB = Math.min(maxB, 100);
      }

      if (minB + 1 <= age && age <= maxB) {
        count -= aCount;
      }
      count += aCount * st.get(minB + 1, maxB);
    }
    return count;
  }

  private static final class SegmentTree {
    private final int[] st;
    private final int n;


    private SegmentTree(final int[] values) {
      n = 120 + 1;
      final int height = (int) Math.ceil(Math.log(n) / Math.log(2));
      st = new int[(2 << height) + 1];

      for (int value : values) {
        update(value, 1);
      }
    }

    public void update(int i, int val) {
      updateHelper(0, n - 1, 0, i, val);
    }

    private void updateHelper(final int ss, final int se, int sc, final int i, final int diff) {
      if (ss > i || se < i) {
        return;
      }

      st[sc] += diff;
      if (ss == se) {
        return;
      }
      final int mid = ss + (se - ss) / 2;
      updateHelper(ss, mid, sc * 2 + 1, i, diff);
      updateHelper(mid + 1, se, sc * 2 + 2, i, diff);
    }

    public int get(int rangeStart, int rangeEnd) {
      return getSumRange(rangeStart, rangeEnd, 0, n - 1, 0);
    }

    private int getSumRange(final int queryStart, final int queryEnd, int segmentStart, int segmentEnd,
                            int segmentCur) {
      assert segmentStart <= segmentEnd;
      if (queryStart <= segmentStart && segmentEnd <= queryEnd) {
        return st[segmentCur];
      } else if (queryStart > segmentEnd || queryEnd < segmentStart) {
        return 0;
      } else {
        int mid = (segmentEnd - segmentStart) / 2 + segmentStart;
        return getSumRange(queryStart, queryEnd, segmentStart, mid, 2 * segmentCur + 1)
            + getSumRange(queryStart, queryEnd, mid + 1, segmentEnd, 2 * segmentCur + 2);
      }

    }

  }
}
