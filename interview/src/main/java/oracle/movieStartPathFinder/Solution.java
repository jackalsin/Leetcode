package oracle.movieStartPathFinder;

import java.util.List;
import java.util.Map;

/**
 * @author jacka
 * @version 1.0 on 11/10/2019
 */
public interface Solution {
  // 1. 给出一个<电影明星，电影作品>的字典和任意两个明星，找出他们之间的关系路径。例：约翰有作品1,2,3，汤姆有作品3,4, 山姆有作品4,5。求汤姆和山姆的路径，是约翰->3->汤姆->4->山姆.
  List<String> pathFinder(Map<String, List<String>> startToMovies, final String star1, final String star2);
}
