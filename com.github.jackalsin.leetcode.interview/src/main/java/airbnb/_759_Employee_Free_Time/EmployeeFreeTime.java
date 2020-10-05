package airbnb._759_Employee_Free_Time;

import utils.Interval;

import java.util.List;

public interface EmployeeFreeTime {
  List<Interval> employeeFreeTime(List<List<Interval>> schedule, int startTime, int endTime);

}
