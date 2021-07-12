package doordash._759_Employee_Free_Time.mutation;

import definition.Interval;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 7/11/2021
 */
public interface Solution {
  List<Interval> employeeFreeTime(List<List<Interval>> schedule, int start, int end);
}
