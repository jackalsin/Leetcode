package example.greedyAlgorithm;

/**
 * @author jacka
 * @version 1.0 on 10/10/2017.
 */
public final class Activity {
  final int start;
  final int end;

  public Activity(int start, int end) {
    this.start = start;
    this.end = end;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Activity)) {
      return false;
    }

    Activity activity = (Activity) o;

    return start == activity.start && end == activity.end;
  }

  @Override
  public int hashCode() {
    int result = start;
    result = 31 * result + end;
    return result;
  }

  @Override
  public String toString() {
    return "Activity{" +
        "start=" + start +
        ", end=" + end +
        '}';
  }

}
