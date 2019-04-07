package interviews.airbnb.simulateDiplomacy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 3/10/2019.
 */
public final class SolutionII implements Solution {
  private static final String MOVE = "move", SUPPORT = "support", HOLD = "hold";
  private static final String DEAD = "Dead";

  /**
   * @param actions 军队名 地点 1 action (地点 2／军队名)
   * @return Map, Army -> Location
   */
  public Map<String, String> battle(final List<String> actions) {
    final Map<String, Set<String>> locationToArmies = new HashMap<>();
    final Map<String, String> armyToLocation = new HashMap<>();
    final Map<String, Set<String>> supportedToSupporters = new HashMap<>();
    for (final String a : actions) {
      final String[] items = a.split(" ");
      final String army = items[0], pos1 = items[1], action = items[2];
      if (action.equals(MOVE)) {
        final String dest = items[3];
        armyToLocation.put(army, dest);
        locationToArmies.computeIfAbsent(dest, x -> new HashSet<>()).add(army);
        locationToArmies.get(pos1).remove(army);
        if (locationToArmies.get(pos1).isEmpty()) locationToArmies.remove(pos1);
      } else if (action.equals(SUPPORT)) {
        supportedToSupporters.computeIfAbsent(items[3], x -> new HashSet<>()).add(army);
      } else if (action.equals(HOLD)) {
        armyToLocation.put(army, pos1);
        locationToArmies.computeIfAbsent(pos1, x -> new HashSet<>()).add(army);
      } else {
        throw new UnsupportedOperationException();
      }
    }

    final Map<String, String> result = new HashMap<>();

    for (final Map.Entry<String, Set<String>> e : locationToArmies.entrySet()) {
      final String location = e.getKey();
      final Set<String> armies = e.getValue();
      if (armies.size() == 1) {
        for (String a : armies) result.put(a, location);
      } else {
        int maxSupportScore = 0;
        final Set<String> maxSupported = new HashSet<>();
        for (final String a : armies) {
          final int curSupportScore = getSupportDirectScore(locationToArmies, armyToLocation, supportedToSupporters,
              a);
          if (curSupportScore > maxSupportScore) {
            maxSupportScore = curSupportScore;
            maxSupported.clear();
            maxSupported.add(a);
          } else if (curSupportScore == maxSupportScore) {
            maxSupported.add(a);
          }
        }
        // clean up
        for (String a : armies) {
          result.put(a, DEAD);
        }
        if (maxSupported.size() == 1) {
          for (String a : maxSupported) result.put(a, location);
        }
      }
    }
    return result;
  }

  private int getSupportDirectScore(final Map<String, Set<String>> locationToArmies,
                                    final Map<String, String> armyToLocation,
                                    final Map<String, Set<String>> supportedToSupporters,
                                    final String a) {
    final Set<String> supporters = supportedToSupporters.getOrDefault(a, new HashSet<>());
    int score = 0;
    for (String s : supporters) {
      final String loc = armyToLocation.get(s);
      if (locationToArmies.get(loc).size() > 1) {
        continue;
      }
      score++;
    }
    return score;
  }


  private int getSupportRecursiveScore(final Map<String, Set<String>> locationToArmies,
                                       final Map<String, String> armyToLocation,
                                       final Map<String, Set<String>> supportedToSupporters,
                                       final String a) {
    final Set<String> supporters = supportedToSupporters.getOrDefault(a, new HashSet<>());
    int score = 0;
    for (String s : supporters) {
      final String loc = armyToLocation.get(s);
      if (locationToArmies.get(loc).size() > 1) {
        continue;
      }
      score++;
    }
    return score;
  }
}
