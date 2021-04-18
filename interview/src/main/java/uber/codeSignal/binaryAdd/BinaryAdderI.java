package uber.codeSignal.binaryAdd;

/**
 * @author jacka
 * @version 1.0 on 4/17/2021
 */
public final class BinaryAdderI implements BinaryAdder {
  private static final int MAX = 100_000;
  private int oneCount = 0;
  private final int[] nums = new int[MAX];

  public BinaryAdderI(final String num) {
    if (num == null) throw new NullPointerException();
    if (num.isEmpty()) throw new IllegalArgumentException("Cannot be null but " + num);
    final int len = num.length();
    for (int i = len - 1, j = MAX - 1; i >= 0; --i, --j) {
      final int d = num.charAt(i) - '0';
      if (d == 1) oneCount++;
      this.nums[j] = d;
    }
  }

  public int oneCount() {
    return oneCount;
  }

  public void addOne() {
    nums[MAX - 1]++;
    for (int i = MAX - 1, carry = 0; i >= 0; i--) {
      final int sum = carry + nums[i], d = sum % 2;
      if (sum == 2) oneCount--;
      else oneCount++;
      carry = sum / 2;
      nums[i] = d;
      if (carry == 0) break;
    }
  }
}
