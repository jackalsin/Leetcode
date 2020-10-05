package _1401_1450._1450_Number_of_Students_Doing_Homework_at_a_Given_Time;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
    int count = 0;
    for (int i = 0; i < startTime.length; ++i) {
      if (startTime[i] <= queryTime && queryTime <= endTime[i]) {
        count++;
      }
    }
    return count;
  }
}
