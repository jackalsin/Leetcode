package utils;

/**
 * @author Zhiwei.Xin
 * @version 1.0 on 4/20/2017.
 */
public class Interval {
  public int start;
  public int end;

  public Interval() {
    start = 0;
    end = 0;
  }

  public Interval(int s, int e) {
    start = s;
    end = e;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Interval)) {
      return false;
    }

    Interval interval = (Interval) o;

    return end == interval.end && start == interval.start;
  }

  @Override
  public int hashCode() {
    int result = end;
    result = 31 * result + start;
    return result;
  }

  @Override
  public String toString() {
    return "Interval{" +
        "start=" + start +
        ", end=" + end +
        '}';
  }
}


