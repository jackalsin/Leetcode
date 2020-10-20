package _1001_1050._1010_Pairs_of_Songs_With_Total_Durations_Divisible_by_60;

public class Solution {
  public int numPairsDivisibleBy60(int[] time) {
    final int[] count = new int[60];
    int sum = 0;
    for (int t : time) {
      sum += count[(60 - t % 60) % 60];
      count[t % 60]++;
    }
    return sum;
  }
}
