package _751_800._765_Couples_Holding_Hands;

public final class GreedySolution implements Solution {

  /**
   * Time O(N)
   * Space O(N)
   */
  @Override
  public int minSwapsCouples(int[] row) {
    final int[] index = new int[row.length];
    for (int i = 0; i < row.length; i++) {
      index[row[i]] = i;
    }
    int count = 0;
    for (int i = 0; i < row.length; i += 2) {

      int partner = getCouple(row[i]), partnerIndex = index[partner];
      if (partnerIndex - i != 1) {
        int swapVal = row[i + 1];
        swap(row, partnerIndex, i + 1);
        index[swapVal] = partnerIndex;
        count++;
      }
    }
    return count;
  }


  private void swap(final int[] row, int i, int j) {
    int tmp = row[i];
    row[i] = row[j];
    row[j] = tmp;
  }

  private int getCouple(int a) {
    return a % 2 == 0 ? a + 1 : a - 1;
  }

}
