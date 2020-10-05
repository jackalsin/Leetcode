package linkedin._207_Course_Schedule;

/**
 * @author jacka
 * @version 1.0 on 8/5/2019
 */
public interface Solution {
  /**
   * @param numCourses    num of course
   * @param prerequisites edges, child -> parent
   * @return
   */
  boolean canFinish(int numCourses, int[][] prerequisites);
}
