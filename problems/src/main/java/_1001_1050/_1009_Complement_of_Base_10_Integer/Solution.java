package _1001_1050._1009_Complement_of_Base_10_Integer;

public final class Solution {
  public int bitwiseComplement(int N) {
    int x = 1;
    while (x < N) x = 2 * x + 1;
    return x - N;
  }
}
