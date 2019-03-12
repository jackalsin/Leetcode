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
public final class Solution {
  private static final String MOVE = "move", SUPPORT = "support",
      HOLD = "hold", DEAD = "Dead";

  /**
   * @param actions 军队名 地点 1 action (地点 2／军队名)
   * @return Map, Army -> Location
   */
  public Map<String, String> battle(final List<String> actions) {
    if (actions == null) {
      throw new IllegalArgumentException();
    }
    final Map<String, String> result = new HashMap<>();
    final Map<String, Set<String>> supportedToSupporters = new HashMap<>();
    final Map<String, Set<String>> locationToArmy = new HashMap<>();
    final Map<String, String> armyToLocation = new HashMap<>();
    for (final String a : actions) {
      final String[] items = a.split(" ");
      final String t1 = items[0], location = items[1], action = items[2];
      if (MOVE.equals(action)) {
        final String t2 = items[3]; // place
        locationToArmy.get(location).remove(t1);
        locationToArmy.computeIfAbsent(t2, x -> new HashSet<>()).add(t1);
        armyToLocation.put(t1, t2);
      } else if (SUPPORT.equals(action)) {
        final String t2 = items[3];
        supportedToSupporters.computeIfAbsent(t2, x -> new HashSet<>()).add(t1);
      } else if (HOLD.equals(action)) {
        locationToArmy.computeIfAbsent(location, x -> new HashSet<>()).add(t1);
        armyToLocation.put(t1, location);
      } else {
        throw new IllegalArgumentException("Unsupported action = " + action);
      }
    }
    // start battle

    for (final Map.Entry<String, Set<String>> e : locationToArmy.entrySet()) {
      final String location = e.getKey();
      final Set<String> armies = e.getValue();

      // generate strength
      String bestArmy = null;
      int bestStrength = 0;

      for (String a : armies) {
        final int curStrength = getStrength(supportedToSupporters, armyToLocation, locationToArmy, a);
        if (curStrength > bestStrength) {
          bestStrength = curStrength;
          bestArmy = a;
        } else if (curStrength == bestStrength) {
          bestArmy = null;
        }
      }

      for (String a : armies) {
        result.put(a, a.equals(bestArmy) ? location : DEAD);
      }
    }

    return result;
  }

  private int getStrength(final Map<String, Set<String>> supportedToSupporters, final Map<String, String> armyToLocation,
                          final Map<String, Set<String>> locationToArmy, final String a) {
    final Set<String> supporters = supportedToSupporters.getOrDefault(a, new HashSet<>());
    int strength = 1, supporterScore = supporters.size();
    for (final String s : supporters) {
      if (locationToArmy.getOrDefault(armyToLocation.get(s), new HashSet<>()).size() > 1) {
        supporterScore--;
      }
    } // end of for String s
    return strength + supporterScore;
  }

}
