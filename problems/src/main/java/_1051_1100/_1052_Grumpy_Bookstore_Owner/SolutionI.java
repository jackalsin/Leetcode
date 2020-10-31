package _1051_1100._1052_Grumpy_Bookstore_Owner;

/**
 * @author jacka
 * @version 1.0 on 10/24/2020
 */
public final class SolutionI implements Solution {
  private static final int GRUMPY = 1;

  public int maxSatisfied(int[] customers, int[] grumpy, int X) {
    final int n = customers.length;
    final int[] unhappyCustomers = new int[n];
    int alreadyHappyCustomers = 0;
    for (int i = 0; i < n; ++i) {
      if (GRUMPY == grumpy[i]) {
        unhappyCustomers[i] = customers[i];
      } else {
        alreadyHappyCustomers += customers[i];
      }
    }
//    System.out.println("already = " + alreadyHappyCustomers);
//    System.out.println("unhappyCustomers = " + Arrays.toString(unhappyCustomers));
    int max = 0;
    for (int i = 0, curAdd = 0; i < n; i++) {
      curAdd += unhappyCustomers[i];
      if (i - X >= 0) {
        curAdd -= unhappyCustomers[i - X];
      }
      max = Math.max(max, curAdd);
    }
    return max + alreadyHappyCustomers;
  }
}
