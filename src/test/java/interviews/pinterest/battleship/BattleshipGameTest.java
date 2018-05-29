package interviews.pinterest.battleship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BattleshipGameTest {

  @BeforeEach
  void setUp() {
  }

  @Test
  void testBoard1() {
    final int rows = 10, cols = 10;
    BattleshipGame game = new BattleshipGame(rows, cols, 2);

    game.place(1, new Battleship(Battleship.CARRIER_NAME, 0, 0, Battleship.CARRIER_SIZE, false));
    game.place(1, new Battleship(Battleship.BATTLESHIP_NAME, 1, 0, Battleship.BATTLESHIP_SIZE, false));
    game.place(1, new Battleship(Battleship.CRUISER_NAME, 2, 0, Battleship.CRUISER_SIZE, false));
    game.place(1, new Battleship(Battleship.SUBMARINE_NAME, 3, 0, Battleship.SUBMARINE_SIZE, false));
    game.place(1, new Battleship(Battleship.DESTROYER_NAME, 4, 0, Battleship.DESTROYER_SIZE, false));

    game.place(2, new Battleship(Battleship.CARRIER_NAME, 0, 0, Battleship.CARRIER_SIZE, false));
    game.place(2, new Battleship(Battleship.BATTLESHIP_NAME, 1, 0, Battleship.BATTLESHIP_SIZE, false));
    game.place(2, new Battleship(Battleship.CRUISER_NAME, 2, 0, Battleship.CRUISER_SIZE, false));
    game.place(2, new Battleship(Battleship.SUBMARINE_NAME, 3, 0, Battleship.SUBMARINE_SIZE, false));
    game.place(2, new Battleship(Battleship.DESTROYER_NAME, 4, 0, Battleship.DESTROYER_SIZE, false));

    game.displayBoards();

    game.fire(0, 0);
    game.displayBoards();

    game.fire(1, 0);
    game.displayBoards();

  }
}