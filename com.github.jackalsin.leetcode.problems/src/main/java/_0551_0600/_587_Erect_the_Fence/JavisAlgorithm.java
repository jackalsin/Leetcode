package _0551_0600._587_Erect_the_Fence;

import utils.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This solution uses Gift Wrapping Algorithm.
 * https://discuss.leetcode.com/topic/89323/java-solution-convex-hull-algorithm-gift-wrapping-aka-jarvis-march
 * Time complexity O(N^2)
 */
public final class JavisAlgorithm implements Solution {
  @Override
  public List<Point> outerTrees(Point[] points) {
    Set<Point> result = new HashSet<>();
    if (points == null || points.length == 0) {
      return new ArrayList<>();
    }
    int leftMostIndex = 0;
    for (int i = 1; i < points.length; i++) {
      if (points[leftMostIndex].x > points[i].x) {
        leftMostIndex = i;
      }
    }
    int curIndex = leftMostIndex;
    result.add(points[curIndex]);
//    System.out.println("leftMostIndex = " + curIndex);
    do {
//      System.out.println("Adding index = " + curIndex);
      int nextIndex = 0;
      for (int i = 1; i < points.length; i++) {
        if (i == curIndex) continue;
        int crossProduct = crossProduct(points[curIndex], points[nextIndex], points[i]);
        if (crossProduct > 0 ||
            (crossProduct == 0 && (distance(points[curIndex], points[nextIndex]) < distance(points[curIndex], points[i])))
            ) {
          nextIndex = i;
        }
      }
      // handling colinear situation
      for (int i = 0; i < points.length; i++) {
        if (i == curIndex) continue;
        int crossProduct = crossProduct(points[curIndex], points[nextIndex], points[i]);
        if (crossProduct == 0) {
//          System.out.println("Adding index inner = " + i);
          result.add(points[i]);
        }
      }
      curIndex = nextIndex;
    } while (curIndex != leftMostIndex);

    return new ArrayList<>(result);
  }

  private static long distance(Point p1, Point p2) {
    long deltX = (long) p1.x - (long) p2.x;
    long deltY = (long) p1.y - (long) p2.y;
    return deltX * deltX + deltY * deltY;
  }

  private static int crossProduct(Point p1, Point p2, Point p3) {
    return (p2.x - p1.x) * (p3.y - p1.y) - (p2.y - p1.y) * (p3.x - p1.x);
  }
}
