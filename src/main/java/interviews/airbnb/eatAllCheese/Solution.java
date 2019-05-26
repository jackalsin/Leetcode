package interviews.airbnb.eatAllCheese;

public interface Solution {
  char EMPTY = '.', WALL = '#', START = '@', KEY = 'K';

  int getShortestPath(final char[][] board);

}
