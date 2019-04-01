package interviews.airbnb.travelBuddy;

import java.util.ArrayList;
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
public final class SolutionII implements Solution {
  private final Map<String, List<String>> friendsCities;
  private final Set<String> myCities;
  private static final double THRESHOLD = 0.5;

  public SolutionII(final List<String> myCities, final Map<String, List<String>> friendsCities) {
    this.myCities = new HashSet<>(myCities);
    this.friendsCities = new HashMap<>(friendsCities);
  }

  /**
   * Similarity: overlap / friends cities
   *
   * @return
   */
  public List<String> getTravelBuddies() {
    final TreeMap<Double, List<String>> scoreToNames = new TreeMap<>();
    for (final Map.Entry<String, List<String>> e : friendsCities.entrySet()) {
      final List<String> fCities = e.getValue();
      int match = 0;
      for (final String fc : fCities) {
        if (myCities.contains(fc)) {
          match++;
        }
      }
      if (match * 2L >= fCities.size()) {
        scoreToNames.computeIfAbsent((double) match / fCities.size(), x -> new ArrayList<>()).add(e.getKey());
      }
    }

    final List<String> result = new ArrayList<>();
    while (!scoreToNames.isEmpty()) {
      final List<String> names = scoreToNames.pollLastEntry().getValue();
      result.addAll(names);
    }
    return result;
  }

  @Override
  public List<String> getRecommendList(int size) {
    final List<String> buddies = getTravelBuddies();
    final LinkedHashSet<String> result = new LinkedHashSet<>();
    for (int i = 0; i < buddies.size() && result.size() < size; i++) {
      final String b = buddies.get(i);
      final List<String> bCities = friendsCities.get(b);
      for (int j = 0; j < bCities.size() && result.size() < size; j++) {
        final String bc = bCities.get(j);
        if (myCities.contains(bc)) continue;
        result.add(bc);
      }
    }
    return new ArrayList<>(result);
  }

}
