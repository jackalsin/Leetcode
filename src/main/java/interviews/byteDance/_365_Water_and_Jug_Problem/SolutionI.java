package interviews.byteDance._365_Water_and_Jug_Problem;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;


/**
 * @author jacka
 * @version 1.0 on 5/12/2020
 */
public final class SolutionI implements Solution {

  @Override
  public boolean canMeasureWater(int x, int y, int z) {
    if (x + y == z) {
      return true;
    }
    final Queue<State> q = new ArrayDeque<>() {{
      add(new State(x, y));
    }};
    final Set<State> visited = new HashSet<>();
    while (!q.isEmpty()) {
      final State toRemove = q.remove();
      final State fillJag1 = new State(x, toRemove.b, toRemove.path);
      fillJag1.path.add(STEP.FILL_JAG_1);
      if (!visited.contains(fillJag1)) {
        if (isTrue(fillJag1, z)) return true;
        q.add(fillJag1);
        visited.add(fillJag1);
      }

      final State emptyJag1 = new State(0, toRemove.b, toRemove.path);
      if (isTrue(emptyJag1, z)) return true;
      if (!visited.contains(emptyJag1)) {
        emptyJag1.path.add(STEP.EMPTY_JAG_1);
        visited.add(emptyJag1);
        q.add(emptyJag1);
      }
      final State fillJag2 = new State(toRemove.a, y, toRemove.path);
      if (!visited.contains(fillJag2)) {
        if (isTrue(fillJag2, z)) return true;
        fillJag2.path.add(STEP.FILL_JAG_2);
        visited.add(fillJag2);
        q.add(fillJag2);
      }

      final State emptyJag2 = new State(toRemove.a, 0, toRemove.path);
      if (!visited.contains(emptyJag2)) {
        if (isTrue(emptyJag2, z)) return true;
        emptyJag2.path.add(STEP.EMPTY_JAG_2);
        visited.add(emptyJag2);
        q.add(emptyJag2);
      }

      final State pour1To2 = new State(Math.max(0, toRemove.a - (y - toRemove.b)),
          Math.min(y, toRemove.a + toRemove.b),
          toRemove.path);
      if (!visited.contains(pour1To2)) {
        if (isTrue(pour1To2, z)) return true;
        pour1To2.path.add(STEP.POUR_1_TO_2);
        visited.add(pour1To2);
        q.add(pour1To2);
      }

      final State pour2To1 = new State(Math.min(x, toRemove.a + toRemove.b),
          Math.max(0, toRemove.b - (x - toRemove.a)),
          toRemove.path);
      if (!visited.contains(pour2To1)) {
        if (isTrue(pour2To1, z)) return true;
        pour2To1.path.add(STEP.POUR_2_TO_1);
        visited.add(pour2To1);
        q.add(pour2To1);
      }
    }
    return false;
  }

  private static boolean isTrue(State state, final int z) {
    return state.a + state.b == z;
  }

  private static final class State {
    private final int a, b;
    private final List<STEP> path;// = new ArrayList<>();

    private State(int a, int b) {
      this.a = a;
      this.b = b;
      this.path = new ArrayList<>();
    }

    private State(int a, int b, final List<STEP> path) {
      this.a = a;
      this.b = b;
      this.path = new ArrayList<>(path);
    }

    private State(State state) {
      this.a = state.a;
      this.b = state.b;
      this.path = new ArrayList<>(state.path);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof State)) return false;
      State state = (State) o;
      return a == state.a &&
          b == state.b;
    }

    @Override
    public int hashCode() {
      return Objects.hash(a, b);
    }
  }

  enum STEP {
    FILL_JAG_1, EMPTY_JAG_1, FILL_JAG_2, EMPTY_JAG_2, POUR_1_TO_2, POUR_2_TO_1
  }
}
