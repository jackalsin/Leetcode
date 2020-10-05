package _1401_1450._1436_Destination_City;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 4/11/2020
 */
public final class SolutionI implements Solution {
  @Override
  public String destCity(List<List<String>> paths) {
    final Set<String> candidate = new HashSet<>();
    for (final List<String> path : paths) {
      final String start = path.get(0), end = path.get(1);
      candidate.add(end);
    }
    for (final List<String> path : paths) {
      final String start = path.get(0), end = path.get(1);
      candidate.remove(start);
    }
    return candidate.iterator().next();
  }
}
