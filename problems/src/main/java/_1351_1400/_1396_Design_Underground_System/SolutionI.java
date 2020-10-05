package _1351_1400._1396_Design_Underground_System;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 3/28/2020
 */
public final class SolutionI implements Solution {
  private final Map<Integer, Map<String, Integer>> idToStationToStart = new HashMap<>();
  private final Map<String, Map<String, long[]>> stationToStationToTimeSum = new HashMap<>();

  public void checkIn(int id, String stationName, int t) {
    idToStationToStart.computeIfAbsent(id, k -> new HashMap<>()).put(stationName, t);
  }

  public void checkOut(int id, String stationName, int t) {
    final Map.Entry<String, Integer> stationToStartTime = idToStationToStart.get(id).entrySet().iterator().next();
    idToStationToStart.remove(id);
    final String startStation = stationToStartTime.getKey();
    final long toAdd = t - stationToStartTime.getValue();
    stationToStationToTimeSum.putIfAbsent(startStation, new HashMap<>());
    final Map<String, long[]> endToTimesToTime = stationToStationToTimeSum.get(startStation);
    final long[] prev = endToTimesToTime.getOrDefault(stationName, new long[2]),
        next = new long[]{prev[0] + 1, prev[1] + toAdd};
    endToTimesToTime.put(stationName, next);
  }

  public double getAverageTime(String startStation, String endStation) {
    final long[] e = stationToStationToTimeSum.get(startStation).get(endStation);
    return (double) e[1] / e[0];
  }
}
