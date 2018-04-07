package _351_400._390_Elimination_Game;

public class CountSolution implements Solution {
  /**
   * Time Complexity: O(Log N)
   * 3377 / 3377 test cases passed.
   * Status: Accepted
   * Runtime: 113 ms
   *
   * @param n
   * @return
   */
  @Override
  public int lastRemaining(int n) {
    int remain = n, step = 1, head = 1;
    boolean moveFromLeft = true;
    while (remain > 1) {
      if (moveFromLeft || remain % 2 == 1) {
        head += step;
      }
      step *= 2;
      remain /= 2;
      moveFromLeft = !moveFromLeft;
    }
    return head;
  }
}
