package interviews.linkedin._352_Data_Stream_as_Disjoint_Intervals;

import utils.Interval;

import java.util.List;

public interface SummaryRanges {

  void addNum(int val);

  List<Interval> getIntervals();

}
