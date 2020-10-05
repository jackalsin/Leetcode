package uber.diffProdSum;

/**
 * @author jacka
 * @version 1.0 on 12/12/2019
 */
public final class SolutionI implements Solution {
  @Override
  public int diff(int num) {
    assert num > 0;
    int sum = 0, prod = 1;
    while (num > 0) {
      final int digit = num % 10;
      num /= 10;
      sum += digit;
      prod *= digit;
    }
    return prod - sum;
  }
}
