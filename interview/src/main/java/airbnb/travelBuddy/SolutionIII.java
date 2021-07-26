package airbnb.travelBuddy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class SolutionIII implements Solution {
  private final Set<String> myCities;
  private final Map<String, List<String>> friendsCities;

  public SolutionIII(final List<String> myCities,
                     final Map<String, List<String>> friendsCities) {
    this.myCities = new HashSet<>(myCities);
    this.friendsCities = new HashMap<>(friendsCities);
  }

  @Override
  public List<String> getTravelBuddies() {
    final TreeMap<Long, List<String>> resultMap = new TreeMap<>();
    for (final var e : friendsCities.entrySet()) {
      final String otherName = e.getKey();
      final List<String> otherCities = e.getValue();
      int match = 0;
      for (final String otherCity : otherCities) {
        if (myCities.contains(otherCity)) match++;
      }
      final long score = match * 2L;
      if (score >= otherCities.size()) {
        resultMap.computeIfAbsent(score, k -> new ArrayList<>()).add(otherName);
      }
    }
    final List<String> result = new ArrayList<>();
    while (!resultMap.isEmpty()) {
      result.addAll(resultMap.pollLastEntry().getValue());
    }
    return result;
  }

  @Override
  public List<String> getRecommendList(int size) {
    final List<String> friends = getTravelBuddies();
    final LinkedHashSet<String> result = new LinkedHashSet<>();
    friendsLoop:
    for (final String f : friends) {
      final List<String> fCities = friendsCities.get(f);
      for (final String fc : fCities) {
        if (myCities.contains(fc)) continue;
        if (result.size() > size - 1) break friendsLoop;
        result.add(fc);
      }
    }
    return new ArrayList<>(result);
  }
}
