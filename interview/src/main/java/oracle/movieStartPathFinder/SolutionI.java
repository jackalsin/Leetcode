package oracle.movieStartPathFinder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public final class SolutionI implements Solution {
  private final Map<String, List<String>> starToMovies = new HashMap<>();
  private final Map<String, Set<String>> movieToStars = new HashMap<>();
  private final Set<String> visitedStars = new HashSet<>(), visitedPaths = new HashSet<>();
  private List<String> shortestPath = new ArrayList<>();
  private int shortestLen = Integer.MAX_VALUE;

  public List<String> pathFinder(final Map<String, List<String>> starToMovie,
                                 final String star1, final String star2) {
    final List<String> result = new ArrayList<>();
    if (starToMovie == null || star1 == null || star2 == null) {
      return result;
    }
    starToMovies.putAll(starToMovie);
    for (final Map.Entry<String, List<String>> e : starToMovie.entrySet()) {
      final String star = e.getKey();
      final List<String> movies = e.getValue();
      for (final String m : movies) {
        movieToStars.computeIfAbsent(m, k -> new HashSet<>()).add(star);
      }
    }
    // generate
    final List<String> curPath = new ArrayList<>();
    curPath.add(star1);
    dfs(curPath, star2);
    return shortestPath;
  }

  private void dfs(final List<String> curPath, final String target) {
    if (curPath.size() >= shortestLen) {
      return;
    }
    final String start = curPath.get(curPath.size() - 1);
    if (start.equals(target)) {
      shortestLen = curPath.size();
      shortestPath = new ArrayList<>(curPath);
      return;
    }
    final List<String> nextMovies = starToMovies.getOrDefault(start, new ArrayList<>());
    for (final String nextMovie : nextMovies) {
      if (visitedPaths.contains(nextMovie)) continue;
      visitedPaths.add(nextMovie);
      curPath.add(nextMovie);
      final Set<String> nextStars = movieToStars.getOrDefault(nextMovie, new HashSet<>());
      for (final String nextStar : nextStars) {
        if (visitedStars.contains(nextStar)) continue;
        visitedStars.add(nextStar);
        curPath.add(nextStar);
        dfs(curPath, target);
        curPath.remove(curPath.size() - 1);
        visitedStars.remove(nextStar);
      }
      curPath.remove(curPath.size() - 1);
      visitedPaths.remove(nextMovie);
    }
  }
}
