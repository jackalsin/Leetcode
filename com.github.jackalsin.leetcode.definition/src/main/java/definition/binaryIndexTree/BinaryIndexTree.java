package utils.binaryIndexTree;

/**
 * @author jacka
 * @version 1.0 on 9/16/2017.
 */
public final class BinaryIndexTree {

  private final int[] trees;

  private final int n;

  public BinaryIndexTree(int[] input) {
    n = input.length;
    trees = new int[input.length + 1];
    for (int i = 0; i < input.length; ++i) {
      update(i, input[i]);
    }
  }

  public void update(int i, int val) {
    ++i;
    while (i <= n) {
      trees[i] += val;
      i += (i & (-i));
    }
  }

  public int getSum(int i) {
    ++i;
    int sum = 0;
    while (i > 0) {
      sum += trees[i];
      i -= (i & -i);
    }
    return sum;
  }

  int[] getTrees() {
    final int[] result = new int[trees.length];
    System.arraycopy(trees, 0, result, 0, trees.length);
    return result;
  }

}
