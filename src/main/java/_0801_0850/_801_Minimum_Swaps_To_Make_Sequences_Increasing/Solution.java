package _0801_0850._801_Minimum_Swaps_To_Make_Sequences_Increasing;

public class Solution {
  public int minSwap(int[] A, int[] B) {

    int notSwap = 0, // not swap ith column to make array increasing
        swap = 1; // swap ith column to make array increasing
    for (int i = 1; i < A.length; i++) {
      int nextNotSwap = Integer.MAX_VALUE, nextSwap = Integer.MAX_VALUE;
      if (A[i - 1] < A[i] && B[i - 1] < B[i]) {
        nextNotSwap = notSwap;
        nextSwap = swap + 1;
      }

      if (A[i - 1] < B[i] && B[i - 1] < A[i]) {
        nextNotSwap = Math.min(nextNotSwap, swap);
        nextSwap = Math.min(nextSwap, notSwap + 1);
      }

      assert nextNotSwap != Integer.MAX_VALUE && nextSwap != Integer.MAX_VALUE;

      notSwap = nextNotSwap;
      swap = nextSwap;

//      System.out.println("i = " + i + " Swap " + swap + " Not swap " + notSwap);

    }

    return Math.min(notSwap, swap);
  }
}
