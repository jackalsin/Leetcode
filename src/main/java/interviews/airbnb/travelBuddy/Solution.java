package interviews.airbnb.travelBuddy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author jacka
 * @version 1.0 on 3/1/2019.
 */
public final class Solution {
  private final List<String> myCities;
  private final Map<String, List<String>> friendsCities;

  public Solution(final List<String> myCities, final Map<String, List<String>> friendsCities) {
    this.myCities = new ArrayList<>(myCities);
    this.friendsCities = new HashMap<>(friendsCities);
  }

  /**
   * Similarity: overlap / friends cities
   *
   * @return
   */
  public List<String> getTravelBuddies() {
    final Set<String> myCitySet = new HashSet<>(myCities);
    final TreeMap<Double, List<String>> resultMap = new TreeMap<>();
    for (final Map.Entry<String, List<String>> f : friendsCities.entrySet()) {
      int overlap = 0;
      final String fName = f.getKey();
      final List<String> fCities = f.getValue();
      for (final String c : fCities) {
        if (myCitySet.contains(c)) overlap++;
      }
      final int citySize = fCities.size();
      if (overlap * 2L >= citySize) {
        resultMap.computeIfAbsent(citySize == 0 ? 0 : (double) overlap / citySize, k -> new ArrayList<>()).add(fName);
      }
    }
    final List<String> result = new ArrayList<>();
    for (final Map.Entry<Double, List<String>> e : resultMap.entrySet()) {
      result.addAll(e.getValue());
    }
    Collections.reverse(result);
    return result;
  }

  public List<String> getRecommendList(final int size) {
    final List<String> travelBuddies = getTravelBuddies();
    final LinkedHashSet<String> result = new LinkedHashSet<>();
    // This is a must
    if (size == 0) {
      return new ArrayList<>(result);
    }
    OUT:
    for (String b : travelBuddies) {
      final List<String> fCity = friendsCities.get(b);
      for (String c : fCity) {
        if (!myCities.contains(c)) {
          result.add(c);
          if (result.size() == size) {
            break OUT;
          }
        }
      } // end of loop city

    }

    return new ArrayList<>(result);
  }

}
