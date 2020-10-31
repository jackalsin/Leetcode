package _1051_1100._1052_Grumpy_Bookstore_Owner;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class SolutionI implements Solution {
  private static final int GRUMPY = 1;

  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    final int n = customers.length;
    int happyCustomers = 0, maxUnhappyInX = 0;
    for (int i = 0, curToAdd = 0; i < n; ++i) {
      if (GRUMPY == grumpy[i]) {
        curToAdd += customers[i];
      } else {
        happyCustomers += customers[i];
      }
      if (i - X >= 0 && grumpy[i - X] == GRUMPY) {
        curToAdd -= customers[i - X];
      }
      if (curToAdd > maxUnhappyInX) {
        maxUnhappyInX = curToAdd;
      }
    }
    return maxUnhappyInX + happyCustomers;
  }
}
