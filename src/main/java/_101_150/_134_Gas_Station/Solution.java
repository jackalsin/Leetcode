package _101_150._134_Gas_Station;

/**
 * @author jacka
 * @version 1.0 on 7/1/2017.
 */
public class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int start = 0, tank = 0, total = 0;
    for (int i = 0; i < gas.length; i++) {
      int net = gas[i] - cost[i];
      tank = tank + net;
      total += net;
      if(tank < 0) {
        start = i + 1;
        tank = 0;
      }
    }

    return total >= 0 ? start: -1;
  }
}
