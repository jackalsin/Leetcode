package interviews.pinterest.battleship;

import java.util.HashMap;
import java.util.Map;

public final class Player {
  private static final int LIVES = 17;

  private int lives;
  private final Map<String, Battleship> ships = new HashMap<>();

  public Player() {
    lives = LIVES;
  }

  public void addShip(final Battleship ship) {
    ships.put(ship.getName(), ship);
    lives += ship.getLength();
  }

  public boolean isDead() {
    return lives == 0;
  }

  public void decreaseLive() {
    assert lives != 0;
    lives--;
  }
}
