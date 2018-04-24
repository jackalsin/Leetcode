package _451_500._458_Poor_Pigs;

public class Solution {
  public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
    final int state = minutesToTest / minutesToDie + 1;

    return (int) Math.ceil(Math.log(buckets) / Math.log(state));
  }
}
