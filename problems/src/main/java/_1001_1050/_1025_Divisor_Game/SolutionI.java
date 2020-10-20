package _1001_1050._1025_Divisor_Game;

/**
 * @author jacka
 * @version 1.0 on 10/19/2020
 */
public final class SolutionI implements Solution {
  @Override
  public boolean divisorGame(int N) {
    /*
    1) 如果 N 是奇数会 lose，那么 N + 1 必胜
    2） 考虑到奇数只有奇数的factor，那么当走完第一步之后，剩下的一定是偶数（奇数 - 奇数）， 那么小于N的偶数都是先手必胜，
    那么N是先手时， 则必输无疑
    <a href="https://leetcode.com/problems/divisor-game/discuss/274566/just-return-N-2-0-(proof)" />
    * */
    return N % 2 == 0;
  }
}
