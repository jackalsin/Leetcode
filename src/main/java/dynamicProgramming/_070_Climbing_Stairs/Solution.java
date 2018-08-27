package dynamicProgramming._070_Climbing_Stairs;

public class Solution {
  public int climbStairs(int n) {
    assert n > 0;
    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    }
    int n1 = 1, n2 = 2;
    for (int k = 3; k <= n; k++) {
      int n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
    }
    return n2;
  }

}
